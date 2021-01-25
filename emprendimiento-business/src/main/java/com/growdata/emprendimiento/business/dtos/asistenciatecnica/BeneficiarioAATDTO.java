package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import com.growdata.emprendimiento.business.dtos.intentodto.TemasrutacapacitacionDTO;
import java.util.List;

/**
 * Clase que representa un beneficiario.
 *
 * @author Juan Franco
 */
public class BeneficiarioAATDTO {

    /**
     * Identificador del beneficiario.
     */
    private long idbeneficiario;
    /**
     * Tipo de documento de identificaci�n.
     */
    private String tipodocumento;
    /**
     * N�mero de documento de identificaci�n.
     */
    private String numerodocumento;
    /**
     * Nombres de beneficiario.
     */
    private String nombres;
    /**
     * Apellidos del beneficiario.
     */
    private String apellidos;
    /**
     * Correo electr�nico.
     */
    private String email;
    /**
     * Tel�fono.
     */
    private Long telefono;
    /**
     * Fecha de registro.
     */
    private String fecharegistro;
    /**
     * Lista de temas ruta capacitaci�n.
     */
    private List<TemasrutacapacitacionDTO> temasRutaCapacitacionDTO;
    /**
     * Porcentaje de avance.
     */
    private short porcentajeAprobacion;

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
    public String getTipodocumento() {
        return tipodocumento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipodocumento Valor a ser actualizado.
     */
    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
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
    public String getNombres() {
        return nombres;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombres Valor a ser actualizado.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param apellidos Valor a ser actualizado.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
    public Long getTelefono() {
        return telefono;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param telefono Valor a ser actualizado.
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getFecharegistro() {
        return fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TemasrutacapacitacionDTO> getTemasRutaCapacitacionDTO() {
        return temasRutaCapacitacionDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasRutaCapacitacionDTO Valor a ser actualizado.
     */
    public void setTemasRutaCapacitacionDTO(
            List<TemasrutacapacitacionDTO> temasRutaCapacitacionDTO) {
        this.temasRutaCapacitacionDTO = temasRutaCapacitacionDTO;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public short getPorcentajeAprobacion() {
        return porcentajeAprobacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param porcentajeAprobacion Valor a ser actualizado.
     */
    public void setPorcentajeAprobacion(short porcentajeAprobacion) {
        this.porcentajeAprobacion = porcentajeAprobacion;
    }

}
