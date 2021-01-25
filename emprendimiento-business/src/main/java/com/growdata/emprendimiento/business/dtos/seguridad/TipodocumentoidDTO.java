package com.growdata.emprendimiento.business.dtos.seguridad;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.intentodto.BeneficiarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocentesDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa los objetos Tipodocumentoid.
 *
 * @author Juan Franco
 */
public class TipodocumentoidDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private BigDecimal idtipodocumento;
    /**
     * Nombre del Documento.
     */
    private String nombredocumento;
    /**
     * Descripci�n.
     */
    private String descripcion;
    /**
     * Lista de funcionarios.
     */
    private Set<FuncionarioDTO> funcionarios = new HashSet<FuncionarioDTO>(0);
    /**
     * Lista de docentes.
     */
    private Set<DocentesDTO> docenteses = new HashSet<DocentesDTO>(0);
    /**
     * Lista de beneficiarios.
     */
    private Set<BeneficiarioDTO> beneficiarios
            = new HashSet<BeneficiarioDTO>(0);

    /**
     * Constructor.
     */
    public TipodocumentoidDTO() {
    }

    /**
     * Constructor.
     *
     * @param idtipodocumento Identificador del tipo de documento.
     * @param nombredocumento Nombre del documento.
     * @param descripcion Descripci�n.
     */
    public TipodocumentoidDTO(BigDecimal idtipodocumento,
            String nombredocumento, String descripcion) {
        this.idtipodocumento = idtipodocumento;
        this.nombredocumento = nombredocumento;
        this.descripcion = descripcion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getIdtipodocumento() {
        return idtipodocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idtipodocumento Valor a ser actualizado.
     */
    public void setIdtipodocumento(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombredocumento() {
        return nombredocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombredocumento Valor a ser actualizado.
     */
    public void setNombredocumento(String nombredocumento) {
        this.nombredocumento = nombredocumento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripcion() {
        return descripcion;
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
    public Set<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param funcionarios Valor a ser actualizado.
     */
    public void setFuncionarios(Set<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<DocentesDTO> getDocenteses() {
        return docenteses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param docenteses Valor a ser actualizado.
     */
    public void setDocenteses(Set<DocentesDTO> docenteses) {
        this.docenteses = docenteses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<BeneficiarioDTO> getBeneficiarios() {
        return beneficiarios;
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
