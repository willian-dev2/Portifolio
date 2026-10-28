package dev.java.curriVitae.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "perfil")
@Builder
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "bio", length = 300)
    private String bio;

    @Column(name = "fotoUrl", length = 50)
    private String fotoUrl;

    @Column(name = "localização", length = 50)
    private String localizacao;

    @Column(name = "emailContato", length = 50)
    private String emailContato;

    @Column(name = "GitHub", length = 100)
    private String gitHubUrl;

    @Column(name = "Linkedin", length = 100)
    private String linkedinUrl;

    @Column(name = "Curriculo", length = 100)
    private String curriculoPdfUrl;

    @Column(name = "disponibilidade")
    private boolean disponivel;

}
