package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlashMessageDTO {

    private String cssStyleClass;
    private String message;

}
