package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Clase representante de la entidad Documentos.
 *
 * @author Juan Franco
 */
public class DocumentosDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long iddocumento;
    /**
     * Datos del beneficiario.
     */
    private BeneficiarioDTO beneficiario;
    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Tipo de documento.
     */
    private TipodocumentosDTO tipodocumentos;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Ruta del archivo.
     */
    private String urlarchivo;

    /**
     * Constructor.
     */
    public DocumentosDTO() {
    }

    /**
     * Constructor.
     *
     * @param iddocumento Identificador.
     * @param beneficiario Datos del Beneficiario.
     * @param emprendimiento Datos del Emprendimiento.
     * @param tipodocumentos Tipo de documento.
     */
    public DocumentosDTO(long iddocumento, BeneficiarioDTO beneficiario,
            EmprendimientoDTO emprendimiento,
            TipodocumentosDTO tipodocumentos) {
        this.iddocumento = iddocumento;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
        this.tipodocumentos = tipodocumentos;
    }

    /**
     * Constructor.
     *
     * @param iddocumento Identificador.
     * @param beneficiario Datos del beneficiario.
     * @param emprendimiento Datos del emprendimiento.
     * @param tipodocumentos Tipo de documento.
     * @param fecharegistro Fecha de registro.
     * @param urlarchivo Ruta del archivo.
     */
    public DocumentosDTO(long iddocumento, BeneficiarioDTO beneficiario,
            EmprendimientoDTO emprendimiento, TipodocumentosDTO tipodocumentos,
            Date fecharegistro, String urlarchivo) {
        this.iddocumento = iddocumento;
        this.beneficiario = beneficiario;
        this.emprendimiento = emprendimiento;
        this.tipodocumentos = tipodocumentos;
        this.fecharegistro = fecharegistro;
        this.urlarchivo = urlarchivo;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIddocumento() {
        return this.iddocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param iddocumento Valor a ser actualizado.
     */
    public void setIddocumento(long iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BeneficiarioDTO getBeneficiario() {
        return this.beneficiario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param beneficiario Valor a ser actualizado.
     */
    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipodocumentosDTO getTipodocumentos() {
        return this.tipodocumentos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipodocumentos Valor a ser actualizado.
     */
    public void setTipodocumentos(TipodocumentosDTO tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUrlarchivo() {
        return this.urlarchivo;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param urlarchivo Valor a ser actualizado.
     */
    public void setUrlarchivo(String urlarchivo) {
        this.urlarchivo = urlarchivo;
    }

}
