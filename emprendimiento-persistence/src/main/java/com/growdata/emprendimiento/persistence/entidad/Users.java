package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Users implements java.io.Serializable {

    private String username;
    private String password;
    private BigDecimal enabled;
    private BigDecimal iduser;
    private Date fecharegistro;
    private long accountnonlocked;
    private long credentialsnonexpired;
    private Set<Logauditoria> logauditorias = new HashSet<Logauditoria>(0);
    private Set<GroupMembers> groupMemberses = new HashSet<GroupMembers>(0);
    private Set<Authorities> authoritieses = new HashSet<Authorities>(0);
    private Set<Funcionario> funcionarios = new HashSet<Funcionario>(0);
    private Set<Beneficiario> beneficiarios = new HashSet<Beneficiario>(0);

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String password, BigDecimal iduser) {
        this.username = username;
        this.password = password;
        this.iduser = iduser;
    }

    public Users(String username, String password, BigDecimal enabled, BigDecimal iduser, Date fecharegistro, Set<Logauditoria> logauditorias, Set<GroupMembers> groupMemberses, Set<Authorities> authoritieses, Set<Funcionario> funcionarios, long accountnonlocked, long credentialsnonexpired) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.iduser = iduser;
        this.fecharegistro = fecharegistro;
        this.logauditorias = logauditorias;
        this.groupMemberses = groupMemberses;
        this.authoritieses = authoritieses;
        this.funcionarios = funcionarios;
        this.accountnonlocked = accountnonlocked;
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getEnabled() {
        return this.enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getIduser() {
        return this.iduser;
    }

    public void setIduser(BigDecimal iduser) {
        this.iduser = iduser;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Logauditoria> getLogauditorias() {
        return this.logauditorias;
    }

    public void setLogauditorias(Set<Logauditoria> logauditorias) {
        this.logauditorias = logauditorias;
    }

    @JsonIgnore
    public Set<GroupMembers> getGroupMemberses() {
        return this.groupMemberses;
    }

    public void setGroupMemberses(Set<GroupMembers> groupMemberses) {
        this.groupMemberses = groupMemberses;
    }

    public Set<Authorities> getAuthoritieses() {
        return this.authoritieses;
    }

    public void setAuthoritieses(Set<Authorities> authoritieses) {
        this.authoritieses = authoritieses;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @JsonIgnore
    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public long getAccountnonlocked() {
        return accountnonlocked;
    }

    public void setAccountnonlocked(long accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }

    public long getCredentialsnonexpired() {
        return credentialsnonexpired;
    }

    public void setCredentialsnonexpired(long credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public Set<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(Set<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

}
