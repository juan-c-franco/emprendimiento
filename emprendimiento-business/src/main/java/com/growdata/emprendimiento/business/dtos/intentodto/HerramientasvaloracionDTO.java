package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad herramientas de valoraci�n.
 *
 * @author Juan Franco
 */
public class HerramientasvaloracionDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idherramienta;
    /**
     * Nombre de la herramienta.
     */
    private String nombreherramienta;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Preguntas.
     */
    private Set<PreguntasDTO> preguntases = new HashSet<PreguntasDTO>(0);
    /**
     * Temas de evaluaci�n.
     */
    private Set<TemasevaluacionDTO> temasevaluacions
            = new HashSet<TemasevaluacionDTO>(0);

    /**
     * Constructor.
     */
    public HerramientasvaloracionDTO() {
    }

    /**
     * Constructor.
     *
     * @param idherramienta
     */
    public HerramientasvaloracionDTO(BigDecimal idherramienta) {
        this.idherramienta = idherramienta;
    }

    /**
     * Constructor.
     *
     * @param idherramienta Identificador.
     * @param nombreherramienta Nombre.
     * @param descripcion Descripci�n.
     * @param preguntases Preguntas.
     * @param temasevaluacions Temas de evaluaci�n.
     */
    public HerramientasvaloracionDTO(BigDecimal idherramienta,
            String nombreherramienta, String descripcion,
            Set<PreguntasDTO> preguntases,
            Set<TemasevaluacionDTO> temasevaluacions) {
        this.idherramienta = idherramienta;
        this.nombreherramienta = nombreherramienta;
        this.descripcion = descripcion;
        this.preguntases = preguntases;
        this.temasevaluacions = temasevaluacions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdherramienta() {
        return this.idherramienta;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idherramienta Valor a ser actualizado.
     */
    public void setIdherramienta(BigDecimal idherramienta) {
        this.idherramienta = idherramienta;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreherramienta() {
        return this.nombreherramienta;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreherramienta Valor a ser actualizado.
     */
    public void setNombreherramienta(String nombreherramienta) {
        this.nombreherramienta = nombreherramienta;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param descripcion Valor a ser actualizado.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<PreguntasDTO> getPreguntases() {
        return this.preguntases;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param preguntases Valor a ser actualizado.
     */
    public void setPreguntases(Set<PreguntasDTO> preguntases) {
        this.preguntases = preguntases;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<TemasevaluacionDTO> getTemasevaluacions() {
        return this.temasevaluacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasevaluacions Valor a ser actualizado.
     */
    public void setTemasevaluacions(Set<TemasevaluacionDTO> temasevaluacions) {
        this.temasevaluacions = temasevaluacions;
    }

}
