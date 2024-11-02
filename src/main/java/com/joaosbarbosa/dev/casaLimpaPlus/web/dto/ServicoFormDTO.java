package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicoFormDTO {

    private Long id;
    @NotNull
    @Size(min = 3, max = 50)
    private String nome;
    @NotNull
    @PositiveOrZero
    private Integer qtdHoras;
    @NotNull
    @PositiveOrZero
    private Integer horasQuarto;
    @NotNull
    @PositiveOrZero
    private Integer horasSala;
    @NotNull
    @PositiveOrZero
    private Integer horasCozinha;
    @NotNull
    @PositiveOrZero
    private Integer horasBanheiro;
    @NotNull
    @PositiveOrZero
    private Integer horasQuintal;
    @NotNull
    @PositiveOrZero
    private Integer horasOutros;
    @NotNull
    @Positive
    private Integer posicao;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorMinimo;
    @Max(100)
    @NotNull
    @PositiveOrZero
    private BigDecimal porcentagemComissao;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorQuarto;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorSala;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorCozinha;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorBanheiro;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorQuintal;
    @NotNull
    @PositiveOrZero
    private BigDecimal valorOutros;
    @NotNull
    private Icone icone;
}
