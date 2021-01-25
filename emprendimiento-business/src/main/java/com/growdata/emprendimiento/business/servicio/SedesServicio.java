/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.capacitacion.ResponseSedes;
import java.math.BigDecimal;

/**
 *
 * @author Juan Franco
 */
public interface SedesServicio {

    public ResponseSedes getSedesPorOferente(BigDecimal idoferenteinstitucion);

    public ResponseSedes getSedes();

    public ResponseSedes getSedePorID(BigDecimal id);

    public ResponseSedes getSedesPorMunicipio(BigDecimal municipio);

    public ResponseSedes getSedesPorId(BigDecimal Id);

}
