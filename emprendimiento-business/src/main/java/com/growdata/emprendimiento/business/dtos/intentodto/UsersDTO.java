package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase representante de la entidad users.
 * @author Juan Franco
 */
public class UsersDTO implements java.io.Serializable {

    private String username;
    private String password;
    private BigDecimal enabled;
    private BigDecimal iduser;
    private Date fecharegistro;
    private long accountnonlocked;
    private long credentialsnonexpired;
    private Set<LogauditoriaDTO> logauditorias = new HashSet<LogauditoriaDTO>(0);
    private Set<GroupMembersDTO> groupMemberses = new HashSet<GroupMembersDTO>(0);
    private Set<AuthoritiesDTO> authoritieses = new HashSet<AuthoritiesDTO>(0);
    private Set<FuncionarioDTO> funcionarios = new HashSet<FuncionarioDTO>(0);
    private Set<BeneficiarioDTO> beneficiarios = new HashSet<BeneficiarioDTO>(0);

    public UsersDTO() {
    }

    public UsersDTO(String username, String password, BigDecimal enabled, BigDecimal iduser, Date fecharegistro, long accountnonlocked, long credentialsnonexpired) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.iduser = iduser;
        this.fecharegistro = fecharegistro;
        this.accountnonlocked = accountnonlocked;
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getEnabled() {
        return enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getIduser() {
        return iduser;
    }

    public void setIduser(BigDecimal iduser) {
        this.iduser = iduser;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
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

    public Set<LogauditoriaDTO> getLogauditorias() {
        return logauditorias;
    }

    public void setLogauditorias(Set<LogauditoriaDTO> logauditorias) {
        this.logauditorias = logauditorias;
    }

    public Set<GroupMembersDTO> getGroupMemberses() {
        return groupMemberses;
    }

    public void setGroupMemberses(Set<GroupMembersDTO> groupMemberses) {
        this.groupMemberses = groupMemberses;
    }

    public Set<AuthoritiesDTO> getAuthoritieses() {
        return authoritieses;
    }

    public void setAuthoritieses(Set<AuthoritiesDTO> authoritieses) {
        this.authoritieses = authoritieses;
    }

    public Set<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<BeneficiarioDTO> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(Set<BeneficiarioDTO> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

}
