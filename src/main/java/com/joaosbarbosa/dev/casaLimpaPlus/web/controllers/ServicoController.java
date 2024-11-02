package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.ServicoRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.core.service.ServicoService;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.ServicoFormDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.mappers.WebServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired private ServicoService servicoService;
    @Autowired private ServicoRepository servicoRepository;
    @Autowired private WebServicoMapper webServicoMapper;


    @GetMapping
    public ModelAndView listar() {
        var mv = new ModelAndView("admin/servico/lista");
        mv.addObject("servicos", servicoRepository.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servico/form");
        mv.addObject("formDTO", new ServicoFormDTO());
        return mv;
    }


    @PostMapping("/cadastrar")
    public String cadastrarServico(@Valid ServicoFormDTO formDTO) {
        var modelServico = webServicoMapper.convertDTOToModel(formDTO);
        servicoRepository.save(modelServico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editarServico(@PathVariable Long id) {
        var mv = new ModelAndView("admin/servico/form");
        var modelServico = servicoRepository.findById(id);
        if(modelServico.isPresent()) {
            var formDto = webServicoMapper.convertModelToDTO(modelServico.get());
            mv.addObject("formDTO", formDto);
        }

        return mv;
    }

    @PostMapping("/{id}/editar")
    public String editarServico( @PathVariable Long id, @Valid ServicoFormDTO updateService) {

        var modelServico = webServicoMapper.convertDTOToModel(updateService);
        servicoRepository.save(modelServico);
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
