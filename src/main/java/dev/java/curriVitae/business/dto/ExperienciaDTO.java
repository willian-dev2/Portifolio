package dev.java.curriVitae.business.dto;

import dev.java.curriVitae.infrastructure.entity.TecnologiasEntity;
import dev.java.curriVitae.infrastructure.enums.ContratoEnum;
import dev.java.curriVitae.infrastructure.enums.ModalidadeEnum;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienciaDTO {

    private Long id;
    private String empresa;
    private String cargo;
    private ContratoEnum tipo;
    private ModalidadeEnum modalidade;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;
    private Set<TecnologiasEntity> tecnologias;

}
