package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlashMessage {
    
    private String cssStyleClass;

    private String message;

}
