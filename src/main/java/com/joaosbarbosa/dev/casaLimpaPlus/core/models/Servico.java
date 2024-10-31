package com.joaosbarbosa.dev.casaLimpaPlus.core.models;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.Icone;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_servico")
@ToString( onlyExplicitlyIncluded = true)
public class Servico {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( length = 50, nullable = false )
    private String nome;
    @Column(name = "qtd_horas", nullable = false)
    private Integer qtdHoras;
    @Column(name = "horas_quarto", nullable = false)
    private Integer horasQuarto;
    @Column(name = "horas_sala", nullable = false)
    private Integer horasSala;
    @Column(name = "horas_cozinha", nullable = false)
    private Integer horasCozinha;
    @Column(name = "horas_banheiro", nullable = false)
    private Integer horasBanheiro;
    @Column(name = "horas_quintal", nullable = false)
    private Integer horasQuintal;
    @Column(name = "horas_outros", nullable = false)
    private Integer horasOutros;
    @Column(nullable = false)
    private Integer posicao;

    @Column(name = "valor_minimo", nullable = false)
    private BigDecimal valorMinimo;
    @Column(name = "porcentagem_comissao", nullable = false)
    private BigDecimal porcentagemComissao;
    @Column(name = "valor_quarto", nullable = false)
    private BigDecimal valorQuarto;
    @Column(name = "valor_sala", nullable = false)
    private BigDecimal valorSala;
    @Column(name = "valor_cozinha", nullable = false)
    private BigDecimal valorCozinha;
    @Column(name = "valor_banheiro", nullable = false)
    private BigDecimal valorBanheiro;
    @Column(name = "valor_quintal", nullable = false)
    private BigDecimal valorQuintal;
    @Column(name = "valor_outros", nullable = false)
    private BigDecimal valorOutros;
    @Column(nullable = false, length = 14)
    @Enumerated(EnumType.STRING)
    private Icone icone;


}

