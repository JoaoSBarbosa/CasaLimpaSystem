package com.joaosbarbosa.dev.casaLimpaPlus.web.exception;

import com.joaosbarbosa.dev.casaLimpaPlus.core.component.StandardError;
import com.joaosbarbosa.dev.casaLimpaPlus.core.exception.ValuesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ValuesNotFoundException.class)
    public ResponseEntity<StandardError> handleValuesNotFoundException(ValuesNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setMessage(ex.getMessage());
        error.setError("Valor obrigatorio ausente😶‍🌫️");
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setPath(request.getRequestURI());
        return new ResponseEntity<>(error, status);
    }
}
