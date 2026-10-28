package dev.java.curriVitae.controller;

import dev.java.curriVitae.business.dto.*;
import dev.java.curriVitae.business.service.ServiceAdminAtualizar;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin/atualizar")
@RestController
@RequiredArgsConstructor
public class AdminControllerAtualizar {


    private final ServiceAdminAtualizar serviceAdminAtualizar;


    // Todos os métodos de modificação e acesso do admin
    @PutMapping("/Tecnologias")
    public ResponseEntity<TecnologiasDTO> atualizarTecnologias(@RequestBody TecnologiasDTO dto){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarTecnologias(dto));

    }

    @PutMapping("/formacao")
    public ResponseEntity<FormacaoDTO> atualizarFormacao(@RequestBody FormacaoDTO dto){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarFormacao(dto));

    }

    @PutMapping("/projetos")
    public ResponseEntity<ProjetosDTO> atualizarProjetos(@RequestBody ProjetosDTO dto){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarProjetos(dto));

    }

    @PutMapping("/perfil")
    public ResponseEntity<PerfilDTO> atualizarPerfil(@RequestBody PerfilDTO dto){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarPerfil(dto));

    }

    @PutMapping("/experiencia")
    public ResponseEntity<ExperienciaDTO> atualizarExperiencia(@RequestBody ExperienciaDTO dto) {

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarExperiencia(dto));

    }


}
