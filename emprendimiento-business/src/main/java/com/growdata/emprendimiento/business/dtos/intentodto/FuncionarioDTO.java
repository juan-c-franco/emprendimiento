package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.seguridad.TipodocumentoidDTO;
import com.growdata.emprendimiento.business.dtos.asistenciatecnica.SesionacompanamientoatDTO;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad funcionario.
 *
 * @author Juan Franco
 */
public class FuncionarioDTO implements java.io.Serializable {

    /**
     * Identificador del funcionario.
     */
    private long idfuncionario;
    /**
     * Tipo de documento de identificación.
     */
    private TipodocumentoidDTO tipodocumentoid;
    /**
     * Datos de la caja de compensación.
     */
    private CajacompensacionDTO cajacompensacion;
    /**
     * Estado del funcionario.
     */
    private EstadofuncionarioDTO estadofuncionario;
    /**
     * Primer nombre.
     */
    private String primernombre;
    /**
     * Primer apellido.
     */
    private String primerapellido;
    /**
     * Segundo nombre.
     */
    private String segundonombre;
    /**
     * Segundo apellido.
     */
    private String segundoapellido;
    /**
     * Correo electrónico.
     */
    private String email;
    /**
     * Teléfono.
     */
    private long telefono;
    /**
     * Número de documento.
     */
    private String numerodocumento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Aprobaciones.
     */
    private Set<AprobacionDTO> aprobacions = new HashSet<AprobacionDTO>(0);
    /**
     * Seguimientos asistencia.
     */
    private Set<SeguimientoasistenciaDTO> seguimientoasistencias
            = new HashSet<SeguimientoasistenciaDTO>(0);
    /**
     * Programaciones.
     */
    private Set<ProgramacionDTO> programacions
            = new HashSet<ProgramacionDTO>(0);
    /**
     * Alumnos.
     */
    private Set<AlumnosDTO> alumnoses = new HashSet<AlumnosDTO>(0);
    /**
     * Datos del usuario.
     */
    private UsersDTO users;
    /**
     * Sesiones.
     */
    private Set<SesionesDTO> sesioneses = new HashSet<SesionesDTO>(0);
    /**
     * Sesiones AAT
     */
    private Set<SesionacompanamientoatDTO> sesionacompanamientoats
            = new HashSet<SesionacompanamientoatDTO>(0);
    /**
     * Evaluaciones comité.
     */
    private Set<EvaluacionintegrantescomiteDTO> evaluacionintegrantescomites
            = new HashSet<EvaluacionintegrantescomiteDTO>(0);
    /**
     * Sesiones comité.
     */
    private Set<SesioncomiteDTO> sesioncomites
            = new HashSet<SesioncomiteDTO>(0);
    /**
     * Financiaciones.
     */
    private Set<FinanciacionDTO> financiacions
            = new HashSet<FinanciacionDTO>(0);
    /**
     * Observaciones.
     */
    private Set<ObservacionesDTO> observacioneses
            = new HashSet<ObservacionesDTO>(0);
    /**
     * Observaciones seguimiento.
     */
    private Set<ObservacionesseguimientoDTO> observacionesseguimientos
            = new HashSet<ObservacionesseguimientoDTO>(0);
    /**
     * Integrantes comité.
     */
    private Set<IntegrantescomiteDTO> integrantescomites
            = new HashSet<IntegrantescomiteDTO>(0);
    /**
     * Seguimientos.
     */
    private Set<SeguimientoDTO> seguimientos = new HashSet<SeguimientoDTO>(0);

    /**
     * Constructor.
     */
    public FuncionarioDTO() {
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdfuncionario() {
        return idfuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idfuncionario Valor a ser actualizado.
     */
    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipodocumentoidDTO getTipodocumentoid() {
        return tipodocumentoid;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipodocumentoid Valor a ser actualizado.
     */
    public void setTipodocumentoid(TipodocumentoidDTO tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public CajacompensacionDTO getCajacompensacion() {
        return cajacompensacion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param cajacompensacion Valor a ser actualizado.
     */
    public void setCajacompensacion(CajacompensacionDTO cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadofuncionarioDTO getEstadofuncionario() {
        return estadofuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadofuncionario Valor a ser actualizado.
     */
    public void setEstadofuncionario(EstadofuncionarioDTO estadofuncionario) {
        this.estadofuncionario = estadofuncionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimernombre() {
        return primernombre;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param primernombre Valor a ser actualizado.
     */
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimerapellido() {
        return primerapellido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param primerapellido Valor a ser actualizado.
     */
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundonombre() {
        return segundonombre;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param segundonombre Valor a ser actualizado.
     */
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundoapellido() {
        return segundoapellido;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param segundoapellido Valor a ser actualizado.
     */
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param email Valor a ser actualizado.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return telefono;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param telefono Valor a ser actualizado.
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param numerodocumento Valor a ser actualizado.
     */
    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
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
    public Set<AprobacionDTO> getAprobacions() {
        return aprobacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param aprobacions Valor a ser actualizado.
     */
    public void setAprobacions(Set<AprobacionDTO> aprobacions) {
        this.aprobacions = aprobacions;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SeguimientoasistenciaDTO> getSeguimientoasistencias() {
        return seguimientoasistencias;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param seguimientoasistencias Valor a ser actualizado.
     */
    public void setSeguimientoasistencias(
            Set<SeguimientoasistenciaDTO> seguimientoasistencias) {
        this.seguimientoasistencias = seguimientoasistencias;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ProgramacionDTO> getProgramacions() {
        return programacions;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param programacions Valor a ser actualizado.
     */
    public void setProgramacions(Set<ProgramacionDTO> programacions) {
        this.programacions = programacions;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<AlumnosDTO> getAlumnoses() {
        return alumnoses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param alumnoses Valor a ser actualizado.
     */
    public void setAlumnoses(Set<AlumnosDTO> alumnoses) {
        this.alumnoses = alumnoses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public UsersDTO getUsers() {
        return users;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param users Valor a ser actualizado.
     */
    public void setUsers(UsersDTO users) {
        this.users = users;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SesionesDTO> getSesioneses() {
        return sesioneses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesioneses Valor a ser actualizado.
     */
    public void setSesioneses(Set<SesionesDTO> sesioneses) {
        this.sesioneses = sesioneses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SesionacompanamientoatDTO> getSesionacompanamientoats() {
        return sesionacompanamientoats;
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
    public Set<EvaluacionintegrantescomiteDTO>
            getEvaluacionintegrantescomites() {
        return evaluacionintegrantescomites;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param evaluacionintegrantescomites Valor a ser actualizado.
     */
    public void setEvaluacionintegrantescomites(
            Set<EvaluacionintegrantescomiteDTO> evaluacionintegrantescomites) {
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SesioncomiteDTO> getSesioncomites() {
        return sesioncomites;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param sesioncomites Valor a ser actualizado.
     */
    public void setSesioncomites(Set<SesioncomiteDTO> sesioncomites) {
        this.sesioncomites = sesioncomites;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<FinanciacionDTO> getFinanciacions() {
        return financiacions;
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
    public Set<ObservacionesDTO> getObservacioneses() {
        return observacioneses;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param observacioneses Valor a ser actualizado.
     */
    public void setObservacioneses(Set<ObservacionesDTO> observacioneses) {
        this.observacioneses = observacioneses;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ObservacionesseguimientoDTO> getObservacionesseguimientos() {
        return observacionesseguimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param observacionesseguimientos Valor a ser actualizado.
     */
    public void setObservacionesseguimientos(
            Set<ObservacionesseguimientoDTO> observacionesseguimientos) {
        this.observacionesseguimientos = observacionesseguimientos;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<IntegrantescomiteDTO> getIntegrantescomites() {
        return integrantescomites;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param integrantescomites Valor a ser actualizado.
     */
    public void setIntegrantescomites(
            Set<IntegrantescomiteDTO> integrantescomites) {
        this.integrantescomites = integrantescomites;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SeguimientoDTO> getSeguimientos() {
        return seguimientos;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param seguimientos Valor a ser actualizado.
     */
    public void setSeguimientos(Set<SeguimientoDTO> seguimientos) {
        this.seguimientos = seguimientos;
    }

}
