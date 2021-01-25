package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1



import java.sql.Timestamp;
public class Loginiciosesion implements java.io.Serializable {


     private long idlogis;
     private String username;
     private Timestamp fecharegistro;


    public Loginiciosesion() {
    }

    public Loginiciosesion(long idlogis, String username) {
        this.idlogis = idlogis;
        this.username = username;
    }


    public Loginiciosesion(long idlogis, String username, Timestamp fecharegistro) {
       this.idlogis = idlogis;
       this.username = username;
       this.fecharegistro = fecharegistro;

    }

    public long getIdlogis() {
        return this.idlogis;
    }

    public void setIdlogis(long idlogis) {
        this.idlogis = idlogis;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getFecharegistro() {
        return this.fecharegistro;
    }
    
  
    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

}
