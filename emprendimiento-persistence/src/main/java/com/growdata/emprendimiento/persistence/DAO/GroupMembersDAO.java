/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.GroupMembers;
import com.growdata.emprendimiento.persistence.entidad.Users;

public interface GroupMembersDAO {

    public String agregarGroupMember(GroupMembers gm) throws Exception;

    public GroupMembers getGroupMember(String username) throws Exception;

    public String modificarGroupMembers(GroupMembers gm) throws Exception;

}
