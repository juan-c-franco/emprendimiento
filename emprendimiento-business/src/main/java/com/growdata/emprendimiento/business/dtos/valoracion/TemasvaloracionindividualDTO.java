package com.growdata.emprendimiento.business.dtos.valoracion;

public class TemasvaloracionindividualDTO {

    private String nombretema;
    private long idtema;

    public String getNombretema() {
        return nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    public long getIdtema() {
        return idtema;
    }

    public void setIdtema(long idtema) {
        this.idtema = idtema;
    }

    public TemasvaloracionindividualDTO(String nombretema, long idtema) {
        this.idtema = idtema;
        this.nombretema = nombretema;
    }

    public TemasvaloracionindividualDTO() {

    }

}
