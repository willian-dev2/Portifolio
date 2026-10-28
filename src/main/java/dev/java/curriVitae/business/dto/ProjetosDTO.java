package dev.java.curriVitae.business.dto;

import dev.java.curriVitae.infrastructure.entity.TecnologiasEntity;
import dev.java.curriVitae.infrastructure.enums.StatusProjetoEnum;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjetosDTO {

    private Long id;
    private String slug;
    private String resumo;
    private String descricao;
    private String arquitetura;
    private String imagemCapaUrl;
    private String githubUrl;
    private StatusProjetoEnum status;
    private boolean destaque;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Set<TecnologiasEntity> tecnologias;

}
