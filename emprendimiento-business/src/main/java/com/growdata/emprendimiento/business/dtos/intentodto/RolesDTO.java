package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class RolesDTO implements java.io.Serializable {

    private BigDecimal idrol;
    private String nombrerol;
    private String descripcion;
    private Set<PermisosDTO> permisoses = new HashSet<PermisosDTO>(0);
    private Set<CuentausuarioDTO> cuentausuarios = new HashSet<CuentausuarioDTO>(0);

    public RolesDTO() {
    }

    public RolesDTO(BigDecimal idrol) {
        this.idrol = idrol;
    }

    public RolesDTO(BigDecimal idrol, String nombrerol, String descripcion, Set<PermisosDTO> permisoses, Set<CuentausuarioDTO> cuentausuarios) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
        this.descripcion = descripcion;
        this.permisoses = permisoses;
        this.cuentausuarios = cuentausuarios;
    }

    public BigDecimal getIdrol() {
        return this.idrol;
    }

    public void setIdrol(BigDecimal idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return this.nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<PermisosDTO> getPermisoses() {
        return this.permisoses;
    }

    public void setPermisoses(Set<PermisosDTO> permisoses) {
        this.permisoses = permisoses;
    }

    public Set<CuentausuarioDTO> getCuentausuarios() {
        return this.cuentausuarios;
    }

    public void setCuentausuarios(Set<CuentausuarioDTO> cuentausuarios) {
        this.cuentausuarios = cuentausuarios;
    }

}
