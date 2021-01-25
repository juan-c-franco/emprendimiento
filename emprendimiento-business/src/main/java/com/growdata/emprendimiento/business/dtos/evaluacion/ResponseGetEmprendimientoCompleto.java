package com.growdata.emprendimiento.business.dtos.evaluacion;

import com.growdata.emprendimiento.business.dtos.asistenciatecnica.TemasrutaacompanamientoatDTO;
import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.DocumentosDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.EmprendimientoDTO;
import java.util.List;

/**
 * Clase respuesta emprendimiento.
 *
 * @author Juan Franco
 */
public class ResponseGetEmprendimientoCompleto extends ResponseDTO {

    /**
     * Datos del emprendimiento.
     */
    private EmprendimientoDTO emprendimiento;

    /**
     * Lista de temas ruta.
     */
    private List<TemasrutaacompanamientoatDTO> temasRutasAAT;

    /**
     * Lista de documentos.
     */
    private List<DocumentosDTO> documentosDTO;

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<DocumentosDTO> getDocumentosDTO() {
        return documentosDTO;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param documentosDTO Valor a ser actualizado.
     */
    public void setDocumentosDTO(List<DocumentosDTO> documentosDTO) {
        this.documentosDTO = documentosDTO;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public List<TemasrutaacompanamientoatDTO> getTemasRutasAAT() {
        return temasRutasAAT;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param temasRutasAAT Valor a ser actualizado.
     */
    public void setTemasRutasAAT(
            List<TemasrutaacompanamientoatDTO> temasRutasAAT) {
        this.temasRutasAAT = temasRutasAAT;
    }

    /**
     * M�todo autogenerado para obtener una propiedad.
     *
     * @return Valor de la propiedad.
     */
    public EmprendimientoDTO getEmprendimiento() {
        return emprendimiento;
    }

    /**
     * M�todo autogenerado para actualizar una propiedad.
     *
     * @param emprendimiento Valor a ser actualizado.
     */
    public void setEmprendimiento(EmprendimientoDTO emprendimiento) {
        this.emprendimiento = emprendimiento;
    }
}
