package dev.java.curriVitae.controller;

import dev.java.curriVitae.business.dto.*;
import dev.java.curriVitae.business.service.UsuarioService;
import dev.java.curriVitae.infrastructure.entity.ExperienciaEntity;
import dev.java.curriVitae.infrastructure.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth/registrarAdmin")
    public ResponseEntity<RegistroRequest> registrar(@RequestBody @Valid RegistroRequest usuarioDto) {
        return ResponseEntity.ok(usuarioService.cadastrarAdmin(usuarioDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UsuarioLoginDTO usuarioDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(), usuarioDto.getSenha())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body("Bearer " + jwtUtil.generateToken(authentication.getName()));
    }

    // todos os métodos de retornos dos dados salvos no banco para o site.
    @GetMapping("/projetos")
    public ResponseEntity<List<ProjetosDTO>> projetosVitae(){
        return ResponseEntity.ok(usuarioService.retornarListaProjetos());
    }

    @GetMapping("/formacao")
    public ResponseEntity<List<FormacaoDTO>> formacaoVitae(){
        return ResponseEntity.ok(usuarioService.retornarListaFormacao());
    }

    @GetMapping("/tecnologias")
    public ResponseEntity<List<TecnologiasDTO>>  tecnologiasVitae(){
        return ResponseEntity.ok(usuarioService.retornarListaTecnologias());
    }

    @GetMapping("/perfil")
    public ResponseEntity<List<PerfilDTO>> perfilVitae(){
        return ResponseEntity.ok(usuarioService.retornarListaPerfil());
    }

    @GetMapping("/experiencia")
    public ResponseEntity<List<ExperienciaDTO>> experienciaVitae(){
        return ResponseEntity.ok(usuarioService.retornarListaExperiencia());
    }




    // buscar métodos por id
    @GetMapping("/buscar-experiencia/{id}")
    public ResponseEntity<ExperienciaDTO> buscarExperienciaPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarExperienciaPorId(id));
    }


    @GetMapping("/buscar-formacao/{id}")
    public ResponseEntity<FormacaoDTO> buscarFormacaoPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarFormacaoPorId(id));
    }


    @GetMapping("/buscar-perfil/{id}")
    public ResponseEntity<PerfilDTO> buscarPerfilPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarPerfilPorId(id));
    }


    @GetMapping("/buscar-projetos/{id}")
    public ResponseEntity<ProjetosDTO> buscarProjetosPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarProjetosPorId(id));
    }


    @GetMapping("/buscar-tecnologias/{id}")
    public ResponseEntity<TecnologiasDTO> buscarTecnologiasPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarTecnologiaPorId(id));
    }

}
