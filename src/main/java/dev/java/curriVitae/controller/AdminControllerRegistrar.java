package dev.java.curriVitae.controller;

import dev.java.curriVitae.business.dto.*;
import dev.java.curriVitae.business.service.ServiceAdminRegistrar;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/admin/registrar")
@RestController
@RequiredArgsConstructor
public class AdminControllerRegistrar {

    private final ServiceAdminRegistrar serviceAdminRegistrar;

    // Criação e remoção de novos itens no sistema
    // - Criação -
    @PostMapping("/experiencia")
    public ResponseEntity<ExperienciaDTO> registrarNovaExperiencia(@RequestBody @Valid ExperienciaDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAdminRegistrar.salvarExperiencia(dto));
    }


    @PostMapping("/formacao")
    public ResponseEntity<FormacaoDTO> registrarNovaformacao(@RequestBody @Valid FormacaoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAdminRegistrar.salvarFormacao(dto));
    }


    @PostMapping("/perfil")
    public ResponseEntity<PerfilDTO> registrarNovoPerfil(@RequestBody @Valid PerfilDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAdminRegistrar.salvarPerfil(dto));
    }


    @PostMapping("/projetos")
    public ResponseEntity<ProjetosDTO> registrarNovoProjeto(@RequestBody @Valid ProjetosDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAdminRegistrar.salvarProjetos(dto));
    }


    @PostMapping("/formacao")
    public ResponseEntity<TecnologiasDTO> registrarNovaTecnologia(@RequestBody @Valid TecnologiasDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAdminRegistrar.salvarTecnologias(dto));
    }

}
