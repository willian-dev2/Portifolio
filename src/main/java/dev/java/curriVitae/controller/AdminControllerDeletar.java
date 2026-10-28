package dev.java.curriVitae.controller;

import dev.java.curriVitae.business.service.ServiceAdminDeletar;
import dev.java.curriVitae.business.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin/delete")
@RestController
@RequiredArgsConstructor
public class AdminControllerDeletar {


    private final ServiceAdminDeletar serviceAdminDeletar;

    // - Remoção -
    @DeleteMapping("/experiencia/{id}")
    public ResponseEntity<Void> deletarExperiencia(@PathVariable Long id) {
        serviceAdminDeletar.deletarExperiencia(id);

        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/formacao/{id}")
    public ResponseEntity<Void> deletarFormacao(@PathVariable Long id) {
        serviceAdminDeletar.deletarFormacao(id);

        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/perfil/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
        serviceAdminDeletar.deletarPerfil(id);

        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/projetos/{id}")
    public ResponseEntity<Void> deletarProjetos(@PathVariable Long id) {
        serviceAdminDeletar.deletarProjetos(id);

        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/tecnologias/{id}")
    public ResponseEntity<Void> deletarTecnologias(@PathVariable Long id) {
        serviceAdminDeletar.deletarTecnologias(id);

        return ResponseEntity.ok().build();
    }

}
