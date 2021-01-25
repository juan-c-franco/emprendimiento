/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionGrupal;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.commons.Acciones;
import com.growdata.emprendimiento.business.commons.DTOToEntity;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.persistence.DAO.AsociadoDAO;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaAcompanamientoATDAO;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.growdata.emprendimiento.business.servicio.TemasRutaAcompanamientoatServicio;
import com.growdata.emprendimiento.persistence.DAO.EmprendimientoDAO;
import com.growdata.emprendimiento.persistence.entidad.Estadoemprendimiento;
import java.math.BigDecimal;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class TemasRutaAcompanamientoatServicioImpl implements TemasRutaAcompanamientoatServicio {

    @Autowired
    private TemasRutaAcompanamientoATDAO temasRutaAcompanamientoATDAO;
    @Autowired
    private AsociadoDAO asociadoDAO;
    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private EnviarEmail enviarEmail;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que crea temas de acompañamiento
     *
     * @param request Contiene el id del emprendimiento y una lista con los
     * temas a crear
     * @return Respuesta si se crearon los temas satisfactoriamente o no
     */
    @Override
    public ResponseGuardarTemasValoracionInd crearTemas(RequestGuardarTemasValoracionGrupal request) {
        ResponseGuardarTemasValoracionInd response = new ResponseGuardarTemasValoracionInd();
//        EnviarEmail enviarEmail = new EnviarEmail();
        List<Asociados> asociados = new ArrayList();
        try {

//            String cuerpo = "Los temas de capacitacion y su duracion en horas a los que debe asistir son los siguientes: <br/>";
            String cuerpo = "";
            Estadoemprendimiento estadoEmprendimiento = new Estadoemprendimiento();
            estadoEmprendimiento.setDescripcion("Estado del emprendimiento para el registro de la información financiera");
            estadoEmprendimiento.setNombreestadoemprendimiento("Registro de información financiera");
            estadoEmprendimiento.setIdestadoemprendimiento(new BigDecimal(2));
            List<Temasrutaacompanamientoat> temasRuta = DTOToEntity.listaTemasRutaAcompanamientoatDTO2ToListaTemasRutaAcompanamientoat2(request.getTemasRuta());
            for (Temasrutaacompanamientoat temas : temasRuta) {
                cuerpo = cuerpo + "Tema: " + temas.getTemasevaluacion().getNombretema() + " Cantidad de horas: " + temas.getCantidadhorasplaneadas() + " <br/>";
            }
            long estadoCrearTemas = temasRutaAcompanamientoATDAO.crearTema(temasRuta, request.getIdEmprendimiento(), estadoEmprendimiento);
            if (estadoCrearTemas == 1) {
                asociados = asociadoDAO.getAsociadosPorEmprendimiento2(request.getIdEmprendimiento());
                if (asociados.size() > 0) {
                    for (int j = 0; j < asociados.size(); j++) {
                        Beneficiario beneficiario = beneficiarioDAO.getBeneficiarioPorId(asociados.get(j).getBeneficiario().getIdbeneficiario());
                        enviarEmail.setNombres(beneficiario.getPrimernombre() + " " + (beneficiario.getSegundonombre() != null ? beneficiario.getSegundonombre() : ""));
                        enviarEmail.setApellidos(beneficiario.getPrimerapellido() + " " + (beneficiario.getSegundoapellido() != null ? beneficiario.getSegundoapellido() : ""));
                        enviarEmail.setTemasRuta(cuerpo);
                        enviarEmail.notificarGenerica(30, beneficiario.getEmail());
//                    enviarEmail.enviarEmail(beneficiario.getEmail(), "Resultados Valoracion Grupal", cuerpo);
                    }

//                emprendimientoDAO.updateEmprendimiento(request.getIdEmprendimiento(), estadoEmprendimiento);
                    response.setStatus("1");
                    response.setDescripcion(Mensajes.EXITO_CREAR_TEMAS_ACOMPANAMIENTO);
                    response.setAccion(Acciones.REGISTRAR_TEMAS_R_ACOM);
                } else {
                    response.setStatus("0");
                    response.setDescripcion(Mensajes.ERROR_EMPRENDIMIENTO_SIN_ASOCIADOS);
                }

            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_TEMAS_GRUPALES_YA_VALORADOS);
            }

        } catch (Exception ex) {
            if (ex.getCause() != null) {
                log.writeToLogFile(new Exception(ex.getMessage(), ex.getCause()));
            } else {
                log.writeToLogFile(ex);
            }
            response.setDescripcion(ex.getMessage());
            response.setStatus("0");
        }
        return response;
    }

}
