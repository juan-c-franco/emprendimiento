package com.growdata.emprendimiento.business.dtos.asistenciatecnica;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.parametrizacion.TemasEvaluacionDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase correspondiente a los Temas Ruta de Acompañamiento.
 * 
 * @author Juan Franco
 */
public class TemasrutaacompanamientoatDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idtemarutaacompanamientoat;
    
    /**
     * Ruta Acompañamiento.
     */
    private RutaacompanamientoatDTO rutaacompanamientoat;
    
    /**
     * Temas de Evaluación.
     */
    private TemasEvaluacionDTO temasevaluacion;
    
    /**
     * Fecha de Registro.
     */
    private Date fecharegistro;
    
    /**
     * Cantidad de Horas Planeadas.
     */
    private BigDecimal cantidadhorasplaneadas;
    
    /**
     * URL del Documento Tema.
     */
    private String urldocumentotema;
    
    /**
     * Descripción del Documento.
     */
    private String descripciondocumento;
    
    /**
     * Cantidad de Horas Ejecutadas.
     */
    private float cantidadHorasEjecutadas;
    
    /**
     * Sesiones de Acompañamiento y Asistencia Técnica.
     */
    private Set<SesionacompanamientoatDTO> sesionacompanamientoats
            = new HashSet<SesionacompanamientoatDTO>(0);

    /**
     * Constructor.
     */
    public TemasrutaacompanamientoatDTO() {
    }

    /**
     * Constructor.
     * 
     * @param idtemarutaacompanamientoat Identidicador Tema Ruta AAT.
     * @param rutaacompanamientoat Ruta de Acompañamiento AAT.
     */
    public TemasrutaacompanamientoatDTO(long idtemarutaacompanamientoat,
            RutaacompanamientoatDTO rutaacompanamientoat) {
        this.idtemarutaacompanamientoat = idtemarutaacompanamientoat;
        this.rutaacompanamientoat = rutaacompanamientoat;
    }

    /**
     * Constructor.
     * @param idtemarutaacompanamientoat Identificador del Tema Ruta AAT.
     * @param rutaacompanamientoat Ruta Acompañamiento AAT.
     * @param temasevaluacion Temas de Evaluación.
     * @param fecharegistro Fecha de Registro.
     * @param urldocumentotema URL Documento Tema.
     * @param descripciondocumento Descripción del documento.
     * @param cantidadhorasplaneadas Cantidad de horas planteadas.
     * @param cantidadHorasEjecutadas Cantidad de horas ejecutadas.
     * @param sesionacompanamientoats  Sesiones de AAT.
     */
    public TemasrutaacompanamientoatDTO(long idtemarutaacompanamientoat,
            RutaacompanamientoatDTO rutaacompanamientoat,
            TemasEvaluacionDTO temasevaluacion, Date fecharegistro,
            String urldocumentotema, String descripciondocumento,
            BigDecimal cantidadhorasplaneadas, int cantidadHorasEjecutadas,
            Set<SesionacompanamientoatDTO> sesionacompanamientoats) {
        this.idtemarutaacompanamientoat = idtemarutaacompanamientoat;
        this.rutaacompanamientoat = rutaacompanamientoat;
        this.temasevaluacion = temasevaluacion;
        this.fecharegistro = fecharegistro;
        this.cantidadhorasplaneadas = cantidadhorasplaneadas;
        this.urldocumentotema = urldocumentotema;
        this.descripciondocumento = descripciondocumento;
        this.cantidadHorasEjecutadas = cantidadHorasEjecutadas;
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdtemarutaacompanamientoat() {
        return this.idtemarutaacompanamientoat;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idtemarutaacompanamientoat Valor a ser actualizado.
     */
    public void setIdtemarutaacompanamientoat(long idtemarutaacompanamientoat) {
        this.idtemarutaacompanamientoat = idtemarutaacompanamientoat;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public RutaacompanamientoatDTO getRutaacompanamientoat() {
        return this.rutaacompanamientoat;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param rutaacompanamientoat Valor a ser actualizado.
     */
    public void setRutaacompanamientoat(
            RutaacompanamientoatDTO rutaacompanamientoat) {
        this.rutaacompanamientoat = rutaacompanamientoat;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public BigDecimal getCantidadhorasplaneadas() {
        return this.cantidadhorasplaneadas;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param cantidadhorasplaneadas Valor a ser actualizado.
     */
    public void setCantidadhorasplaneadas(BigDecimal cantidadhorasplaneadas) {
        this.cantidadhorasplaneadas = cantidadhorasplaneadas;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SesionacompanamientoatDTO> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesionacompanamientoats Valor a ser actualizado.
     */
    public void setSesionacompanamientoats(
            Set<SesionacompanamientoatDTO> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TemasEvaluacionDTO getTemasevaluacion() {
        return temasevaluacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param temasevaluacion Valor a ser actualizado.
     */
    public void setTemasevaluacion(TemasEvaluacionDTO temasevaluacion) {
        this.temasevaluacion = temasevaluacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUrldocumentotema() {
        return urldocumentotema;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param urldocumentotema Valor a ser actualizado.
     */
    public void setUrldocumentotema(String urldocumentotema) {
        this.urldocumentotema = urldocumentotema;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getDescripciondocumento() {
        return descripciondocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param descripciondocumento Valor a ser actualizado.
     */
    public void setDescripciondocumento(String descripciondocumento) {
        this.descripciondocumento = descripciondocumento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public float getCantidadHorasEjecutadas() {
        return cantidadHorasEjecutadas;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param cantidadHorasEjecutadas Valor a ser actualizado.
     */
    public void setCantidadHorasEjecutadas(float cantidadHorasEjecutadas) {
        this.cantidadHorasEjecutadas = cantidadHorasEjecutadas;
    }

}
