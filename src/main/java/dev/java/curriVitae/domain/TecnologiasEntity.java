package dev.java.curriVitae.domain;

import dev.java.curriVitae.domain.enums.CategoriaEnum;
import dev.java.curriVitae.domain.enums.NivelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tecnologias")
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
