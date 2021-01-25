package com.growdata.emprendimiento.persistence.DAO;

////////////////
import com.growdata.emprendimiento.persistence.entidad.Sesiones;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

public interface SesionesDAO {

    //Deprecated??
    public List<Sesiones> getSesionesXFuncionario(long idFuncionario) throws Exception;

    public List<Sesiones> getSesionesPorFuncionarioTipoSesion(long idFuncionario,
            BigDecimal tiposesion, Date desde, int todos) throws Exception;

    public List<Sesiones> getSesionesVXFuncionario(long idFuncionario) throws Exception;

    public List<Sesiones> getSesiones() throws Exception;

    public Sesiones getSesiones(long saveIdSesion) throws Exception;

    public long saveSesiones(Sesiones sesion) throws Exception, HibernateException;

    public void updateSesiones(Sesiones sesion) throws Exception, HibernateException;

    public void deleteSesiones(Sesiones sesion) throws HibernateException, Exception;

    public void liberarSesiones(Sesiones sesion) throws HibernateException, Exception;

}
