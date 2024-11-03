package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
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
public class UsuarioEdicaoDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;
    @Size(min = 0, max = 100)
    private String sobrenome;
    @Email
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String email;

    public UsuarioEdicaoDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
    }
}
