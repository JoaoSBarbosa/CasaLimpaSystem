package com.joaosbarbosa.dev.casaLimpaPlus.core.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardError {
    private Instant timestamp;
    private String error;
    private String message;
    private Integer status;
    private String path;
}
