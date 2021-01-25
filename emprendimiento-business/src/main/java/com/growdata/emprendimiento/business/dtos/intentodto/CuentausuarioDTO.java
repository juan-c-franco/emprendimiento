package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante a una cuenta de usuario.
 *
 * @author Juan Franco
 */
public class CuentausuarioDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idcuentausuario;
    /**
     * Datos del rol.
     */
    private RolesDTO roles;
    /**
     * Nombre de usuario.
     */
    private String nombreusuario;
    /**
     * Constrase�a.
     */
    private String contrasena;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Funcionarios.
     */
    private Set<FuncionarioDTO> funcionarios = new HashSet<FuncionarioDTO>(0);
    /**
     * Registro en el log de inicio de sesi�n.
     */
    private Set<LoginiciosesionDTO> loginiciosesions
            = new HashSet<LoginiciosesionDTO>(0);

    /**
     * Constructor.
     */
    public CuentausuarioDTO() {
    }

    /**
     * Constructor.
     *
     * @param idcuentausuario Identificador.
     * @param roles Roles.
     */
    public CuentausuarioDTO(long idcuentausuario, RolesDTO roles) {
        this.idcuentausuario = idcuentausuario;
        this.roles = roles;
    }

    /**
     * Constructor.
     *
     * @param idcuentausuario Identificador.
     * @param roles Roles.
     * @param nombreusuario Nombre de usuario.
     * @param contrasena Contrase�a.
     * @param fecharegistro Fecha de registro.
     * @param funcionarios Funcionarios.
     * @param loginiciosesions Registros en log inicio de sesi�n.
     */
    public CuentausuarioDTO(long idcuentausuario, RolesDTO roles,
            String nombreusuario, String contrasena, Date fecharegistro,
            Set<FuncionarioDTO> funcionarios,
            Set<LoginiciosesionDTO> loginiciosesions) {
        this.idcuentausuario = idcuentausuario;
        this.roles = roles;
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
        this.fecharegistro = fecharegistro;
        this.funcionarios = funcionarios;
        this.loginiciosesions = loginiciosesions;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdcuentausuario() {
        return this.idcuentausuario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idcuentausuario Valor a ser actualizado.
     */
    public void setIdcuentausuario(long idcuentausuario) {
        this.idcuentausuario = idcuentausuario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public RolesDTO getRoles() {
        return this.roles;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param roles Valor a ser actualizado.
     */
    public void setRoles(RolesDTO roles) {
        this.roles = roles;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getNombreusuario() {
        return this.nombreusuario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param nombreusuario Valor a ser actualizado.
     */
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getContrasena() {
        return this.contrasena;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param contrasena Valor a ser actualizado.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
    public Set<FuncionarioDTO> getFuncionarios() {
        return this.funcionarios;
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
    public Set<LoginiciosesionDTO> getLoginiciosesions() {
        return this.loginiciosesions;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param loginiciosesions Valor a ser actualizado.
     */
    public void setLoginiciosesions(Set<LoginiciosesionDTO> loginiciosesions) {
        this.loginiciosesions = loginiciosesions;
    }

}
