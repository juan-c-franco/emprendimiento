package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Beneficiario implements java.io.Serializable {

    private long idbeneficiario;
    private Tipodocumentoid tipodocumentoid;
    private String primernombre;
    private String primerapellido;
    private String segundonombre;
    private String segundoapellido;
    private String email;
    private long telefono;
    private String numerodocumento;
    private Date fecharegistro;
    private Users users;
    private Set<Listaasistenciaaat> listaasistenciaaats = new HashSet<Listaasistenciaaat>(0);
    private Set<Asociados> asociadoses = new HashSet<Asociados>(0);
    private Set<Rutacapacitacion> rutacapacitacions = new HashSet<Rutacapacitacion>(0);
    private Set<Listaasistencia> listaasistencias = new HashSet<Listaasistencia>(0);
    private Set<Documentos> documentoses = new HashSet<Documentos>(0);
    private Set<Encuesta> encuestas = new HashSet<Encuesta>(0);
    private Set<Alumnos> alumnoses = new HashSet<Alumnos>(0);

    public Beneficiario() {
    }

    public Beneficiario(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

    public Beneficiario(long idbeneficiario, Tipodocumentoid tipodocumentoid) {
        this.idbeneficiario = idbeneficiario;
        this.tipodocumentoid = tipodocumentoid;
    }

    public Beneficiario(long idbeneficiario, Tipodocumentoid tipodocumentoid, String primernombre, String primerapellido, String segundonombre, String segundoapellido, String email, Long telefono, String numerodocumento, Date fecharegistro, Users users, Set<Listaasistenciaaat> listaasistenciaaats, Set<Asociados> asociadoses, Set<Rutacapacitacion> rutacapacitacions, Set<Listaasistencia> listaasistencias, Set<Documentos> documentoses, Set<Encuesta> encuestas) {
        this.idbeneficiario = idbeneficiario;
        this.tipodocumentoid = tipodocumentoid;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.segundonombre = segundonombre;
        this.segundoapellido = segundoapellido;
        this.email = email;
        this.telefono = telefono;
        this.numerodocumento = numerodocumento;
        this.fecharegistro = fecharegistro;
        this.users = users;
        this.listaasistenciaaats = listaasistenciaaats;
        this.asociadoses = asociadoses;
        this.rutacapacitacions = rutacapacitacions;
        this.listaasistencias = listaasistencias;
        this.documentoses = documentoses;
        this.encuestas = encuestas;
    }

    public long getIdbeneficiario() {
        return this.idbeneficiario;
    }

    public void setIdbeneficiario(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

    public Tipodocumentoid getTipodocumentoid() {
        return this.tipodocumentoid;
    }

    public void setTipodocumentoid(Tipodocumentoid tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
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
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Listaasistenciaaat> getListaasistenciaaats() {
        return this.listaasistenciaaats;
    }

    public void setListaasistenciaaats(Set<Listaasistenciaaat> listaasistenciaaats) {
        this.listaasistenciaaats = listaasistenciaaats;
    }

    public Set<Asociados> getAsociadoses() {
        return this.asociadoses;
    }

    public void setAsociadoses(Set<Asociados> asociadoses) {
        this.asociadoses = asociadoses;
    }

    public Set<Rutacapacitacion> getRutacapacitacions() {
        return this.rutacapacitacions;
    }

    public void setRutacapacitacions(Set<Rutacapacitacion> rutacapacitacions) {
        this.rutacapacitacions = rutacapacitacions;
    }

    public Set<Listaasistencia> getListaasistencias() {
        return this.listaasistencias;
    }

    public void setListaasistencias(Set<Listaasistencia> listaasistencias) {
        this.listaasistencias = listaasistencias;
    }

    public Set<Documentos> getDocumentoses() {
        return this.documentoses;
    }

    public void setDocumentoses(Set<Documentos> documentoses) {
        this.documentoses = documentoses;
    }

    public Set<Encuesta> getEncuestas() {
        return this.encuestas;
    }

    public void setEncuestas(Set<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Set<Alumnos> getAlumnoses() {
        return alumnoses;
    }

    public void setAlumnoses(Set<Alumnos> alumnoses) {
        this.alumnoses = alumnoses;
    }

}
