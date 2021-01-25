/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.growdata.emprendimiento.web.controlador;

import com.growdata.emprendimiento.business.dtos.intentodto.FuncionarioDTO;
import com.growdata.emprendimiento.business.dtos.seguridad.ResponseTraerFuncionarios;
import com.growdata.emprendimiento.business.commons.EncriptadorUrl;
import com.growdata.emprendimiento.business.servicio.FuncionarioServicio;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AjaxController {

    @Autowired
    private FuncionarioServicio funcionarioServicio;

    /**
     * Controlador encargado de traer los funcionarios de una caja de
     * compensación y determinado grupo.
     *
     * @param idcajacompensacion Identificador Caja de Compensación
     * @param grupo Grupo al que deben pertenercer los funcionarios.
     * @return Lista de Funcionarios que cumplan con el criterio de búsqueda.
     */
    @GetMapping(path = "/traerFuncionarios", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FuncionarioDTO> traerFuncionarios(@RequestParam("idCaja") BigDecimal idcajacompensacion,
            @RequestParam("grupo") BigDecimal grupo) {
        ResponseTraerFuncionarios response;
        response = funcionarioServicio.getFuncionariosPorGrupoYCaja(grupo, idcajacompensacion);
        return response.getFuncionariosDTO();
    }

    @GetMapping("/fyrh")
    public String decoder(@RequestParam("xjzlv") String xjzlv, Model model) {
        String decodificado = EncriptadorUrl.decode(xjzlv);
        String[] aux = decodificado.split("/?");
        String datos = aux[1];
        String[] aux2 = datos.split("&");
        for (String s : aux2) {
            String[] aux3 = s.split("=");
            model.addAttribute(aux3[0], aux3[1]);
        }
        String vista = aux[0];
        return vista;
    }
}
