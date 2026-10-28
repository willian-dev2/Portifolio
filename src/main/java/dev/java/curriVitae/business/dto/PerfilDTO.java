package dev.java.curriVitae.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerfilDTO {


    private Long id;
    private String nome;
    private String titulo;
    private String bio;
    private String fotoUrl;
    private String localizacao;
    private String emailContato;
    private String gitHubUrl;
    private String linkedinUrl;
    private String curriculoPdfUrl;
    private boolean disponivel;

}
