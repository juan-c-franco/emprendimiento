/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.valoracion;

import java.math.BigDecimal;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class RequestRompimientoDeFases {

    private BigDecimal idEstadoASaltar;
    private long idEmprendimiento;

    public BigDecimal getIdEstadoASaltar() {
        return idEstadoASaltar;
    }

    public void setIdEstadoASaltar(BigDecimal idEstadoASaltar) {
        this.idEstadoASaltar = idEstadoASaltar;
    }

    public long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

}
