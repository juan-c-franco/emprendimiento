/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.commons.AsistenciasValor2;
import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Beneficiario;
import com.growdata.emprendimiento.persistence.entidad.Encuesta;
import com.growdata.emprendimiento.persistence.entidad.Listaasistencia;
import com.growdata.emprendimiento.persistence.entidad.Tipoencuesta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

public interface ListaAsistenciaDAO {

    public List<Listaasistencia> getLista(long idsesion) throws Exception;

    public List<CorreosAsistencias> registroAsistencias(
            List<AsistenciasValor2> asistencias, int vigencia, long idsesion,
            Tipoencuesta tipoencuesta) throws Exception;

    public List<CorreosAsistencias> registroAsistenciasE(
            List<AsistenciasValor2> asistencias, int vigencia, long idsesion)
            throws Exception;

    public List<Listaasistencia> getListaInasistentes(int idsesion)
            throws Exception;

    public Listaasistencia registroAsistenciasModificadas(int asistencias)
            throws Exception;

    public List<Listaasistencia> traerNulos(long j) throws Exception;

    public Encuesta crearEncuesta(Encuesta encuesta) throws Exception;

    public void asociarBeneficiario(Listaasistencia lista, int meses_antes) throws Exception;

    public List<Beneficiario> asociarBeneficiarioValoracion(long idSesion, ArrayList<String> beneficiarios,
            int meses_antes) throws Exception, PersistenceException;

    public List<Beneficiario> asociarBeneficiarioEvaluacionSeguimiento(long idSesion, ArrayList<String> beneficiarios,
            int tipoSesion, int estadoEmprendimiento) throws Exception, PersistenceException;
}
