/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.CantidadSis;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarRespuestasV;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarRespuestasVInd;
import com.growdata.emprendimiento.business.dtos.valoracion.RespuestasValorV;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listaTemasRutaCapacitacionToListaTemasRutaCapacitacionDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import com.growdata.emprendimiento.business.servicio.RutaCapacitacionServicio;
import com.growdata.emprendimiento.persistence.DAO.RutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasEvaluacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Rutacapacitacion;
import com.growdata.emprendimiento.persistence.entidad.Temasevaluacion;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
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
public class RutaCapacitacionServicioImpl implements RutaCapacitacionServicio {

    @Autowired
    private TemasEvaluacionDAO temasEvaluacionDAO;
    @Autowired
    private RutaCapacitacionDAO rutaCapacitacionDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que crea la ruta de capacitación y suigere horas de capacitación
     * para cada tema a partir de las respuestas de la encuesta de valoración
     *
     * @param request Contiene el id del beneficiario y las respuestas de la
     * encuesta de valoración
     * @return Una lista con los temas de ruta
     */
    @Override
    public ResponseGuardarRespuestasVInd crearRutaCapacitacion(RequestGuardarRespuestasV request) {
        ResponseGuardarRespuestasVInd response = new ResponseGuardarRespuestasVInd();
        List<RespuestasValorV> respuestasV = request.getRespuestasV();
        List<Temasrutacapacitacion> temasRutaLista = new ArrayList();
        BigDecimal aux;
        BigDecimal actual = respuestasV.get(0).getIdtema();
        int cantidadSi = 0;
        List<CantidadSis> siS = new ArrayList();
        long idRuta = -2;
        int i = 0;
        Date date = new Date();
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
            Rutacapacitacion ruta = new Rutacapacitacion();
            Rutacapacitacion ruta2 = new Rutacapacitacion();
            ruta2 = rutaCapacitacionDAO.getRuta(request.getIdBeneficiario());
            if (ruta2 != null) {
                idRuta = ruta2.getIdrutacapacitacion();
            } else {
                Beneficiario beneficiario = new Beneficiario();
                beneficiario.setIdbeneficiario(request.getIdBeneficiario());

                ruta.setFecharegistro(date);
                ruta.setBeneficiario(beneficiario);
                idRuta = rutaCapacitacionDAO.crearRuta(ruta);
                response.setAccion(Acciones.REGISTRAR_RUTA);
                response.setId(idRuta);
            }

            if (idRuta != -1) {
                ruta.setIdrutacapacitacion(idRuta);
                for (int j = 0; j < siS.size(); j++) {
                    Temasevaluacion tema = new Temasevaluacion();
                    tema = temasEvaluacionDAO.traerTemasPorTema(siS.get(j).getIdtema());
                    Temasrutacapacitacion temasRuta = new Temasrutacapacitacion();
                    temasRuta.setFecharregistro(date);
                    temasRuta.setNombretema(tema.getNombretema());
                    temasRuta.setRutacapacitacion(ruta);
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
                List<TemasrutacapacitacionDTO> temasDTO = listaTemasRutaCapacitacionToListaTemasRutaCapacitacionDTO(temasRutaLista);
                response.setTemasRuta(temasDTO);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CREAR_TEMAS_RUTA);
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
        return response;
    }
}
