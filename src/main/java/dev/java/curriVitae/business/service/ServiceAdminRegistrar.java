package dev.java.curriVitae.business.service;

import dev.java.curriVitae.business.dto.*;
import dev.java.curriVitae.business.mapper.*;
import dev.java.curriVitae.infrastructure.entity.*;
import dev.java.curriVitae.infrastructure.exception.ResourceNotFoundException;
import dev.java.curriVitae.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceAdminRegistrar {


    // converters
    private final ProjetosConverter projetosConverter;
    private final ExperienciaConverter experienciaConverter;
    private final TecnologiasConverter tecnologiasConverter;
    private final PerfilConverter perfilConverter;
    private final FormacaoConverter formacaoConverter;

    // repositorys
    private final ProjetosRepository projetosRepository;
    private final ExperienciaRepository experienciaRepository;
    private final TecnologiasRepository tecnologiasRepository;
    private final PerfilRepository perfilRepository;
    private final FormacaoRepository formacaoRepository;


    // métodos para cadastrar novos itens no banco de dados
    public ExperienciaDTO salvarExperiencia(ExperienciaDTO experienciaDTO) {

        ExperienciaEntity experiencia = experienciaConverter.toEntity(experienciaDTO);
        experiencia.setId(null);
        experiencia.setTecnologias(buscarTecnologias(experienciaDTO.getTecnologias()));

        return experienciaConverter.toDto(experienciaRepository.save(experiencia));
    }

    public FormacaoDTO salvarFormacao(FormacaoDTO formacaoDTO) {

        FormacaoEntity formacao = formacaoConverter.toEntity(formacaoDTO);
        formacao.setId(null);

        return formacaoConverter.toDto(formacaoRepository.save(formacao));
    }

    public PerfilDTO salvarPerfil(PerfilDTO perfilDTO) {

        PerfilEntity perfil = perfilConverter.toEntity(perfilDTO);
        perfil.setId(null);

        return perfilConverter.toDto(perfilRepository.save(perfil));
    }


    public ProjetosDTO salvarProjetos(ProjetosDTO projetosDTO) {

        ProjetosEntity projetos = projetosConverter.toEntity(projetosDTO);
        projetos.setId(null);
        projetos.setTecnologias(buscarTecnologias(projetosDTO.getTecnologias()));

        return projetosConverter.toDto(projetosRepository.save(projetos));
    }



    public TecnologiasDTO salvarTecnologias(TecnologiasDTO tecnologiasDTO) {

        TecnologiasEntity tecnologias = tecnologiasConverter.toEntity(tecnologiasDTO);
        tecnologias.setId(null);

        return tecnologiasConverter.toDto(tecnologiasRepository.save(tecnologias));
    }


    // NOVO: busca no banco as tecnologias pelos ids recebidos no JSON
    private Set<TecnologiasEntity> buscarTecnologias(Set<TecnologiasDTO> tecnologiasDTO) {
        if (tecnologiasDTO == null || tecnologiasDTO.isEmpty()) {
            return new HashSet<>();
        }

        Set<Long> ids = tecnologiasDTO.stream()
                .map(TecnologiasDTO::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        List<TecnologiasEntity> encontradas = tecnologiasRepository.findAllById(ids);

        if (encontradas.size() != tecnologiasDTO.size()) {
            throw new ResourceNotFoundException("Uma ou mais tecnologias informadas não existem");
        }

        return new HashSet<>(encontradas);
    }
}
