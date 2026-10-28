package dev.java.curriVitae.business.dto;

import dev.java.curriVitae.infrastructure.enums.EscolaridadeEnum;
import dev.java.curriVitae.infrastructure.enums.StatusEscolaridadeEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormacaoDTO {

    private Long id;
    private String instituicao;
    private String curso;
    private EscolaridadeEnum tipo;
    private StatusEscolaridadeEnum status;
    private LocalDate DataInicio;
    private LocalDate DataFim;

}
