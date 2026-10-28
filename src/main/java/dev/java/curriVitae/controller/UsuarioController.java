package dev.java.curriVitae.controller;

import dev.java.curriVitae.business.dto.RegistroRequest;
import dev.java.curriVitae.business.dto.UsuarioLoginDTO;
import dev.java.curriVitae.business.service.UsuarioService;
import dev.java.curriVitae.infrastructure.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok("Bearer " + jwtUtil.generateToken(authentication.getName()));
    }

}
