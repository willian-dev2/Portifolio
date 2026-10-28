package dev.java.curriVitae.infrastructure.entity;

import dev.java.curriVitae.infrastructure.enums.CategoriaEnum;
import dev.java.curriVitae.infrastructure.enums.NivelEnum;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tecnologias")
@Builder
public class TecnologiasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "icone")
    private String icone;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaEnum categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "nível")
    private NivelEnum nivel;

    @Column(name = "destaque", length = 50)
    private boolean destaque;

    @Column(name = "ordem")
    private int ordem;

}
