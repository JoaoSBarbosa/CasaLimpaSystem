package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.ServicoRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.core.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    ServicoService servicoService;
    @Autowired private ServicoRepository servicoRepository;

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servico/form");
        mv.addObject("servico", new Servico());
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastrarServico(Servico servico) {
        servicoService.cadastrarServico(servico);
        return "redirect:/admin/servicos/cadastrar";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}
