/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.dtos.valoracion.CantidadSis;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarRespuestasVGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarRespuestasVGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.RespuestasValorV;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaTemasAcompanamientoToListaTemasAcompanamientoDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.servicio.RutaAcompanamientoATServicio;
import com.growdata.emprendimiento.persistence.DAO.RutaAcompanamientoATDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Emprendimiento;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static oracle.jrockit.jfr.events.Bits.intValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class RutaAcompanamientoATServicioImpl implements RutaAcompanamientoATServicio {

    @Autowired
    private RutaAcompanamientoATDAO rutaAcompanamientoATDAO;
    @Autowired
    private TemasEvaluacionDAO temasEvaluacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que crea la ruta de capacitacion y sugiere horas de acompañamiento
     * para cada tema a partir de las respuestas de la encuesta de valoración
     *
     * @param request Contiene el id del emprendimiento y las respuestas de la
     * encuesta de valoración
     * @return Una lista con los temas de la ruta y el id de la ruta
     */
    @Override
    public ResponseGuardarRespuestasVGrupal crearRutaAcompanamientoAT(RequestGuardarRespuestasVGrupal request) {
        ResponseGuardarRespuestasVGrupal response = new ResponseGuardarRespuestasVGrupal();

        List<RespuestasValorV> respuestasV = request.getRespuestasV();
        List<Temasrutaacompanamientoat> temasRutaLista = new ArrayList();
        BigDecimal aux;
        BigDecimal actual = respuestasV.get(0).getIdtema();
        int cantidadSi = 0;
        List<CantidadSis> siS = new ArrayList();
        long idRuta = -2;
        Date date = new Date();
        int i = 0;
        //consigo la cantidad de si por Tema
        while (i < respuestasV.size()) {

            aux = respuestasV.get(i).getIdtema();
            if (actual.longValue() != aux.longValue()) {
                CantidadSis cant = new CantidadSis();
                cant.setCantidadSI(cantidadSi);
                cant.setIdtema(actual);
                siS.add(cant);
                actual = aux;
                cantidadSi = 0;

            } else {
                if ("1".equals(respuestasV.get(i).getRespuesta())) {
                    cantidadSi++;
                }
                i++;
                if (i == respuestasV.size()) {
                    CantidadSis cant = new CantidadSis();
                    cant.setCantidadSI(cantidadSi);
                    cant.setIdtema(actual);
                    siS.add(cant);
                }

            }

        }

        try {
            Rutaacompanamientoat ruta = new Rutaacompanamientoat();
            Rutaacompanamientoat ruta2 = new Rutaacompanamientoat();
            ruta2 = rutaAcompanamientoATDAO.getRuta(request.getIdEmprendimiento());
            if (ruta2 != null) {
                idRuta = ruta2.getIdrutaacompanamientoat();
            } else {
                Emprendimiento emprendimiento = new Emprendimiento();
                emprendimiento.setIdemprendimiento(request.getIdEmprendimiento());

                ruta.setFecharegistro(date);
                ruta.setEmprendimiento(emprendimiento);
                idRuta = rutaAcompanamientoATDAO.crearRuta(ruta);
                response.setIdRuta(idRuta);
                response.setAccion(Acciones.REGISTRAR_RUTA_ACOM);
                response.setId(idRuta);
            }

            if (idRuta != -1) {
                ruta.setIdrutaacompanamientoat(idRuta);
                for (int j = 0; j < siS.size(); j++) {
                    Temasevaluacion tema = new Temasevaluacion();
                    tema = temasEvaluacionDAO.traerTemasPorTema(siS.get(j).getIdtema());
                    Temasrutaacompanamientoat temasRuta = new Temasrutaacompanamientoat();
                    temasRuta.setFecharegistro(date);
                    temasRuta.setRutaacompanamientoat(ruta);
                    temasRuta.setTemasevaluacion(tema);
                    if (siS.get(j).getCantidadSI() <= tema.getCalificacionbasico()) {
                        temasRuta.setCantidadhorasplaneadas(tema.getHorasbasico());
                        temasRutaLista.add(temasRuta);
                    } else if (siS.get(j).getCantidadSI() > tema.getCalificacionbasico() && siS.get(j).getCantidadSI() <= intValue(tema.getCalificacionintermedio())) {
                        BigDecimal b = new BigDecimal(tema.getHorasintermedio());
                        temasRuta.setCantidadhorasplaneadas(b);
                        temasRutaLista.add(temasRuta);
                    } else if (siS.get(j).getCantidadSI() > intValue(tema.getCalificacionintermedio())) {
                        temasRuta.setCantidadhorasplaneadas(tema.getHorasavanzado());
                        temasRutaLista.add(temasRuta);
                    }
                }
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_CREAR_RUTA);
            }

            if (temasRutaLista.size() > 0) {
                List<TemasrutaacompanamientoatDTO> temasDTO = listaTemasAcompanamientoToListaTemasAcompanamientoDTO(temasRutaLista);
                response.setTemasRuta(temasDTO);
                response.setStatus("1");

                response.setDescripcion(Mensajes.EXITO_CREAR_TEMAS_ACOMPANAMIENTO);
            }
        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setStatus("0");
            response.setDescripcion(ex.getMessage());
        }
        response.setIdRuta(idRuta);
        return response;
    }

}
