package dev.java.curriVitae.business.service;

import dev.java.curriVitae.business.dto.*;
import dev.java.curriVitae.business.mapper.*;
import dev.java.curriVitae.infrastructure.entity.*;
import dev.java.curriVitae.infrastructure.exception.ResourceNotFoundException;
import dev.java.curriVitae.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    // security
    private final PasswordEncoder passwordEncoder;

    // converters
    private final UsuarioConverter usuarioConverter;
    private final ProjetosConverter projetosConverter;
    private final ExperienciaConverter experienciaConverter;
    private final TecnologiasConverter  tecnologiasConverter;
    private final PerfilConverter perfilConverter;
    private final FormacaoConverter formacaoConverter;

    // repositorys
    private final ProjetosRepository projetosRepository;
    private final UsuarioRepository usuarioRepository;
    private final ExperienciaRepository experienciaRepository;
    private final TecnologiasRepository  tecnologiasRepository;
    private final PerfilRepository perfilRepository;
    private final FormacaoRepository formacaoRepository;


    // Para Entitys Usuario
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
        if (setupToken == null || setupToken.isBlank() || codigoSystem == null) {
            return false;
        }
        return MessageDigest.isEqual(
                setupToken.getBytes(StandardCharsets.UTF_8),
                codigoSystem.getBytes(StandardCharsets.UTF_8));
    }


    // Método para retorno de dados para o site
    public List<ProjetosDTO> retornarListaProjetos() {
        List<ProjetosEntity> projetos = projetosRepository.findAll();
        return projetosConverter.listaDto(projetos);
    }


    public List<ExperienciaDTO> retornarListaExperiencia() {
        List<ExperienciaEntity> experiencia = experienciaRepository.findAll();
        return experienciaConverter.listaDto(experiencia);
    }


    public List<FormacaoDTO> retornarListaFormacao() {
        List<FormacaoEntity> formacao = formacaoRepository.findAll();
        return formacaoConverter.listaDto(formacao);
    }


    public List<PerfilDTO> retornarListaPerfil() {
        List<PerfilEntity> perfil = perfilRepository.findAll();
        return perfilConverter.listaDto(perfil);
    }



    public List<TecnologiasDTO>  retornarListaTecnologias() {
        List<TecnologiasEntity> tecnologias = tecnologiasRepository.findAll();
        return tecnologiasConverter.listaDto(tecnologias);
    }




    // buscar item por Id
    public ExperienciaDTO buscarExperienciaPorId(Long id){
        return experienciaRepository.findById(id)
                .map(experienciaConverter::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Experiencia não encontrada"));
    }


    public FormacaoDTO buscarFormacaoPorId(Long id){
        return formacaoRepository.findById(id)
                .map(formacaoConverter::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Formação não encontrada"));
    }


    public PerfilDTO buscarPerfilPorId(Long id){
        return perfilRepository.findById(id)
                .map(perfilConverter::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrada"));
    }


    public ProjetosDTO buscarProjetosPorId(Long id){
        return projetosRepository.findById(id)
                .map(projetosConverter::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Projetos não encontrada"));
    }


    public TecnologiasDTO buscarTecnologiaPorId(Long id){
        return tecnologiasRepository.findById(id)
                .map(tecnologiasConverter::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Tecnologias não encontrada"));
    }

}
