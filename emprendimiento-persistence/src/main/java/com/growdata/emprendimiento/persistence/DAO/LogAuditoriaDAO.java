/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Logauditoria;
import java.util.Date;
import java.util.List;

public interface LogAuditoriaDAO {

    public void registrarLog(Logauditoria log) throws Exception;

    public List<Logauditoria> getLogsXFecha(Date fechaI, Date fechaF) throws Exception;
}
