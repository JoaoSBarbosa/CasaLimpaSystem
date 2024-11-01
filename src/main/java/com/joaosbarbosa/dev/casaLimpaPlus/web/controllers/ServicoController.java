package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin/servicos")
public class ServicoController {

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        var mv = new ModelAndView("admin/servico/form");
        mv.addObject("servico", new Servico());
//        mv.addObject("icones", Icone.values());
        return mv;
    }

    @ModelAttribute("icones")
    public Icone[] getIcones(){
        return Icone.values();
    }
}
