package dev.java.curriVitae.infrastructure.entity;

import dev.java.curriVitae.infrastructure.enums.ContratoEnum;
import dev.java.curriVitae.infrastructure.enums.ModalidadeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "experiencia")
public class ExperienciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "empresa", length = 50)
    private String empresa;
    @Column(name = "cargo", length = 50)
    private String cargo;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contrato", length = 50)
    private ContratoEnum tipo;
    @Enumerated(EnumType.STRING)
    @Column(name = "modalidade_do_trabalho", length = 50)
    private ModalidadeEnum modalidade;
    @Column(name = "data_inicio", length = 50)
    private LocalDate dataInicio;
    @Column(name = "data_fim", length = 50)
    private LocalDate dataFim;
    @Column(name = "descricao", length = 300)
    private String descricao;
    @ManyToMany
    @JoinTable(
            name = "projeto_tecnologia",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id")
    )
    private Set<TecnologiasEntity> tecnologias = new HashSet<>();

}
