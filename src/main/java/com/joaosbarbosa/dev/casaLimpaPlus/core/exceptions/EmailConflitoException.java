package com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions;

import org.springframework.validation.FieldError;

public class EmailConflitoException extends ValidacaoException{

    public EmailConflitoException(FieldError error, String mensagem){
        super(error, mensagem);
    }
}
