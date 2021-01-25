/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.growdata.emprendimiento.persistence.DAO;

import com.growdata.emprendimiento.persistence.entidad.Categoria;
import java.util.List;

/**
 *
 * @author Andrés Felipe González M. Andres Gonzalez
 */
public interface CategoriaDAO {
    
    public List<Categoria> getCategorias() throws Exception;
    
   public long crearCategoria(Categoria categoria) throws Exception;
    
    public void modificarCategoria(Categoria categoria) throws Exception;
    
    public Categoria traerCategoria(long id) throws Exception;
    
    public Categoria traerCategoriaporNombre(String nombre, long id) throws Exception;
    

}
