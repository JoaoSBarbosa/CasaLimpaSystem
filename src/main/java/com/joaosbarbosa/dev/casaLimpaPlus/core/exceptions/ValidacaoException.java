package com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions;

import org.springframework.validation.FieldError;

public class ValidacaoException extends RuntimeException {

    private FieldError fieldError;

    public ValidacaoException(FieldError fieldError, String mensagem) {
        super(mensagem);
        this.fieldError = fieldError;
    }

    public FieldError getFieldError() {
        return fieldError;
    }
}
