/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseAlumnos;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.AlumnosDTO;
import java.math.BigDecimal;

/**
 *
 * @author Juan Franco
 */
public interface AlumnosServicio {

    public ResponseAlumnos getLista(BigDecimal idprogramacion);

    public ResponseDTO asociarBeneficiarioProgramacion(BigDecimal idprogramacion,
            long idBeneficiario, long idFuncionario);
    
    public ResponseAlumnos getAlumnoPorDocumento(String tipo, String numeroDocumento,
            BigDecimal idProgramacion);

}
