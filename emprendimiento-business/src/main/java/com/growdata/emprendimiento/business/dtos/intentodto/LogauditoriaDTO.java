package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

public class LogauditoriaDTO implements java.io.Serializable {

    private BigDecimal idlogauditoria;
    private UsersDTO users;
    private Date fecharegistro;
    private String modulo;
    private Long idelemento;
    private String accion;

    public LogauditoriaDTO() {
    }

    public LogauditoriaDTO(BigDecimal idlogauditoria) {
        this.idlogauditoria = idlogauditoria;
    }

    public LogauditoriaDTO(BigDecimal idlogauditoria, UsersDTO users, Date fecharegistro, String modulo, Long idelemento, String accion) {
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

    public UsersDTO getUsers() {
        return this.users;
    }

    public void setUsers(UsersDTO users) {
        this.users = users;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
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
