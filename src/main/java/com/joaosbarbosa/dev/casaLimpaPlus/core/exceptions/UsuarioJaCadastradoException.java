package com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions;

import org.springframework.validation.FieldError;

public class UsuarioJaCadastradoException extends ValidacaoException {

    public UsuarioJaCadastradoException(String message, FieldError fieldError) {
        super(message, fieldError);
    }
    
}
