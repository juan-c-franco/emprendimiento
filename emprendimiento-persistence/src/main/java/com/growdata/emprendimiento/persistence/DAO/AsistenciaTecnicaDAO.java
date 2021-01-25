package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.commons.CorreosAsistencias;
import com.growdata.emprendimiento.persistence.entidad.Asociados;
import com.growdata.emprendimiento.persistence.entidad.Documentos;
import com.growdata.emprendimiento.persistence.entidad.Listaasistenciaaat;
import com.growdata.emprendimiento.persistence.entidad.Rutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Sesionacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Temasrutaacompanamientoat;
import com.growdata.emprendimiento.persistence.entidad.Tipodocumentos;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;

public interface AsistenciaTecnicaDAO {

    public List<Sesionacompanamientoat> getSesionesAATPorFuncionario(
            List<String> estadosSesion, long idFuncionario) throws Exception;

    public long updateSesionAAT(Sesionacompanamientoat sesionAAT) throws Exception;

    public long updateSesionAATAsistencia(Sesionacompanamientoat sesionAAT,
            List<Listaasistenciaaat> listasAAT) throws Exception;

    public long setSesionAAT(Sesionacompanamientoat sesionAAT) throws Exception;

    public List<Sesionacompanamientoat> setSesionesAATPorSolapamiento(
            Sesionacompanamientoat sesionAAT) throws Exception;

    public void deleteSesionAAT(long idSessionAAT) throws Exception;

    public Sesionacompanamientoat getSesionAAT(long sesionAATId) throws HibernateException, Exception;

    public Temasrutaacompanamientoat getTemaRutaAAT(long idTemaRutaAAT) throws Exception;

    public List<Listaasistenciaaat> getListaAAT(long sesionAATId) throws Exception;

    public Rutaacompanamientoat getRutaAAT(long idEmprendimiento) throws Exception;

    public void setListaAAT(List<Asociados> asociados, Sesionacompanamientoat sesionAAT) throws HibernateException, Exception;

    public float getCantidadHorasEjecutadasPorTema(long idtemarutaacompanamientoat, long idEmprendimiento) throws HibernateException, Exception;

    public Listaasistenciaaat getListaAATPorId(long sesionAATId) throws Exception;

    public List<CorreosAsistencias> updateListaAAT(List<Listaasistenciaaat> listasAAT) throws HibernateException, Exception;

    public List<Temasrutaacompanamientoat> getTemasRutaAAT(long idEmprendimiento) throws Exception;

    public long updateTemaRutaAAT(Temasrutaacompanamientoat temaRutaAAT) throws Exception;

    public long setTemaRutaAAT(Temasrutaacompanamientoat temaRutaAAT) throws Exception;

    public Documentos getDocumento(long idDocumentoComite) throws Exception;

    public Tipodocumentos getTipoDocumento(BigDecimal idtipodocumento) throws Exception;

    public long updateDocumento(Documentos documentos) throws Exception;

    public long setDocumento(Documentos documentos) throws Exception;

    public List<Documentos> getDocumentos(long idEmprendimiento, BigDecimal idTipoDocumento) throws Exception;

    public void deleteDocumento(BigDecimal idDocumento) throws Exception;

    public void liberarSesiones(Sesionacompanamientoat sesion) throws HibernateException, Exception;
}
