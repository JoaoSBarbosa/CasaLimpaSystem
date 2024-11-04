package com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class UsuarioNaoEncontradoException extends EntityNotFoundException {

    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
    
}
