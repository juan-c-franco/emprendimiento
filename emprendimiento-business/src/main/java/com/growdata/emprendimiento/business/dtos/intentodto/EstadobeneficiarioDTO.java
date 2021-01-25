package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad estadobeneficiario.
 *
 * @author Juan Franco
 */
public class EstadobeneficiarioDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idestadobeneficiario;
    /**
     * Nombre del estado.
     */
    private String nombreestadobeneficiario;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Beneficiarios.
     */
    private Set<BeneficiarioDTO> beneficiarios
            = new HashSet<BeneficiarioDTO>(0);

    /**
     * Constructor.
     */
    public EstadobeneficiarioDTO() {
    }

    /**
     * Constructor.
     *
     * @param idestadobeneficiario Identificador.
     */
    public EstadobeneficiarioDTO(BigDecimal idestadobeneficiario) {
        this.idestadobeneficiario = idestadobeneficiario;
    }

    /**
     * Constructor.
     *
     * @param idestadobeneficiario Identificador.
     * @param nombreestadobeneficiario Nombre del estado.
     * @param descripcion Descripci�n.
     * @param beneficiarios Beneficiarios.
     */
    public EstadobeneficiarioDTO(BigDecimal idestadobeneficiario,
            String nombreestadobeneficiario, String descripcion,
            Set<BeneficiarioDTO> beneficiarios) {
        this.idestadobeneficiario = idestadobeneficiario;
        this.nombreestadobeneficiario = nombreestadobeneficiario;
        this.descripcion = descripcion;
        this.beneficiarios = beneficiarios;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdestadobeneficiario() {
        return this.idestadobeneficiario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idestadobeneficiario Valor a ser actualizado.
     */
    public void setIdestadobeneficiario(BigDecimal idestadobeneficiario) {
        this.idestadobeneficiario = idestadobeneficiario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreestadobeneficiario() {
        return this.nombreestadobeneficiario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreestadobeneficiario Valor a ser actualizado.
     */
    public void setNombreestadobeneficiario(String nombreestadobeneficiario) {
        this.nombreestadobeneficiario = nombreestadobeneficiario;
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
    public Set<BeneficiarioDTO> getBeneficiarios() {
        return this.beneficiarios;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param beneficiarios Valor a ser actualizado.
     */
    public void setBeneficiarios(Set<BeneficiarioDTO> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

}
