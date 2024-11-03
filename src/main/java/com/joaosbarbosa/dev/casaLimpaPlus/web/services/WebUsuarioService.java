package com.joaosbarbosa.dev.casaLimpaPlus.web.services;

import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.SenhasDiferemException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.TipoUsuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.UsuarioRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioCadastroDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioEdicaoDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioFormDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.mappers.WebUsuarioMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    WebUsuarioMapperImpl mapper;


    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi localizado registro de usuario com o id informado: " + id));
    }

    @Transactional(readOnly = true)
    public UsuarioEdicaoDTO buscarUsuarioEdicaoDTO(Long id) {
        return mapper.toDTOForEdit(findById(id));
    }

    @Transactional(readOnly = true)
    public List<UsuarioFormDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioFormDTO> usuarioFormDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioFormDTOS.add(new UsuarioFormDTO(usuario));
        }
        return usuarioFormDTOS;
    }


    @Transactional
    public Usuario cadastraUsuario(UsuarioCadastroDTO formUserDTO) {
        if (formUserDTO.getSenha() != null && formUserDTO.getConfirmaSenha() != null) {
            System.out.println("SENHA: " + formUserDTO.getSenha());
            System.out.println("CONFIRMADA: " + formUserDTO.getConfirmaSenha());
            if (!formUserDTO.getSenha().equals(formUserDTO.getConfirmaSenha())) {
                var filedMessage = "As senhas são diferentes";
                var fieldError = new FieldError(formUserDTO.getClass().getName(), "confirmaSenha", formUserDTO.getConfirmaSenha(), false, null, null, filedMessage);
                throw new SenhasDiferemException(fieldError, filedMessage);
            }
        }


        var model = mapper.toModel(formUserDTO);

        model.setTipoUsuario(TipoUsuario.ADMIN);
        return usuarioRepository.save(model);
    }


    @Transactional
    public Usuario editarUsuario(UsuarioEdicaoDTO formDto, Long id) {
        var usuario = findById(id);

        var model = mapper.toModelForEdit(formDto);
        model.setId(id);
        model.setTipoUsuario(usuario.getTipoUsuario());
        model.setSenha(usuario.getSenha());


        return usuarioRepository.save(model);

    }


    @Transactional
    public void excluirUsuario(Long id) {
        var model = findById(id);
        usuarioRepository.delete(model);
    }

    private void convertDtoToModel(UsuarioFormDTO formUserDTO, Usuario usuario) {
        if (formUserDTO.getId() != null) usuario.setId(formUserDTO.getId());
        if (formUserDTO.getNome() != null) usuario.setNome(formUserDTO.getNome());
        if (formUserDTO.getEmail() != null) usuario.setEmail(formUserDTO.getEmail());
        if (formUserDTO.getSenha() != null) usuario.setSenha(formUserDTO.getSenha());
        if (formUserDTO.getSobrenome() != null) usuario.setSobrenome(formUserDTO.getSobrenome());
        if (formUserDTO.getTipoUsuario() != null) usuario.setTipoUsuario(formUserDTO.getTipoUsuario());
    }
}
