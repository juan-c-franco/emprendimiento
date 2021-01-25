package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Rutaacompanamientoat implements java.io.Serializable {

    private long idrutaacompanamientoat;
    private Emprendimiento emprendimiento;
    private Date fecharegistro;
    private Set<Sesionacompanamientoat> sesionacompanamientoats = new HashSet<Sesionacompanamientoat>(0);
    private Set<Temasrutaacompanamientoat> temasrutaacompanamientoats = new HashSet<Temasrutaacompanamientoat>(0);

    public Rutaacompanamientoat() {
    }

    public Rutaacompanamientoat(long idrutaacompanamientoat, Emprendimiento emprendimiento) {
        this.idrutaacompanamientoat = idrutaacompanamientoat;
        this.emprendimiento = emprendimiento;
    }

    public Rutaacompanamientoat(long idrutaacompanamientoat, Emprendimiento emprendimiento, Date fecharegistro, Set<Sesionacompanamientoat> sesionacompanamientoats, Set<Temasrutaacompanamientoat> temasrutaacompanamientoats) {
        this.idrutaacompanamientoat = idrutaacompanamientoat;
        this.emprendimiento = emprendimiento;
        this.fecharegistro = fecharegistro;
        this.sesionacompanamientoats = sesionacompanamientoats;
        this.temasrutaacompanamientoats = temasrutaacompanamientoats;
    }

    public long getIdrutaacompanamientoat() {
        return this.idrutaacompanamientoat;
    }

    public void setIdrutaacompanamientoat(long idrutaacompanamientoat) {
        this.idrutaacompanamientoat = idrutaacompanamientoat;
    }

    public Emprendimiento getEmprendimiento() {
        return this.emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Set<Sesionacompanamientoat> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    public void setSesionacompanamientoats(Set<Sesionacompanamientoat> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    public Set<Temasrutaacompanamientoat> getTemasrutaacompanamientoats() {
        return this.temasrutaacompanamientoats;
    }

    public void setTemasrutaacompanamientoats(Set<Temasrutaacompanamientoat> temasrutaacompanamientoats) {
        this.temasrutaacompanamientoats = temasrutaacompanamientoats;
    }

}
