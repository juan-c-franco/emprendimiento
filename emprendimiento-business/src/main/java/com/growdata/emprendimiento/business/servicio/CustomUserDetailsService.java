/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

/**
 * Reference org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
 *
 * @author mkyong
 *
 */
@Service("userDetailsService")
public class CustomUserDetailsService extends JdbcDaoImpl {

    @Autowired
    private DataSource securityDataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(securityDataSource);
    }

    @Override
    @Value("select * from users where username = ?")
    public void setUsersByUsernameQuery(String usersByUsernameQueryString) {
        super.setUsersByUsernameQuery(usersByUsernameQueryString);
    }

    @Override
//    @Value("select username, role from user_roles where username =?")
    @Value("select gm.username, ga.authority from groups g, group_members gm, group_authorities ga where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id ")
    public void setAuthoritiesByUsernameQuery(String queryString) {
        super.setAuthoritiesByUsernameQuery(queryString);
    }

    //override to get accountNonLocked  
    @Override
    public List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(super.getUsersByUsernameQuery(), new String[]{username},
                new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean enabled = rs.getBoolean("enabled");
//			boolean accountNonExpired = rs.getBoolean("accountNonExpired");
                boolean credentialsNonExpired = rs.getBoolean("credentialsNonExpired");
                boolean accountNonExpired = true;

                boolean accountNonLocked = rs.getBoolean("accountNonLocked");

                return new User(username, password, enabled, accountNonExpired, credentialsNonExpired,
                        accountNonLocked, AuthorityUtils.NO_AUTHORITIES);
            }

        });
    }

    //override to pass accountNonLocked
    @Override
    public UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {
        String returnUsername = userFromUserQuery.getUsername();

        if (super.isUsernameBasedPrimaryKey()) {
            returnUsername = username;
        }

        return new User(returnUsername, userFromUserQuery.getPassword(),
                userFromUserQuery.isEnabled(),
                userFromUserQuery.isAccountNonExpired(),
                userFromUserQuery.isCredentialsNonExpired(),
                userFromUserQuery.isAccountNonLocked(), combinedAuthorities);
    }

}
