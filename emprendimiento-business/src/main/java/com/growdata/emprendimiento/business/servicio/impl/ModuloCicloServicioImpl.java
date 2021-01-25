/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio.impl;

import com.growdata.emprendimiento.business.dtos.capacitacion.RequestModulocicloCheck;
import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseModulocicloCheck;
import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestModuloCiclo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseModulosCiclo;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerModulo;
import com.growdata.emprendimiento.business.commons.Acciones;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.listModuloToListModuloDTO;
import static com.growdata.emprendimiento.business.commons.EntityToDTO.moduloToModuloDTO;
import com.growdata.emprendimiento.business.commons.LoggerEmprendimiento;
import com.growdata.emprendimiento.business.commons.Mensajes;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.ModulocicloDTO;
import com.growdata.emprendimiento.business.servicio.ModuloCicloServicio;
import com.growdata.emprendimiento.persistence.DAO.ModuloCicloDAO;
import com.growdata.emprendimiento.persistence.entidad.Modulociclo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andr�s Felipe Gonz�lez M. Andres Gonzalez
 */
@Service
public class ModuloCicloServicioImpl implements ModuloCicloServicio {

    @Autowired
    private ModuloCicloDAO moduloCicloDAO;
    @Autowired
    private LoggerEmprendimiento log;

    /**
     * M�todo que trae todos los m�dulos parametrizados en el sistema
     *
     * @return Una respuesta que contiene una lista con todos los m�dulos
     * parametrizados en el sistema
     */
    @Override
    public ResponseModulosCiclo getModulos() {
        ResponseModulosCiclo response = new ResponseModulosCiclo();
        try {
            List<Modulociclo> modulos = moduloCicloDAO.getModulos();
            List<ModulocicloDTO> modulosDTO = listModuloToListModuloDTO(modulos);
            response.setModulos(modulosDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_MODULOS);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_MODULOS);
        }
        return response;
    }

    /**
     * M�todo que crea un m�dulo
     *
     * @param request Contiene toda la informaci�n del m�dulo a crear
     * @return Una respuesta si se cre� el m�dulo exitosamente o no
     */
    @Override
    public ResponseDTO crearModulo(RequestModuloCiclo request) {
        ResponseDTO response = new ResponseDTO();
        Modulociclo modulo = new Modulociclo();
        modulo.setCapacitacionprograma(request.getCapacitacionPrograma());
        modulo.setFecharegistro(new Date());
        modulo.setIntensidadhoraria(request.getIntensidadhoraria());
        modulo.setNombremodulociclo(request.getNombremodulociclo());
        try {
            Modulociclo validacion = moduloCicloDAO.traerModuloporNombre(modulo.getNombremodulociclo(), -1, modulo.getCapacitacionprograma().getIdcapacitacionprograma());
            if (validacion == null) {
                long id = moduloCicloDAO.crearModulo(modulo);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_CREAR_MODULO);
                response.setAccion(Acciones.CREAR_MODULO);
                response.setId(id);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_MODULO_REPETIDO);
            }
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_CREAR_MODULO);
        }
        return response;
    }

    /**
     * M�todo que actualiza un m�dulo
     *
     * @param request Contiene toda la informaci�n del m�dulo a actualizar
     * @return Una respuesta si se actualiz� el m�dulo exitosamente o no
     */
    @Override
    public ResponseDTO modificarModulo(RequestModuloCiclo request) {
        ResponseDTO response = new ResponseDTO();
        Modulociclo modulo = new Modulociclo();
        modulo.setCapacitacionprograma(request.getCapacitacionPrograma());
        modulo.setIntensidadhoraria(request.getIntensidadhoraria());
        modulo.setNombremodulociclo(request.getNombremodulociclo());
        modulo.setIdmodulociclo(request.getIdmodulociclo());
        try {
            Modulociclo validacion = moduloCicloDAO.traerModuloporNombre(modulo.getNombremodulociclo(), modulo.getIdmodulociclo(), modulo.getCapacitacionprograma().getIdcapacitacionprograma());
            if (validacion == null) {
                moduloCicloDAO.modificarModulo(modulo);
                response.setStatus("1");
                response.setDescripcion(Mensajes.EXITO_MODIFICAR_MODULO);
                response.setAccion(Acciones.CREAR_MODULO);
            } else {
                response.setStatus("0");
                response.setDescripcion(Mensajes.ERROR_MODULO_REPETIDO);
            }

        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_MODIFICAR_MODULO);
        }
        return response;
    }

    /**
     * Metodo que trae un m�dulo a partir de su id
     *
     * @param request Contiene el id del m�dulo a traer
     * @return Una respuesta que contiene un m�dulo
     */
    @Override
    public ResponseTraerModulo traerModulo(RequestModuloCiclo request) {
        ResponseTraerModulo response = new ResponseTraerModulo();
        try {
            Modulociclo modulo = moduloCicloDAO.traerModulo(request.getIdmodulociclo());
            ModulocicloDTO moduloDTO = moduloToModuloDTO(modulo);
            response.setModulo(moduloDTO);
            response.setStatus("1");
            response.setDescripcion(Mensajes.EXITO_TRAER_MODULOS);
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_MODULOS);
        }
        return response;
    }

    /**
     * M�todo encargado de verificar si una serie de Modulosciclo est�n
     * definidos para cierta programaci�n.
     *
     * @param request Lista de Modulosciclo
     * @param idProgramcion Identificaci�n de la Programaci�n.
     * @return Respuesta si fue exitosa o no la consulta, junto con los modulos
     * que son v�lidos y las lineas donde aparecen.
     */
    @Override
    public ResponseModulocicloCheck check(List<RequestModulocicloCheck> request, BigDecimal idProgramcion) {
        ResponseModulocicloCheck response = new ResponseModulocicloCheck();
        try {
            response.setList(request);
            for (RequestModulocicloCheck r : response.getList()) {
                r.setInvalid(moduloCicloDAO.moduloCheck(r.getIdmodulociclo(), idProgramcion));
            }
            response.setDescripcion(Mensajes.EXITO_TRAER_MODULOS);
            response.setStatus("1");
        } catch (Exception ex) {
            log.writeToLogFile(ex);
            response.setStatus("0");
            response.setDescripcion(Mensajes.ERROR_TRAER_MODULOS);
        }
        return response;
    }

}
