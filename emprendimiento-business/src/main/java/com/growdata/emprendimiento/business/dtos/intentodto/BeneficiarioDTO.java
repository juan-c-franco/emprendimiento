package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.seguridad.TipodocumentoidDTO;
import com.growdata.emprendimiento.persistence.entidad.Users;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad Beneficiario.
 *
 * @author Juan Franco
 */
public class BeneficiarioDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idbeneficiario;
    /**
     * Tipo de documento de identificaci�n.
     */
    private TipodocumentoidDTO tipodocumentoid;
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
     * Correo electr�nico.
     */
    private String email;
    /**
     * Tel�fono.
     */
    private long telefono;
    /**
     * N�mero de documento.
     */
    private String numerodocumento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Datos del usuario.
     */
    private Users users;
    /**
     * Lista de asistencia.
     */
    private Set<ListaasistenciaaatDTO> listaasistenciaaats
            = new HashSet<ListaasistenciaaatDTO>(0);
    /**
     * Asociados.
     */
    private Set<AsociadosDTO> asociadoses = new HashSet<AsociadosDTO>(0);
    /**
     * Rutas de capacitaci�n.
     */
    private Set<RutacapacitacionDTO> rutacapacitacions
            = new HashSet<RutacapacitacionDTO>(0);
    /**
     * Lista de asistencia.
     */
    private Set<ListaasistenciaDTO> listaasistencias
            = new HashSet<ListaasistenciaDTO>(0);
    /**
     * Documentos.
     */
    private Set<DocumentosDTO> documentoses = new HashSet<DocumentosDTO>(0);
    /**
     * Encuestas.
     */
    private Set<EncuestaDTO> encuestas = new HashSet<EncuestaDTO>(0);
    /**
     * Alumnos.
     */
    private Set<AlumnosDTO> alumnoses = new HashSet<AlumnosDTO>(0);

    /**
     * Constructor.
     */
    public BeneficiarioDTO() {
    }

    /**
     * Constructor.
     *
     * @param idbeneficiario Identificador.
     */
    public BeneficiarioDTO(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

    /**
     * Constructor.
     *
     * @param idbeneficiario Identificador.
     * @param tipodocumentoid Tipo de documento de identidad.
     * @param primernombre Primer nombre.
     * @param primerapellido Primer apellido.
     * @param segundonombre Segundo nombre.
     * @param segundoapellido Segundo apellido.
     * @param email Correo electr�nico.
     * @param telefono Tel�fono.
     * @param numerodocumento N�mero de coumento.
     * @param fecharegistro Fecha de registro.
     * @param users Datos del usuario.
     */
    public BeneficiarioDTO(long idbeneficiario,
            TipodocumentoidDTO tipodocumentoid, String primernombre,
            String primerapellido, String segundonombre,
            String segundoapellido, String email, long telefono,
            String numerodocumento, Date fecharegistro, Users users) {
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
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdbeneficiario() {
        return idbeneficiario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idbeneficiario Valor a ser actualizado.
     */
    public void setIdbeneficiario(long idbeneficiario) {
        this.idbeneficiario = idbeneficiario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TipodocumentoidDTO getTipodocumentoid() {
        return tipodocumentoid;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipodocumentoid Valor a ser actualizado.
     */
    public void setTipodocumentoid(TipodocumentoidDTO tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimernombre() {
        return primernombre;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param primernombre Valor a ser actualizado.
     */
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getPrimerapellido() {
        return primerapellido;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param primerapellido Valor a ser actualizado.
     */
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundonombre() {
        return segundonombre;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param segundonombre Valor a ser actualizado.
     */
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getSegundoapellido() {
        return segundoapellido;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param segundoapellido Valor a ser actualizado.
     */
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getEmail() {
        return email;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param email Valor a ser actualizado.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param telefono Valor a ser actualizado.
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param numerodocumento Valor a ser actualizado.
     */
    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return fecharegistro;
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
    public Users getUsers() {
        return users;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param users Valor a ser actualizado.
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ListaasistenciaaatDTO> getListaasistenciaaats() {
        return listaasistenciaaats;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param listaasistenciaaats Valor a ser actualizado.
     */
    public void setListaasistenciaaats(
            Set<ListaasistenciaaatDTO> listaasistenciaaats) {
        this.listaasistenciaaats = listaasistenciaaats;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<AsociadosDTO> getAsociadoses() {
        return asociadoses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param asociadoses Valor a ser actualizado.
     */
    public void setAsociadoses(Set<AsociadosDTO> asociadoses) {
        this.asociadoses = asociadoses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<RutacapacitacionDTO> getRutacapacitacions() {
        return rutacapacitacions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param rutacapacitacions Valor a ser actualizado.
     */
    public void setRutacapacitacions(
            Set<RutacapacitacionDTO> rutacapacitacions) {
        this.rutacapacitacions = rutacapacitacions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ListaasistenciaDTO> getListaasistencias() {
        return listaasistencias;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param listaasistencias Valor a ser actualizado.
     */
    public void setListaasistencias(Set<ListaasistenciaDTO> listaasistencias) {
        this.listaasistencias = listaasistencias;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<DocumentosDTO> getDocumentoses() {
        return documentoses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param documentoses Valor a ser actualizado.
     */
    public void setDocumentoses(Set<DocumentosDTO> documentoses) {
        this.documentoses = documentoses;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<EncuestaDTO> getEncuestas() {
        return encuestas;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param encuestas Valor a ser actualizado.
     */
    public void setEncuestas(Set<EncuestaDTO> encuestas) {
        this.encuestas = encuestas;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<AlumnosDTO> getAlumnoses() {
        return alumnoses;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param alumnoses Valor a ser actualizado.
     */
    public void setAlumnoses(Set<AlumnosDTO> alumnoses) {
        this.alumnoses = alumnoses;
    }

}
