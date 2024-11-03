package com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions;

import org.springframework.validation.FieldError;

public class SenhasDiferemException extends ValidacaoException{
    public SenhasDiferemException(FieldError fieldError, String mensagem) {
        super(fieldError, mensagem);
    }
}
