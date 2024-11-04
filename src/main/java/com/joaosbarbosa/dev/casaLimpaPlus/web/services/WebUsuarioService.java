package com.joaosbarbosa.dev.casaLimpaPlus.web.services;

import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.EmailConflitoException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.SenhasDiferemException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.TipoUsuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.UsuarioRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.web.controllers.UsuarioController;
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

        validarSenhas(formUserDTO);


        var model = mapper.toModel(formUserDTO);
        validarEmail( model );

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

        validarEmail( model );


        return usuarioRepository.save(model);

    }

    @Transactional
    public void excluirUsuario(Long id) {
        var model = findById(id);
        usuarioRepository.delete(model);
    }





    private void validarSenhas(UsuarioCadastroDTO formUserDTO) {
        if (formUserDTO.getSenha() != null && formUserDTO.getConfirmaSenha() != null) {
            if (!formUserDTO.getSenha().equals(formUserDTO.getConfirmaSenha())) {
                String mensagemErro = "As senhas não coincidem.";
                FieldError erroCampo = new FieldError(
                        formUserDTO.getClass().getName(),
                        "confirmaSenha",
                        formUserDTO.getConfirmaSenha(),
                        false,
                        null,
                        null,
                        mensagemErro
                );
                throw new SenhasDiferemException(erroCampo, mensagemErro);
            }
        }
    }

    private void validarEmail(Usuario entity){
        if ( entity.getEmail() != null){
            if(usuarioRepository.existsByEmailAndId(entity.getEmail(), entity.getId())){
                gerarExcecaoEmailEmUso(entity);
            }
        }
    }

//    private void validarEmail(Usuario enity, boolean isEdit){
//        if ( enity.getEmail() != null){
//            usuarioRepository.findByEmail(enity.getEmail()).ifPresent((usuarioExistente)->{
//                // Caso seja uma edição, verificar se o e-mail pertence a outro usuário
//                if (!isEdit || !usuarioExistente.getId().equals(enity.getId())){
//                    gerarExcecaoEmailEmUso(usuarioExistente);
//                }
//            });
//        }
//    }
    // Método auxiliar para lançar a exceção de e-mail já em uso
    private void gerarExcecaoEmailEmUso(Usuario entity) {
        String mensagemErro = "O e-mail já está em uso.";
        FieldError erroCampo = new FieldError(
                Usuario.class.getName(),
                "email",
                entity.getEmail(),
                false,
                null,
                null,
                mensagemErro
        );
        throw new EmailConflitoException(erroCampo, mensagemErro);
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
