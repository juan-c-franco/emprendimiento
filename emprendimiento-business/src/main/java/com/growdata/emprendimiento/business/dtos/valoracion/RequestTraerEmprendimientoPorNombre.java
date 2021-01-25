package com.growdata.emprendimiento.business.dtos.valoracion;

import java.math.BigDecimal;
import java.util.List;

public class RequestTraerEmprendimientoPorNombre {

    private String nombreEmprendimiento;
    private List<String> estados;
    private BigDecimal idcajacompensacion;

    public BigDecimal getIdcajacompensacion() {
        return idcajacompensacion;
    }

    public void setIdcajacompensacion(BigDecimal idcajacompensacion) {
        this.idcajacompensacion = idcajacompensacion;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

}
