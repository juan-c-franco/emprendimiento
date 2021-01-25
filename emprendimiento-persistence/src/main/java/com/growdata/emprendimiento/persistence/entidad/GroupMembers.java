package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.web.JsonPath;

public class GroupMembers implements java.io.Serializable {

    private int id;
    private Users users;
    private Groups groups;

    public GroupMembers() {
    }

    public GroupMembers(int id, Users users, Groups groups) {
        this.id = id;
        this.users = users;
        this.groups = groups;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Groups getGroups() {
        return this.groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

}
