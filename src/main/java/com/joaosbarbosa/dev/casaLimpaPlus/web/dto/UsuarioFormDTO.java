package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioFormDTO {

    private Long id;
    @NotNull
    @Size(min = 3, max = 30)
    private String nome;
    @Size(min = 0, max = 30)
    private String sobrenome;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String senha;
    @NotNull
    private TipoUsuario tipoUsuario;

    public UsuarioFormDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.tipoUsuario = usuario.getTipoUsuario();

    }
}
