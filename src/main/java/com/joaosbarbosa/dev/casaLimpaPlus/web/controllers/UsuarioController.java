package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.TipoUsuario;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.FlashMessageDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioFormDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.services.WebUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {

    @Autowired
    WebUsuarioService usuarioService;
    @Autowired
    private WebUsuarioService webUsuarioService;

    @GetMapping
    public ModelAndView listarUsuarios() {
        return new ModelAndView("/admin/usuario/lista").addObject("usuarios", usuarioService.findAll());
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastroUsuario() {
        return new ModelAndView("/admin/usuario/form").addObject("formUserDTO", new UsuarioFormDTO());
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(
            @Valid @ModelAttribute("formUserDTO") UsuarioFormDTO formUserDTO,
            BindingResult result,
            RedirectAttributes attributes
    ) {
        if(result.hasErrors()) return "admin/usuario/form";

        webUsuarioService.cadastrarUsuario(formUserDTO);
        attributes.addFlashAttribute("alert", new FlashMessageDTO("alert-success", "Usuario cadastrado com sucesso!"));
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editarUsuario(@PathVariable Long id) {
        return new ModelAndView("/admin/usuario/form").addObject("formUserDTO", webUsuarioService.findById(id));
    }

    @PostMapping("/{id}/editar")
    public String editarUsuario(@PathVariable Long id, @Valid @ModelAttribute("formUserDTO") UsuarioFormDTO formUserDTO, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) return "admin/usuario/form";

        webUsuarioService.editarUsuario(formUserDTO,id);
        String alert = String.format("Usuário de ID [%d] editado com sucesso!", id);

        attributes.addFlashAttribute("alert", new FlashMessageDTO("alert-info", alert));
        return "redirect:/admin/usuarios";
    }

    @ModelAttribute("tiposUsuario")
    public TipoUsuario[] getTipoUsuario() {
        return TipoUsuario.values();
    }
}
