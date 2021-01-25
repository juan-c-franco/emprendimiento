package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

public class Groups implements java.io.Serializable {

    private int id;
    private String groupName;
    private Set<GroupMembers> groupMemberses = new HashSet<GroupMembers>(0);
    private Set<GroupAuthorities> groupAuthoritieses = new HashSet<GroupAuthorities>(0);

    public Groups() {
    }

    public Groups(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Groups(int id, String groupName, Set<GroupMembers> groupMemberses, Set<GroupAuthorities> groupAuthoritieses) {
        this.id = id;
        this.groupName = groupName;
        this.groupMemberses = groupMemberses;
        this.groupAuthoritieses = groupAuthoritieses;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<GroupMembers> getGroupMemberses() {
        return this.groupMemberses;
    }

    public void setGroupMemberses(Set<GroupMembers> groupMemberses) {
        this.groupMemberses = groupMemberses;
    }

    public Set<GroupAuthorities> getGroupAuthoritieses() {
        return this.groupAuthoritieses;
    }

    public void setGroupAuthoritieses(Set<GroupAuthorities> groupAuthoritieses) {
        this.groupAuthoritieses = groupAuthoritieses;
    }

}
