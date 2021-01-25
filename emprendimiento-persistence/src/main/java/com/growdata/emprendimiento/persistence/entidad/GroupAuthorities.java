package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

public class GroupAuthorities implements java.io.Serializable {

    private BigDecimal id;
    private Groups groups;
    private String authority;

    public GroupAuthorities() {
    }

    public GroupAuthorities(BigDecimal id, Groups groups, String authority) {
        this.id = id;
        this.groups = groups;
        this.authority = authority;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Groups getGroups() {
        return this.groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
