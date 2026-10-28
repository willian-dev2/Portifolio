package dev.java.curriVitae.business.dto;

import dev.java.curriVitae.infrastructure.enums.CategoriaEnum;
import dev.java.curriVitae.infrastructure.enums.NivelEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TecnologiasDTO {

    private Long id;
    private String nome;
    private String icone;
    private CategoriaEnum categoria;
    private NivelEnum nivel;
    private boolean destaque;
    private int ordem;

}
