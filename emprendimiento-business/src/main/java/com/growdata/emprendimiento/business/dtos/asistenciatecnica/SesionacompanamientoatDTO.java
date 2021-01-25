package com.growdata.emprendimiento.business.dtos.asistenciatecnica;
// Generated 3/10/2018 04:44:42 PM by Hibernate Tools 4.3.1

import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaaatDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EstadosesionDTO;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase correspondiente a la Sesi�n AAT.
 * @author Juan Franco
 */
public class SesionacompanamientoatDTO implements java.io.Serializable {

    /**
     * Identificador.
     */
    private long idsesionacompanamientoat;
    
    /**
     * Estado de la sesi�n.
     */
    private EstadosesionDTO estadosesion;
    /**
     * Ruta AAT.
     */
    private RutaacompanamientoatDTO rutaacompanamientoat;
    /**
     * Temas AAT.
     */
    private TemasrutaacompanamientoatDTO temasrutaacompanamientoat;
    /**
     * Funcionario
     */
    private FuncionarioDTO funcionario;
    /**
     * Fecha de inicio.
     */
    private Timestamp fechainicio;
    /**
     * Fecha de fin.
     */
    private Timestamp fechafinal;
    /**
     * Fecha de Registro.
     */
    private Timestamp fecharegistro;
    /**
     * Observaciones.
     */
    private String observaciones;
    /**
     * Ubicaci�n.
     */
    private String ubicacion;
    /**
     * Lista de asistencia.
     */
    private Set<ListaasistenciaaatDTO> listaasistacompanamientoats
            = new HashSet<ListaasistenciaaatDTO>(0);

    /**
     * Constructor.
     */
    public SesionacompanamientoatDTO() {
    }

    /**
     * Constructor.
     * @param idsesionacompanamientoat Identificador.
     * @param estadosesion Estado de la sesi�n
     * @param rutaacompanamientoat Ruta AAT.
     * @param temasrutaacompanamientoat Temas AAT.
     * @param funcionario Funcionario.
     * @param fechainicio Fecha de inicio.
     * @param fechafinal Fecha de fin.
     * @param fecharegistro Fecha de registro.
     * @param observaciones Observaciones.
     * @param ubicacion Ubicaci�n.
     */
    public SesionacompanamientoatDTO(long idsesionacompanamientoat,
            EstadosesionDTO estadosesion,
            RutaacompanamientoatDTO rutaacompanamientoat,
            TemasrutaacompanamientoatDTO temasrutaacompanamientoat,
            FuncionarioDTO funcionario, Timestamp fechainicio,
            Timestamp fechafinal, Timestamp fecharegistro, String observaciones,
            String ubicacion) {
        this.idsesionacompanamientoat = idsesionacompanamientoat;
        this.estadosesion = estadosesion;
        this.rutaacompanamientoat = rutaacompanamientoat;
        this.temasrutaacompanamientoat = temasrutaacompanamientoat;
        this.funcionario = funcionario;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fecharegistro = fecharegistro;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdsesionacompanamientoat() {
        return this.idsesionacompanamientoat;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idsesionacompanamientoat Valor a ser actualizado.
     */
    public void setIdsesionacompanamientoat(long idsesionacompanamientoat) {
        this.idsesionacompanamientoat = idsesionacompanamientoat;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EstadosesionDTO getEstadosesion() {
        return this.estadosesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadosesion Valor a ser actualizado.
     */
    public void setEstadosesion(EstadosesionDTO estadosesion) {
        this.estadosesion = estadosesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public RutaacompanamientoatDTO getRutaacompanamientoat() {
        return this.rutaacompanamientoat;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param rutaacompanamientoat Valor a ser actualizado.
     */
    public void setRutaacompanamientoat(
            RutaacompanamientoatDTO rutaacompanamientoat) {
        this.rutaacompanamientoat = rutaacompanamientoat;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public TemasrutaacompanamientoatDTO getTemasrutaacompanamientoat() {
        return this.temasrutaacompanamientoat;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasrutaacompanamientoat Valor a ser actualizado.
     */
    public void setTemasrutaacompanamientoat(
            TemasrutaacompanamientoatDTO temasrutaacompanamientoat) {
        this.temasrutaacompanamientoat = temasrutaacompanamientoat;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param funcionario Valor a ser actualizado.
     */
    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFechainicio() {
        return this.fechainicio;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechainicio Valor a ser actualizado.
     */
    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFechafinal() {
        return this.fechafinal;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fechafinal Valor a ser actualizado.
     */
    public void setFechafinal(Timestamp fechafinal) {
        this.fechafinal = fechafinal;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Timestamp getFecharegistro() {
        return this.fecharegistro;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param fecharegistro Valor a ser actualizado.
     */
    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getObservaciones() {
        return this.observaciones;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param observaciones Valor a ser actualizado.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param ubicacion Valor a ser actualizado.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public Set<ListaasistenciaaatDTO> getListaasistacompanamientoats() {
        return this.listaasistacompanamientoats;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param listaasistacompanamientoats Valor a ser actualizado.
     */
    public void setListaasistacompanamientoats(
            Set<ListaasistenciaaatDTO> listaasistacompanamientoats) {
        this.listaasistacompanamientoats = listaasistacompanamientoats;
    }

}
