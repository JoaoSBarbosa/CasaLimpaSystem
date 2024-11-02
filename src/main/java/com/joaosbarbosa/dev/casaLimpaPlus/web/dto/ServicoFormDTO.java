package com.joaosbarbosa.dev.casaLimpaPlus.web.dto;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
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
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorMinimo;
    @Max(100)
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.PERCENT, pattern = "##0,00%")
    private BigDecimal porcentagemComissao;
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuarto;
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorSala;
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorCozinha;
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorBanheiro;
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuintal;
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorOutros;
    @NotNull
    private Icone icone;

    public ServicoFormDTO(
            Long id,
            String nome,
            Integer qtdHoras,
            Integer horasQuarto,
            Integer horasSala,
            Integer horasCozinha,
            Integer horasBanheiro,
            Integer horasQuintal,
            Integer horasOutros,
            Integer posicao,
            BigDecimal valorMinimo,
            BigDecimal porcentagemComissao,
            BigDecimal valorQuarto,
            BigDecimal valorSala,
            BigDecimal valorCozinha,
            BigDecimal valorBanheiro,
            BigDecimal valorQuintal,
            BigDecimal valorOutros,
            Icone icone) {
        this.id = id;
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.horasQuarto = horasQuarto;
        this.horasSala = horasSala;
        this.horasCozinha = horasCozinha;
        this.horasBanheiro = horasBanheiro;
        this.horasQuintal = horasQuintal;
        this.horasOutros = horasOutros;
        this.posicao = posicao;
        this.valorMinimo = valorMinimo;
        this.porcentagemComissao = porcentagemComissao;
        this.valorQuarto = valorQuarto;
        this.valorSala = valorSala;
        this.valorCozinha = valorCozinha;
        this.valorBanheiro = valorBanheiro;
        this.valorQuintal = valorQuintal;
        this.valorOutros = valorOutros;
        this.icone = icone;
    }

    public ServicoFormDTO(
            Servico entity) {
        id = entity.getId();
        nome = entity.getNome();
        qtdHoras = entity.getQtdHoras();
        horasQuarto = entity.getHorasQuarto();
        horasSala = entity.getHorasSala();
        horasCozinha = entity.getHorasCozinha();
        horasBanheiro = entity.getHorasBanheiro();
        horasQuintal = entity.getHorasQuintal();
        horasOutros = entity.getHorasOutros();
        posicao = entity.getPosicao();
        valorMinimo = entity.getValorMinimo();
        porcentagemComissao = entity.getPorcentagemComissao();
        valorQuarto = entity.getValorQuarto();
        valorSala = entity.getValorSala();
        valorCozinha = entity.getValorCozinha();
        valorBanheiro = entity.getValorBanheiro();
        valorQuintal = entity.getValorQuintal();
        valorOutros = entity.getValorOutros();
        icone = entity.getIcone();
    }
}
