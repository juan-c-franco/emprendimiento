/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.parametrizacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import com.growdata.emprendimiento.business.dtos.intentodto.CategoriaDTO;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public class ResponseGetCategorias extends ResponseDTO {

    private List<CategoriaDTO> categorias;

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaDTO> categorias) {
        this.categorias = categorias;
    }

}
