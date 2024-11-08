package com.joaosbarbosa.dev.casaLimpaPlus.web.services;


import com.joaosbarbosa.dev.casaLimpaPlus.core.enums.TipoUsuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.SenhaIncorretaException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.SenhasNaoConferemException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.UsuarioJaCadastradoException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.UsuarioNaoEncontradoException;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repositories.UsuarioRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.AlterarSenhaForm;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioCadastroForm;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioEdicaoForm;
import com.joaosbarbosa.dev.casaLimpaPlus.web.interfaces.IConfirmacaoSenha;
import com.joaosbarbosa.dev.casaLimpaPlus.web.mappers.WebUsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class WebUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private WebUsuarioMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {
        validarConfirmacaoSenha(form);

        var model = mapper.toModel(form);

        var senhaHash = passwordEncoder.encode(model.getSenha());

        model.setSenha(senhaHash);
        model.setTipoUsuario(TipoUsuario.ADMIN);

        validarCamposUnicos(model);

        return repository.save(model);
    }

    public Usuario buscarPorId(Long id) {
        var mensagem = String.format("Usuário com ID %d não encontrado", id);

        return repository.findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public Usuario buscarPorEmail(String email) {
        var mensagem = String.format("Usuário com email %s não encontrado", email);

        return repository.findByEmail(email)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public UsuarioEdicaoForm buscarFormPorId(Long id) {
        var usuario = buscarPorId(id);

        return mapper.toForm(usuario);
    }

    public Usuario editar(UsuarioEdicaoForm form, Long id) {
        var usuario = buscarPorId(id);

        var model = mapper.toModel(form);
        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());

        validarCamposUnicos(model);

        return repository.save(model);
    }

    public void excluirPorId(Long id) {
        var usuario = buscarPorId(id);

        repository.delete(usuario);
    }

    public void alterarSenha(AlterarSenhaForm form, String email) {
        var usuario = buscarPorEmail(email);

        validarConfirmacaoSenha(form);

        var senhaAtual = usuario.getSenha();
        var senhaAntiga = form.getSenhaAntiga();

        var senha = form.getSenha();

        if (!passwordEncoder.matches(senhaAntiga, senhaAtual)) {
            var mensagem = "A senha antiga está incorreta";
            var fieldError = new FieldError(form.getClass().getName(), "senhaAntiga", senhaAntiga, false, null, null, mensagem);

            throw new SenhaIncorretaException(mensagem, fieldError);
        }

        var novaSenhaHash = passwordEncoder.encode(senha);
        usuario.setSenha(novaSenhaHash);
        repository.save(usuario);
    }

    private void validarConfirmacaoSenha(IConfirmacaoSenha obj) {
        var senha = obj.getSenha();
        var confirmacaoSenha = obj.getConfirmacaoSenha();

        if (!senha.equals(confirmacaoSenha)) {
            var mensagem = "Os dois campos de senha não conferem";
            var fieldError = new FieldError(obj.getClass().getName(), "confirmacaoSenha", obj.getConfirmacaoSenha(), false, null, null, mensagem);

            throw new SenhasNaoConferemException(mensagem, fieldError);
        }
    }

    private void validarCamposUnicos(Usuario usuario) {
        if (repository.isEmailJaCadastrado(usuario.getEmail(), usuario.getId())) {
            var mensagem = "Já existe um usuário cadastrado com esse e-mail";
            var fieldError = new FieldError(usuario.getClass().getName(), "email", usuario.getEmail(), false, null, null, mensagem);

            throw new UsuarioJaCadastradoException(mensagem, fieldError);
        }
    }
    
}
