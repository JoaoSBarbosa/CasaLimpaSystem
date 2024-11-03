package com.joaosbarbosa.dev.casaLimpaPlus.web.services;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.UsuarioRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    public UsuarioFormDTO findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new UsuarioFormDTO(usuario.get());
        } else {
            throw new RuntimeException("Não foi localizado registro de usuario com o id informado: " + id);
        }
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
    public void cadastrarUsuario(UsuarioFormDTO formUserDTO) {
        Usuario usuario = new Usuario();
        convertDtoToModel(formUserDTO, usuario);
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void editarUsuario(UsuarioFormDTO formUserDTO, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Não foi localizado registros de usuario com o id informado: " + id));
        convertDtoToModel(formUserDTO, usuario);

        usuarioRepository.save(usuario);

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