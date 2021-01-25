/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroAsistentesModificadas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestRegistroInasistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.RequestTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseAsociarBeneficiarioSesion;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistencias;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroAsistentesModificadas;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseRegistroInasistentes;
import com.growdata.emprendimiento.business.dtos.sensibilizacion.ResponseTraerAsistentes;
import com.growdata.emprendimiento.business.dtos.valoracion.RequestAsociarBeneficiariosValoracion;
import com.growdata.emprendimiento.business.dtos.intentodto.ListaasistenciaDTO;

public interface ListaAsistenciaServicio {

    public ResponseTraerAsistentes getLista(RequestTraerAsistentes request);

    public ResponseRegistroAsistencias registroAsistencias(RequestRegistroAsistencias request);

    public ResponseRegistroAsistencias registroAsistenciasV(RequestRegistroAsistencias request);

    public ResponseRegistroAsistencias registroAsistenciasE(RequestRegistroAsistencias request);

    public ResponseRegistroAsistencias registroAsistenciasS(RequestRegistroAsistencias request);

    public ResponseRegistroInasistentes getListaInasistentes(RequestRegistroInasistentes request);

//    public ResponseRegistroAsistentesModificadas registroAsistenciasModificadas(RequestRegistroAsistentesModificadas request);
    public ResponseAsociarBeneficiarioSesion asociarBeneficiario(ListaasistenciaDTO listaDTO);

    public ResponseAsociarBeneficiarioSesion asociarBeneficiarioValoracion(RequestAsociarBeneficiariosValoracion request);

    public ResponseAsociarBeneficiarioSesion asociarBeneficiarioEvaluacionSeguimiento(RequestAsociarBeneficiariosValoracion request);

}
