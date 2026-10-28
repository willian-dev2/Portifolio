package dev.java.curriVitae.business.service;

import dev.java.curriVitae.business.dto.RegistroRequest;
import dev.java.curriVitae.business.mapper.UsuarioConverter;
import dev.java.curriVitae.infrastructure.entity.UsuarioEntity;
import dev.java.curriVitae.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioConverter usuarioConverter;


    @Value("${admin.setup-token}")
    private String setupToken;

    public RegistroRequest cadastrarAdmin(RegistroRequest usuarioDto) {
        travaParaRegistro(usuarioDto);

        usuarioDto.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));

        UsuarioEntity usuario = usuarioConverter.paraUsuarioEntity(usuarioDto);

        return usuarioConverter.
                paraRegistroRequest(
                usuarioRepository.
                        save(usuario)
                );

    }

    public void travaParaRegistro(RegistroRequest dto) {
        if (usuarioRepository.count() > 0) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cadastro desabilitado");
        }

        boolean verificacao = verificacaoCodigoSystem(dto.getCodigoSetup());
        if (!verificacao) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Código de setup inválido");
        }
    }


    public boolean verificacaoCodigoSystem(String codigoSystem) {
        return setupToken.isEmpty() || MessageDigest.isEqual(
                setupToken.getBytes(StandardCharsets.UTF_8),
                codigoSystem.getBytes(StandardCharsets.UTF_8));
    }


}
