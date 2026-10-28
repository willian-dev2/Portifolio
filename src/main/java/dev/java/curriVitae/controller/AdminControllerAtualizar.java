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
    @PutMapping("/Tecnologias/{id}")
    public ResponseEntity<TecnologiasDTO> atualizarTecnologias(@RequestBody TecnologiasDTO dto,
                                                               @PathVariable Long id){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarTecnologias(dto, id));

    }

    @PutMapping("/formacao/{id}")
    public ResponseEntity<FormacaoDTO> atualizarFormacao(@RequestBody FormacaoDTO dto,
                                                         @PathVariable Long id){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarFormacao(dto, id));

    }

    @PutMapping("/projetos/{id}")
    public ResponseEntity<ProjetosDTO> atualizarProjetos(@RequestBody ProjetosDTO dto,
                                                         @PathVariable Long id){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarProjetos(dto, id));

    }

    @PutMapping("/perfil/{id}")
    public ResponseEntity<PerfilDTO> atualizarPerfil(@RequestBody PerfilDTO dto,
                                                     @PathVariable Long id){

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarPerfil(dto, id));

    }

    @PutMapping("/experiencia/{id}")
    public ResponseEntity<ExperienciaDTO> atualizarExperiencia(@RequestBody ExperienciaDTO dto,
                                                               @PathVariable Long id) {

        return ResponseEntity.ok(serviceAdminAtualizar.atualizarExperiencia(dto, id));

    }


}
