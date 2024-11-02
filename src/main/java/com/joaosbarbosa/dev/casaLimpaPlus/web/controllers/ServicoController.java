package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.ServicoFormDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.services.WebServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    WebServicoService webServicoService;


    @GetMapping
    public ModelAndView listar() {
        return new ModelAndView("admin/servico/lista").addObject("servicos", webServicoService.listarServicos());
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        return new ModelAndView("admin/servico/form").addObject("formDTO", new ServicoFormDTO());
    }


    @PostMapping("/cadastrar")
    public String cadastrarServico(@Valid @ModelAttribute("formDTO") ServicoFormDTO formDTO, BindingResult bindResult) {
        if (bindResult.hasErrors()) return "admin/servico/form";
        webServicoService.cadastrarServico(formDTO);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editarServico(@PathVariable Long id) {
        return new ModelAndView("admin/servico/form").addObject("formDTO", webServicoService.buscarServicoPorId(id));
    }

    @PostMapping("/{id}/editar")
    public String editarServico(@PathVariable Long id, @Valid @ModelAttribute("formDTO") ServicoFormDTO formDTO, BindingResult bindResult) {
        if (bindResult.hasErrors()) return "admin/servico/form";

        webServicoService.editarServico(formDTO, id);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluirServico(@PathVariable Long id) {
        webServicoService.excluirPorId(id);
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}
