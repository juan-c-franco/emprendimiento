package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad encuesta.
 *
 * @author Juan Franco
 */
public class EncuestaDTO implements java.io.Serializable {

    /**
     * Idetificador.
     */
    private long idencuesta;
    /**
     * Datos del beneficiario.
     */
    private BeneficiarioDTO beneficiario;
    /**
     * Tipo de encuesta.
     */
    private TipoencuestaDTO tipoencuesta;
    /**
     * Fecha de envío.
     */
    private Date fechaenvio;
    /**
     * Fecha de vigencia.
     */
    private Date fechavigencia;
    /**
     * Fecha de diligenciamiento.
     */
    private Date fechadiligenciamiento;
    /**
     * Indica si fue diligenciada o no.
     */
    private Character diligenciamiento;
    /**
     * Respuestas.
     */
    private Set<RespuestasencuestaDTO> respuestasencuestas
            = new HashSet<RespuestasencuestaDTO>(0);

    /**
     * Constructor.
     */
    public EncuestaDTO() {
    }

    /**
     * Constructor.
     *
     * @param idencuesta Identificador.
     * @param beneficiario Datos del beneficiario.
     * @param tipoencuesta Tipo de encuesta.
     */
    public EncuestaDTO(long idencuesta, BeneficiarioDTO beneficiario,
            TipoencuestaDTO tipoencuesta) {
        this.idencuesta = idencuesta;
        this.beneficiario = beneficiario;
        this.tipoencuesta = tipoencuesta;
    }

    /**
     * Constructor.
     *
     * @param idencuesta Identificador.
     * @param beneficiario Datos del beneficiario.
     * @param tipoencuesta Tipo de encuesta.
     * @param fechaenvio Fecha de envío.
     * @param fechavigencia Fecha de vigencia.
     * @param fechadiligenciamiento Fecha de diligenciamiento.
     * @param diligenciamiento Fue diligenciada o no?
     * @param respuestasencuestas Respuestas.
     */
    public EncuestaDTO(long idencuesta, BeneficiarioDTO beneficiario,
            TipoencuestaDTO tipoencuesta, Date fechaenvio, Date fechavigencia,
            Date fechadiligenciamiento, Character diligenciamiento,
            Set<RespuestasencuestaDTO> respuestasencuestas) {
        this.idencuesta = idencuesta;
        this.beneficiario = beneficiario;
        this.tipoencuesta = tipoencuesta;
        this.fechaenvio = fechaenvio;
        this.fechavigencia = fechavigencia;
        this.fechadiligenciamiento = fechadiligenciamiento;
        this.diligenciamiento = diligenciamiento;
        this.respuestasencuestas = respuestasencuestas;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdencuesta() {
        return this.idencuesta;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idencuesta Valor a ser actualizado.
     */
    public void setIdencuesta(long idencuesta) {
        this.idencuesta = idencuesta;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BeneficiarioDTO getBeneficiario() {
        return this.beneficiario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param beneficiario Valor a ser actualizado.
     */
    public void setBeneficiario(BeneficiarioDTO beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipoencuestaDTO getTipoencuesta() {
        return this.tipoencuesta;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoencuesta Valor a ser actualizado.
     */
    public void setTipoencuesta(TipoencuestaDTO tipoencuesta) {
        this.tipoencuesta = tipoencuesta;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFechaenvio() {
        return this.fechaenvio;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechaenvio Valor a ser actualizado.
     */
    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFechavigencia() {
        return this.fechavigencia;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechavigencia Valor a ser actualizado.
     */
    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFechadiligenciamiento() {
        return this.fechadiligenciamiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fechadiligenciamiento Valor a ser actualizado.
     */
    public void setFechadiligenciamiento(Date fechadiligenciamiento) {
        this.fechadiligenciamiento = fechadiligenciamiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Character getDiligenciamiento() {
        return this.diligenciamiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param diligenciamiento Valor a ser actualizado.
     */
    public void setDiligenciamiento(Character diligenciamiento) {
        this.diligenciamiento = diligenciamiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<RespuestasencuestaDTO> getRespuestasencuestas() {
        return this.respuestasencuestas;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param respuestasencuestas Valor a ser actualizado.
     */
    public void setRespuestasencuestas(
            Set<RespuestasencuestaDTO> respuestasencuestas) {
        this.respuestasencuestas = respuestasencuestas;
    }

}
