package com.growdata.emprendimiento.business.dtos.intentodto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad departamentos.
 *
 * @author Juan Franco
 */
public class DepartamentosDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal id;
    /**
     * C�digo.
     */
    private String divipola;
    /**
     * Nombre.
     */
    private String nombre;
    /**
     * Sedes.
     */
    private Set<SedesDTO> sedeses = new HashSet<SedesDTO>(0);
    /**
     * Municipios.
     */
    private Set<MunicipiosDTO> municipioses = new HashSet<MunicipiosDTO>(0);

    /**
     * Constructor.
     */
    public DepartamentosDTO() {
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     */
    public DepartamentosDTO(BigDecimal id) {
        this.id = id;
    }

    /**
     * Constructor.
     *
     * @param id Identificador.
     * @param divipola C�digo.
     * @param nombre Nombre.
     */
    public DepartamentosDTO(BigDecimal id, String divipola, String nombre) {
        this.id = id;
        this.divipola = divipola;
        this.nombre = nombre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param id Valor a ser actualizado.
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDivipola() {
        return divipola;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param divipola Valor a ser actualizado.
     */
    public void setDivipola(String divipola) {
        this.divipola = divipola;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombre Valor a ser actualizado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SedesDTO> getSedeses() {
        return sedeses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sedeses Valor a ser actualizado.
     */
    public void setSedeses(Set<SedesDTO> sedeses) {
        this.sedeses = sedeses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<MunicipiosDTO> getMunicipioses() {
        return municipioses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param municipioses Valor a ser actualizado.
     */
    public void setMunicipioses(Set<MunicipiosDTO> municipioses) {
        this.municipioses = municipioses;
    }

}
