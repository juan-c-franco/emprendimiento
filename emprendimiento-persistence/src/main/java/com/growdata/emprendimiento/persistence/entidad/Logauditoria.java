package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Logauditoria implements java.io.Serializable {

    private BigDecimal idlogauditoria;
    private Users users;
    private Timestamp fecharegistro;
    private String modulo;
    private Long idelemento;
    private String accion;

    public Logauditoria() {
    }

    public Logauditoria(BigDecimal idlogauditoria) {
        this.idlogauditoria = idlogauditoria;
    }

    public Logauditoria(BigDecimal idlogauditoria, Users users, Timestamp fecharegistro, String modulo, Long idelemento, String accion) {
        this.idlogauditoria = idlogauditoria;
        this.users = users;
        this.fecharegistro = fecharegistro;
        this.modulo = modulo;
        this.idelemento = idelemento;
        this.accion = accion;
    }

    public BigDecimal getIdlogauditoria() {
        return this.idlogauditoria;
    }

    public void setIdlogauditoria(BigDecimal idlogauditoria) {
        this.idlogauditoria = idlogauditoria;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Timestamp getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Long getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(Long idelemento) {
        this.idelemento = idelemento;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
