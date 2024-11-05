package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEdicaoForm {

    @NotNull
    @Size(min = 3, max = 255)
    private String nome;
    @Size(min = 0, max = 255)
    private String sobrenome;
    @NotNull
    @Size(min = 3, max = 255)
    @Email
    private String email;
    
}
