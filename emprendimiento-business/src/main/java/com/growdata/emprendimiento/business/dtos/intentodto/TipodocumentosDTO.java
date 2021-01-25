package com.growdata.emprendimiento.business.dtos.intentodto;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TipodocumentosDTO implements java.io.Serializable {

    private BigDecimal idtipodocumento;
    private String nombretipodocumento;
    private String descripcion;
    private Set<DocumentosDTO> documentoses = new HashSet<DocumentosDTO>(0);

    public TipodocumentosDTO() {
    }

    public TipodocumentosDTO(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public TipodocumentosDTO(BigDecimal idtipodocumento, String nombretipodocumento, String descripcion, Set<DocumentosDTO> documentoses) {
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

    public Set<DocumentosDTO> getDocumentoses() {
        return this.documentoses;
    }

    public void setDocumentoses(Set<DocumentosDTO> documentoses) {
        this.documentoses = documentoses;
    }

}
