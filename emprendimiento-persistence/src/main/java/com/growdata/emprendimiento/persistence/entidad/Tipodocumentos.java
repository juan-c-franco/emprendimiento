package com.growdata.emprendimiento.persistence.entidad;
// Generated 8/10/2018 04:30:51 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tipodocumentos implements java.io.Serializable {

    private BigDecimal idtipodocumento;
    private String nombretipodocumento;
    private String descripcion;
    private Set<Documentos> documentoses = new HashSet<Documentos>(0);

    public Tipodocumentos() {
    }

    public Tipodocumentos(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public Tipodocumentos(BigDecimal idtipodocumento, String nombretipodocumento, String descripcion, Set<Documentos> documentoses) {
        this.idtipodocumento = idtipodocumento;
        this.nombretipodocumento = nombretipodocumento;
        this.descripcion = descripcion;
        this.documentoses = documentoses;
    }

    public BigDecimal getIdtipodocumento() {
        return this.idtipodocumento;
    }

    public void setIdtipodocumento(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getNombretipodocumento() {
        return this.nombretipodocumento;
    }

    public void setNombretipodocumento(String nombretipodocumento) {
        this.nombretipodocumento = nombretipodocumento;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Documentos> getDocumentoses() {
        return this.documentoses;
    }

    public void setDocumentoses(Set<Documentos> documentoses) {
        this.documentoses = documentoses;
    }

}
