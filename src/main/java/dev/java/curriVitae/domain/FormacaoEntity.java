package dev.java.curriVitae.domain;

import dev.java.curriVitae.domain.enums.EscolaridadeEnum;
import dev.java.curriVitae.domain.enums.StatusEscolaridadeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "formacao")
public class FormacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instituicao", length = 50)
    private String instituicao;

    @Column(name = "curso", length = 50)
    private String curso;

    @Enumerated(EnumType.STRING)
    @Column(name = "escolaridade", length = 50)
    private EscolaridadeEnum tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_escolaridade", length = 50)
    private StatusEscolaridadeEnum status;

    @Column(name = "data_inicio", length = 50)
    private LocalDate DataInicio;

    @Column(name = "data_fim", length = 50)
    private LocalDate DataFim;

}
