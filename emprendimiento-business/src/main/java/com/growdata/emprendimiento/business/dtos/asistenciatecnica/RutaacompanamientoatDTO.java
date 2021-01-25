package com.growdata.emprendimiento.business.dtos.asistenciatecnica;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ruta acompa�amiento AAT.
 * @author Juan Franco
 */
public class RutaacompanamientoatDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idrutaacompanamientoat;
    /**
     * Emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;
    /**
     * Fecha de registro.
     */
    private Date fecharegistro;
    /**
     * Sesi�n AAT.
     */
    private Set<SesionacompanamientoatDTO> sesionacompanamientoats
            = new HashSet<SesionacompanamientoatDTO>(0);
    /**
     * Temas ruta AAT.
     */
    private Set<TemasrutaacompanamientoatDTO> temasrutaacompanamientoats
            = new HashSet<TemasrutaacompanamientoatDTO>(0);

    /**
     * Constructor.
     */
    public RutaacompanamientoatDTO() {
    }

    /**
     * Constructor.
     * @param idrutaacompanamientoat Identificador.
     * @param emprendimiento Emprendimiento.
     */
    public RutaacompanamientoatDTO(long idrutaacompanamientoat,
            EmprendimientoDTO emprendimiento) {
        this.idrutaacompanamientoat = idrutaacompanamientoat;
        this.emprendimiento = emprendimiento;
    }

    /**
     * Constructor.
     * @param idrutaacompanamientoat Identificador.
     * @param emprendimiento Emprendimiento.
     * @param fecharegistro Fecha de registro.
     * @param sesionacompanamientoats Sesi�n AAT.
     * @param temasrutaacompanamientoats  Temas ruta AAT.
     */
    public RutaacompanamientoatDTO(long idrutaacompanamientoat,
            EmprendimientoDTO emprendimiento, Date fecharegistro,
            Set<SesionacompanamientoatDTO> sesionacompanamientoats,
            Set<TemasrutaacompanamientoatDTO> temasrutaacompanamientoats) {
        this.idrutaacompanamientoat = idrutaacompanamientoat;
        this.emprendimiento = emprendimiento;
        this.fecharegistro = fecharegistro;
        this.sesionacompanamientoats = sesionacompanamientoats;
        this.temasrutaacompanamientoats = temasrutaacompanamientoats;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdrutaacompanamientoat() {
        return this.idrutaacompanamientoat;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idrutaacompanamientoat Valor a ser actualizado.
     */
    public void setIdrutaacompanamientoat(long idrutaacompanamientoat) {
        this.idrutaacompanamientoat = idrutaacompanamientoat;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return this.emprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<SesionacompanamientoatDTO> getSesionacompanamientoats() {
        return this.sesionacompanamientoats;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param sesionacompanamientoats Valor a ser actualizado.
     */
    public void setSesionacompanamientoats(
            Set<SesionacompanamientoatDTO> sesionacompanamientoats) {
        this.sesionacompanamientoats = sesionacompanamientoats;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<TemasrutaacompanamientoatDTO> getTemasrutaacompanamientoats() {
        return this.temasrutaacompanamientoats;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasrutaacompanamientoats Valor a ser actualizado.
     */
    public void setTemasrutaacompanamientoats(
            Set<TemasrutaacompanamientoatDTO> temasrutaacompanamientoats) {
        this.temasrutaacompanamientoats = temasrutaacompanamientoats;
    }

}
