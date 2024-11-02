package com.joaosbarbosa.dev.casaLimpaPlus.core.models;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.enums.TipoUsuario;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString( onlyExplicitlyIncluded = true )
public class Usuario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;
    @Column( nullable = false)
    private String nome;
    private String sobrenome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column( nullable = false)
    private String senha;
    @Column( name = "tipo_usuario", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
