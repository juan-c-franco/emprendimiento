package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.LogauditoriaDTO;
import java.util.List;

public class ResponseTraerLogA extends ResponseDTO {

    private List<LogauditoriaDTO> logs;

    public List<LogauditoriaDTO> getLogs() {
        return logs;
    }

    public void setLogs(List<LogauditoriaDTO> logs) {
        this.logs = logs;
    }

}
