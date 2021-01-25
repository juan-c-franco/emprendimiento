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
     * Tipo de búsqueda.
     */
    private char tipoBusqueda;

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public long getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param idFuncionario Valor a ser actualizado.
     */
    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<String> getEstadosSesion() {
        return estadosSesion;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param estadosSesion Valor a ser actualizado.
     */
    public void setEstadosSesion(List<String> estadosSesion) {
        this.estadosSesion = estadosSesion;
    }

    /**
     * Método autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public char getTipoBusqueda() {
        return tipoBusqueda;
    }

    /**
     * Método autogenerado para actualizar una propiedad.
     *
     * @param tipoBusqueda Valor a ser actualizado.
     */
    public void setTipoBusqueda(char tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
}
