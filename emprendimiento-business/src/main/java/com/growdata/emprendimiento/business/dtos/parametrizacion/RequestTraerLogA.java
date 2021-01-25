package com.growdata.emprendimiento.business.dtos.parametrizacion;

import java.util.Date;

public class RequestTraerLogA {

    private Date fechaI;
    private Date fechaF;

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

}
