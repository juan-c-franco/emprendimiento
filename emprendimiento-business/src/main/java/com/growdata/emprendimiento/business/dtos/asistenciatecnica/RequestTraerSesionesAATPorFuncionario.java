package com.growdata.emprendimiento.business.dtos.asistenciatecnica;

import java.util.List;

/**
 * Clase solicitud sesiones AAT.
 *
 * @author Juan Franco
 */
public class RequestTraerSesionesAATPorFuncionario {

    /**
     * Identificador del funcionario.
     */
    private long idFuncionario;

    /**
     * Estados de las sesiones.
     */
    private List<String> estadosSesion;

    /**
     * Tipo de b�squeda.
     */
    private char tipoBusqueda;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param idFuncionario Valor a ser actualizado.
     */
    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosSesion() {
        return estadosSesion;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param estadosSesion Valor a ser actualizado.
     */
    public void setEstadosSesion(List<String> estadosSesion) {
        this.estadosSesion = estadosSesion;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public char getTipoBusqueda() {
        return tipoBusqueda;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param tipoBusqueda Valor a ser actualizado.
     */
    public void setTipoBusqueda(char tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
}
