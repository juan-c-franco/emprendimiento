/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.business.dtos.capacitacion;

import com.growdata.emprendimiento.business.commons.ResponseDTO;
import java.util.List;

/**
 *
 * @author Juan Franco
 */
public class ResponseModulocicloCheck extends ResponseDTO {

    private List<RequestModulocicloCheck> list;

    public List<RequestModulocicloCheck> getList() {
        return list;
    }

    public void setList(List<RequestModulocicloCheck> list) {
        this.list = list;
    }

}
