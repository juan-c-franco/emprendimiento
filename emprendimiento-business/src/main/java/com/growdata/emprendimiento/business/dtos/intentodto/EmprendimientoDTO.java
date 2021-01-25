package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.RutaacompanamientoatDTO;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Emprendimiento.
 *
 * @author Juan Franco
 */
public class EmprendimientoDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idemprendimiento;
    /**
     * Estado del emprendimiento.
     */
    private EstadoemprendimientoDTO estadoemprendimiento;
    /**
     * Indica si es un emprendimiento formalizado o no.
     */
    private Integer formalizado;
    /**
     * Tipo del emprendimiento.
     */
    private TipoemprendimientoDTO tipoemprendimiento;
    /**
     * Nombre del emprendimiento.
     */
    private String nombreemprendimiento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Rutas de AAT.
     */
    private Set<RutaacompanamientoatDTO> rutaacompanamientoats = new HashSet<RutaacompanamientoatDTO>(0);
    /**
     * Formalizados.
     */
    private Set<FormalizadoDTO> formalizados = new HashSet<FormalizadoDTO>(0);
    /**
     * Documentos.
     */
    private Set<DocumentosDTO> documentoses = new HashSet<DocumentosDTO>(0);
    /**
     * Emprendimientos no formalizados.
     */
    private Set<NoestablecidoDTO> noestablecidos = new HashSet<NoestablecidoDTO>(0);
    /**
     * Beneficiarios asociados.
     */
    private Set<AsociadosDTO> asociadoses = new HashSet<AsociadosDTO>(0);
    /**
     * Evaluaciones.
     */
    private Set<EvaluacionemprendimientoDTO> evaluacionemprendimientos = new HashSet<EvaluacionemprendimientoDTO>(0);
    /**
     * Financiaciones.
     */
    private Set<FinanciacionDTO> financiacions = new HashSet<FinanciacionDTO>(0);
    /**
     * Seguimientos.
     */
    private Set<SeguimientoDTO> seguimientos = new HashSet<SeguimientoDTO>(0);
    /**
     * Log estado del emprendimiento.
     */
    private Set<LogestadoemprendimientoDTO> logestadoemprendimientos = new HashSet<LogestadoemprendimientoDTO>(0);

    /**
     * Constructor.
     */
    public EmprendimientoDTO() {
    }

    /**
     * Constructor.
     *
     * @param idemprendimiento Identificador.
     * @param estadoemprendimiento Estado del emprendimiento.
     * @param tipoemprendimiento Tipo de emprendimiento.
     */
    public EmprendimientoDTO(long idemprendimiento,
            EstadoemprendimientoDTO estadoemprendimiento,
            TipoemprendimientoDTO tipoemprendimiento) {
        this.idemprendimiento = idemprendimiento;
        this.estadoemprendimiento = estadoemprendimiento;
        this.tipoemprendimiento = tipoemprendimiento;
    }

    /**
     * Constructor.
     *
     * @param idemprendimiento Identificador.
     * @param estadoemprendimiento Estado del emprendimiento.
     * @param formalizado Indica si es formalizado o no.
     * @param tipoemprendimiento Tipo de emprendimiento.
     * @param nombreemprendimiento Nombre del emprendimiento.
     * @param fecharegistro Fecha de registro.
     * @param rutaacompanamientoats Rutas de AAT.
     * @param formalizados Emprendimientos formalizados.
     * @param documentoses Documentos.
     * @param noestablecidos Emprendimientos no formalizados.
     * @param asociadoses Beneficiarios asociados.
     * @param evaluacionemprendimientos Evaluaciones.
     * @param financiacions Financiaciones.
     * @param seguimientos Seguimientos.
     * @param logestadoemprendimientos Registros log estados emprendimiento.
     */
    public EmprendimientoDTO(long idemprendimiento,
            EstadoemprendimientoDTO estadoemprendimiento,
            Integer formalizado, TipoemprendimientoDTO tipoemprendimiento,
            String nombreemprendimiento, Date fecharegistro,
            Set<RutaacompanamientoatDTO> rutaacompanamientoats,
            Set<FormalizadoDTO> formalizados, Set<DocumentosDTO> documentoses,
            Set<NoestablecidoDTO> noestablecidos,
            Set<AsociadosDTO> asociadoses,
            Set<EvaluacionemprendimientoDTO> evaluacionemprendimientos,
            Set<FinanciacionDTO> financiacions,
            Set<SeguimientoDTO> seguimientos,
            Set<LogestadoemprendimientoDTO> logestadoemprendimientos) {
        this.idemprendimiento = idemprendimiento;
        this.estadoemprendimiento = estadoemprendimiento;
        this.formalizado = formalizado;
        this.tipoemprendimiento = tipoemprendimiento;
        this.nombreemprendimiento = nombreemprendimiento;
        this.fecharegistro = fecharegistro;
        this.rutaacompanamientoats = rutaacompanamientoats;
        this.formalizados = formalizados;
        this.documentoses = documentoses;
        this.noestablecidos = noestablecidos;
        this.asociadoses = asociadoses;
        this.evaluacionemprendimientos = evaluacionemprendimientos;
        this.financiacions = financiacions;
        this.seguimientos = seguimientos;
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdemprendimiento() {
        return this.idemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idemprendimiento Valor a ser actualizado.
     */
    public void setIdemprendimiento(long idemprendimiento) {
        this.idemprendimiento = idemprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadoemprendimientoDTO getEstadoemprendimiento() {
        return this.estadoemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadoemprendimiento Valor a ser actualizado.
     */
    public void setEstadoemprendimiento(
            EstadoemprendimientoDTO estadoemprendimiento) {
        this.estadoemprendimiento = estadoemprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Integer getFormalizado() {
        return this.formalizado;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param formalizado Valor a ser actualizado.
     */
    public void setFormalizado(Integer formalizado) {
        this.formalizado = formalizado;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipoemprendimientoDTO getTipoemprendimiento() {
        return this.tipoemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoemprendimiento Valor a ser actualizado.
     */
    public void setTipoemprendimiento(
            TipoemprendimientoDTO tipoemprendimiento) {
        this.tipoemprendimiento = tipoemprendimiento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreemprendimiento() {
        return this.nombreemprendimiento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param nombreemprendimiento Valor a ser actualizado.
     */
    public void setNombreemprendimiento(String nombreemprendimiento) {
        this.nombreemprendimiento = nombreemprendimiento;
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
    public Set<RutaacompanamientoatDTO> getRutaacompanamientoats() {
        return this.rutaacompanamientoats;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param rutaacompanamientoats Valor a ser actualizado.
     */
    public void setRutaacompanamientoats(
            Set<RutaacompanamientoatDTO> rutaacompanamientoats) {
        this.rutaacompanamientoats = rutaacompanamientoats;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<FormalizadoDTO> getFormalizados() {
        return this.formalizados;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param formalizados Valor a ser actualizado.
     */
    public void setFormalizados(Set<FormalizadoDTO> formalizados) {
        this.formalizados = formalizados;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<DocumentosDTO> getDocumentoses() {
        return this.documentoses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param documentoses Valor a ser actualizado.
     */
    public void setDocumentoses(Set<DocumentosDTO> documentoses) {
        this.documentoses = documentoses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<NoestablecidoDTO> getNoestablecidos() {
        return this.noestablecidos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param noestablecidos Valor a ser actualizado.
     */
    public void setNoestablecidos(Set<NoestablecidoDTO> noestablecidos) {
        this.noestablecidos = noestablecidos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<AsociadosDTO> getAsociadoses() {
        return this.asociadoses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param asociadoses Valor a ser actualizado.
     */
    public void setAsociadoses(Set<AsociadosDTO> asociadoses) {
        this.asociadoses = asociadoses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EvaluacionemprendimientoDTO> getEvaluacionemprendimientos() {
        return this.evaluacionemprendimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param evaluacionemprendimientos Valor a ser actualizado.
     */
    public void setEvaluacionemprendimientos(
            Set<EvaluacionemprendimientoDTO> evaluacionemprendimientos) {
        this.evaluacionemprendimientos = evaluacionemprendimientos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<FinanciacionDTO> getFinanciacions() {
        return this.financiacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param financiacions Valor a ser actualizado.
     */
    public void setFinanciacions(Set<FinanciacionDTO> financiacions) {
        this.financiacions = financiacions;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SeguimientoDTO> getSeguimientos() {
        return this.seguimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param seguimientos Valor a ser actualizado.
     */
    public void setSeguimientos(Set<SeguimientoDTO> seguimientos) {
        this.seguimientos = seguimientos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<LogestadoemprendimientoDTO> getLogestadoemprendimientos() {
        return this.logestadoemprendimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param logestadoemprendimientos Valor a ser actualizado.
     */
    public void setLogestadoemprendimientos(
            Set<LogestadoemprendimientoDTO> logestadoemprendimientos) {
        this.logestadoemprendimientos = logestadoemprendimientos;
    }

}
