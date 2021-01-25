package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.dtos.intentodto.PreguntasDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.TemasevaluacionDTO;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class HerramientaValoracionDTO {

    private BigDecimal idHerramienta;
    private String nombreHerramienta;
    private String descripcion;
    private Set<PreguntasDTO> preguntases = new HashSet<PreguntasDTO>(0);
    private Set<TemasevaluacionDTO> temasevaluacions = new HashSet<TemasevaluacionDTO>(0);

    public HerramientaValoracionDTO() {
    }

    public HerramientaValoracionDTO(BigDecimal idHerramienta, String nombreHerramienta, String descripcion) {
        this.idHerramienta = idHerramienta;
        this.nombreHerramienta = nombreHerramienta;
        this.descripcion = descripcion;
    }

    public HerramientaValoracionDTO(BigDecimal idHerramienta, String nombreHerramienta, String descripcion, Set<PreguntasDTO> preguntases, Set<TemasevaluacionDTO> temasevaluacions) {
        this.idHerramienta = idHerramienta;
        this.nombreHerramienta = nombreHerramienta;
        this.descripcion = descripcion;
        this.preguntases = preguntases;
        this.temasevaluacions = temasevaluacions;
    }

    public BigDecimal getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(BigDecimal idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<PreguntasDTO> getPreguntases() {
        return preguntases;
    }

    public void setPreguntases(Set<PreguntasDTO> preguntases) {
        this.preguntases = preguntases;
    }

    public Set<TemasevaluacionDTO> getTemasevaluacions() {
        return temasevaluacions;
    }

    public void setTemasevaluacions(Set<TemasevaluacionDTO> temasevaluacions) {
        this.temasevaluacions = temasevaluacions;
    }
}
