/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.valoracion.RequestGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.dtos.valoracion.ResponseGuardarTemasValoracionInd;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.DTOToEntity.listaTemasRutaCapacitacionDTOToListaTemasRutaCapacitacion;
import com.growdata.emprendimiento.business.commons.EnviarEmail;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.persistence.DAO.BeneficiarioDAO;
import com.growdata.emprendimiento.persistence.DAO.TemasRutaCapacitacionDAO;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Temasrutacapacitacion;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.growdata.emprendimiento.business.servicio.TemasRutaCapacitacionServicio;

/**
 *
 * @author Andrés Felipe González M. Grow Data PC
 */
@Service
public class TemasRutaCapacitacionServicioImpl implements TemasRutaCapacitacionServicio {

    @Autowired
    private TemasRutaCapacitacionDAO temasRutaCapacitacionDAO;
    @Autowired
    private BeneficiarioDAO beneficiarioDAO;
    @Autowired
    private EnviarEmail enviarEmail;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * Metodo que crea temas de capacitacion
     *
     * @param request Contiene el id de la ruta, el id del beneficiario y una
     * lista con los temas a crear
     * @return Respuesta si se crearon los temas satisfactoriamente o no
     */
    @Override
    public ResponseGuardarTemasValoracionInd crearTemas(RequestGuardarTemasValoracionInd request) {
        ResponseGuardarTemasValoracionInd response = new ResponseGuardarTemasValoracionInd();
//        EnviarEmail enviarEmail = new EnviarEmail();
        try {
            Beneficiario beneficiario = beneficiarioDAO.getBeneficiarioPorId(request.getIdbeneficiario());
            Date date = new Date();
//            String cuerpo="Los temas de capacitacion y su duracion en horas a los que debe asistir son los siguientes: <br/>";
            String cuerpo = "";
            List<Temasrutacapacitacion> temasRuta = listaTemasRutaCapacitacionDTOToListaTemasRutaCapacitacion(request.getTemasRuta());
            for (Temasrutacapacitacion temas : temasRuta) {
                temas.setFecharregistro(date);

                cuerpo = cuerpo + "Tema: " + temas.getNombretema() + " Cantidad de horas: " + temas.getCantidadhorasplaneadas() + " <br>";
            }
            long estadoCrearTema = temasRutaCapacitacionDAO.crearTema(temasRuta);
            if (estadoCrearTema == 1) {
                enviarEmail.setNombres(beneficiario.getPrimernombre() + " " 
                        + (beneficiario.getSegundonombre() != null ? 
                                beneficiario.getSegundonombre() : ""));
                enviarEmail.setApellidos(beneficiario.getPrimerapellido() + " " 
                        + (beneficiario.getSegundoapellido() != null ? 
                                beneficiario.getSegundoapellido() : ""));
                enviarEmail.setTemasRuta(cuerpo);

                enviarEmail.notificarGenerica(31, beneficiario.getEmail());

//            enviarEmail.enviarEmail(beneficiario.getEmail(), "Resultados Valoracion individual", cuerpo);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CREAR_TEMAS_INDIVIDUALES);
                response.setAccion(Acciones.REGISTRAR_TEMAS_R_CAP);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_TEMAS_INDIVIDUALES_YA_VALORADOS);
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
