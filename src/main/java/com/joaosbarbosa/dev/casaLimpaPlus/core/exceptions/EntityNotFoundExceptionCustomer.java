package com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class EntityNotFoundExceptionCustomer extends EntityNotFoundException {
    public EntityNotFoundExceptionCustomer(String message) {
        super(message);
    }

}
