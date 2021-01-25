package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Funcionario implements java.io.Serializable {

    private long idfuncionario;
    private Tipodocumentoid tipodocumentoid;
    private Cajacompensacion cajacompensacion;
    private Estadofuncionario estadofuncionario;
    private String primernombre;
    private String primerapellido;
    private String segundonombre;
    private String segundoapellido;
    private String email;
    private long telefono;
    private String numerodocumento;
    private Date fecharegistro;
    private Set<Aprobacion> aprobacions = new HashSet<Aprobacion>(0);
    private Set<Seguimientoasistencia> seguimientoasistencias = new HashSet<Seguimientoasistencia>(0);
    private Set<Programacion> programacions = new HashSet<Programacion>(0);
    private Set<Alumnos> alumnoses = new HashSet<Alumnos>(0);
    private Users users;
    private Set<Sesiones> sesioneses = new HashSet<Sesiones>(0);
    private Set<Sesionacompanamientoat> sesionacompanamientoats = new HashSet<Sesionacompanamientoat>(0);
    private Set<Evaluacionintegrantescomite> evaluacionintegrantescomites = new HashSet<Evaluacionintegrantescomite>(0);
    private Set<Sesioncomite> sesioncomites = new HashSet<Sesioncomite>(0);
    private Set<Financiacion> financiacions = new HashSet<Financiacion>(0);
    private Set<Observaciones> observacioneses = new HashSet<Observaciones>(0);
    private Set<Observacionesseguimiento> observacionesseguimientos = new HashSet<Observacionesseguimiento>(0);
    private Set<Integrantescomite> integrantescomites = new HashSet<Integrantescomite>(0);
    private Set<Seguimiento> seguimientos = new HashSet<Seguimiento>(0);

    public Funcionario() {
    }

    public Funcionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario(long idfuncionario, Tipodocumentoid tipodocumentoid, Cajacompensacion cajacompensacion, Estadofuncionario estadofuncionario, Users users) {
        this.idfuncionario = idfuncionario;
        this.tipodocumentoid = tipodocumentoid;
        this.cajacompensacion = cajacompensacion;
        this.estadofuncionario = estadofuncionario;
        this.users = users;
    }

    public Funcionario(long idfuncionario, Tipodocumentoid tipodocumentoid, Cajacompensacion cajacompensacion, Estadofuncionario estadofuncionario, String primernombre, String primerapellido, String segundonombre, String segundoapellido, String email, Long telefono, String numerodocumento, Date fecharegistro, Users users, Set<Sesiones> sesioneses, Set<Sesionacompanamientoat> sesionacompanamientoats, Set<Evaluacionintegrantescomite> evaluacionintegrantescomites, Set<Sesioncomite> sesioncomites, Set<Financiacion> financiacions, Set<Observaciones> observacioneses, Set<Observacionesseguimiento> observacionesseguimientos, Set<Integrantescomite> integrantescomites, Set<Seguimiento> seguimientos) {
        this.idfuncionario = idfuncionario;
        this.tipodocumentoid = tipodocumentoid;
        this.cajacompensacion = cajacompensacion;
        this.estadofuncionario = estadofuncionario;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.segundonombre = segundonombre;
        this.email = email;
        this.telefono = telefono;
        this.numerodocumento = numerodocumento;
        this.fecharegistro = fecharegistro;
        this.users = users;
        this.sesioneses = sesioneses;
        this.sesionacompanamientoats = sesionacompanamientoats;
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
        this.sesioncomites = sesioncomites;
        this.financiacions = financiacions;
        this.observacioneses = observacioneses;
        this.observacionesseguimientos = observacionesseguimientos;
        this.integrantescomites = integrantescomites;
        this.seguimientos = seguimientos;
    }

    public long getIdfuncionario() {
        return this.idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Tipodocumentoid getTipodocumentoid() {
        return this.tipodocumentoid;
    }

    public void setTipodocumentoid(Tipodocumentoid tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    public Cajacompensacion getCajacompensacion() {
        return this.cajacompensacion;
    }

    public void setCajacompensacion(Cajacompensacion cajacompensacion) {
        this.cajacompensacion = cajacompensacion;
    }

    public Estadofuncionario getEstadofuncionario() {
        return this.estadofuncionario;
    }

    public void setEstadofuncionario(Estadofuncionario estadofuncionario) {
        this.estadofuncionario = estadofuncionario;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerodocumento() {
        return this.numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Sesiones> getSesioneses() {
        return this.sesioneses;
    }

    public void setSesioneses(Set<Sesiones> sesioneses) {
        this.sesioneses = sesioneses;
    }

    public Set<Sesionacompanamientoat> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    public void setSesionacompanamientoats(Set<Sesionacompanamientoat> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    public Set<Evaluacionintegrantescomite> getEvaluacionintegrantescomites() {
        return this.evaluacionintegrantescomites;
    }

    public void setEvaluacionintegrantescomites(Set<Evaluacionintegrantescomite> evaluacionintegrantescomites) {
        this.evaluacionintegrantescomites = evaluacionintegrantescomites;
    }

    public Set<Sesioncomite> getSesioncomites() {
        return this.sesioncomites;
    }

    public void setSesioncomites(Set<Sesioncomite> sesioncomites) {
        this.sesioncomites = sesioncomites;
    }

    public Set<Financiacion> getFinanciacions() {
        return this.financiacions;
    }

    public void setFinanciacions(Set<Financiacion> financiacions) {
        this.financiacions = financiacions;
    }

    public Set<Observaciones> getObservacioneses() {
        return this.observacioneses;
    }

    public void setObservacioneses(Set<Observaciones> observacioneses) {
        this.observacioneses = observacioneses;
    }

    public Set<Observacionesseguimiento> getObservacionesseguimientos() {
        return this.observacionesseguimientos;
    }

    public void setObservacionesseguimientos(Set<Observacionesseguimiento> observacionesseguimientos) {
        this.observacionesseguimientos = observacionesseguimientos;
    }

    public Set<Integrantescomite> getIntegrantescomites() {
        return this.integrantescomites;
    }

    public void setIntegrantescomites(Set<Integrantescomite> integrantescomites) {
        this.integrantescomites = integrantescomites;
    }

    public Set<Seguimiento> getSeguimientos() {
        return this.seguimientos;
    }

    public void setSeguimientos(Set<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Set<Aprobacion> getAprobacions() {
        return aprobacions;
    }

    public void setAprobacions(Set<Aprobacion> aprobacions) {
        this.aprobacions = aprobacions;
    }

    public Set<Seguimientoasistencia> getSeguimientoasistencias() {
        return seguimientoasistencias;
    }

    public void setSeguimientoasistencias(Set<Seguimientoasistencia> seguimientoasistencias) {
        this.seguimientoasistencias = seguimientoasistencias;
    }

    public Set<Programacion> getProgramacions() {
        return programacions;
    }

    public void setProgramacions(Set<Programacion> programacions) {
        this.programacions = programacions;
    }

    public Set<Alumnos> getAlumnoses() {
        return alumnoses;
    }

    public void setAlumnoses(Set<Alumnos> alumnoses) {
        this.alumnoses = alumnoses;
    }

}
