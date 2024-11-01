package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.ServicoRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.core.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    ServicoService servicoService;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private DefaultErrorAttributes errorAttributes;

    @GetMapping
    public ModelAndView listar() {
        var mv = new ModelAndView("admin/servico/lista");
        mv.addObject("servicos", servicoRepository.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servico/form");
        mv.addObject("servico", new Servico());
        return mv;
    }


    @PostMapping("/cadastrar")
    public String cadastrarServico(Servico servico) {
//        servicoService.cadastrarServico(servico);
        servicoRepository.save(servico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editarServico(@PathVariable Long id) {
        var mv = new ModelAndView("admin/servico/form");
        mv.addObject("servico", servicoRepository.findById(id));
        return mv;
    }

    @PostMapping("/{id}/editar")
    public String editarServico(@PathVariable Long id, Servico updateService) {

        servicoRepository.save(updateService);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluirServico(@PathVariable Long id) {
        servicoRepository.deleteById(id);
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}
