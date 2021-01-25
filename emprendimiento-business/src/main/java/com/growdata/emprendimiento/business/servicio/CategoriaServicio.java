/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.servicio;

import com.growdata.emprendimiento.business.dtos.parametrizacion.RequestCategoria;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseGetCategorias;
import com.growdata.emprendimiento.business.dtos.parametrizacion.ResponseTraerCategoria;
import com.growdata.emprendimiento.business.commons.ResponseDTO;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public interface CategoriaServicio {

    public ResponseGetCategorias getCategorias();

    public ResponseDTO crearCategoria(RequestCategoria request);

    public ResponseDTO modificarCategoria(RequestCategoria request);

    public ResponseTraerCategoria traerCategoria(RequestCategoria request);
}
