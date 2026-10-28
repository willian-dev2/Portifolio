package dev.java.curriVitae.infrastructure.entity;

import dev.java.curriVitae.infrastructure.enums.StatusProjetoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "projetos")
@Builder
public class ProjetosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "slug", length = 300)
    private String slug;

    @Column(name = "resumo", length = 200)
    private String resumo;

    @Column(name = "descricao", length = 400)
    private String descricao;

    @Column(name = "arquitetura", length = 400)
    private String arquitetura;

    @Column(name = "imagem")
    private String imagemCapaUrl;

    @Column(name = "gitHub", length = 200)
    private String githubUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_projeto", length = 50)
    private StatusProjetoEnum status;

    @Column(name = "destaque")
    private boolean destaque;

    @Column(name = "data_inicio", length = 300)
    private LocalDate dataInicial;

    @Column(name = "data_fim", length = 300)
    private LocalDate dataFinal;

    @ManyToMany
    @JoinTable(
            name = "projeto_tecnologia",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id")
    )
    private Set<TecnologiasEntity> tecnologias = new HashSet<>();

}
