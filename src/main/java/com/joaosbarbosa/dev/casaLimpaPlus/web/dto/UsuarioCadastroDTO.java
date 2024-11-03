package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioCadastroDTO {

    private Long id;
    @NotNull
    @Size(min = 3, max = 50)
    private String nome;
    @Size(min = 0, max = 100)
    private String sobrenome;
    @Email
    @NotNull
    private String email;
    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String confirmaSenha;


    public UsuarioCadastroDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
}