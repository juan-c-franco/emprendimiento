package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Sesioncomite;
import java.util.List;
import org.hibernate.HibernateException;

public interface EvaluacionemprendimientosDAO {

    public long save(Sesioncomite sesionComite, List<Character> aprobados,
            List<String> observaciones, List<Long> ids) throws Exception, HibernateException;

}
