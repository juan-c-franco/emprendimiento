package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

public class Authorities implements java.io.Serializable {

    private BigDecimal id;
    private Users users;
    private String authority;

    public Authorities() {
    }

    public Authorities(BigDecimal id, Users users, String authority) {
        this.id = id;
        this.users = users;
        this.authority = authority;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
