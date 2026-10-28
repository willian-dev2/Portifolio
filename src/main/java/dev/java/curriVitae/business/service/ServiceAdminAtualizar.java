package dev.java.curriVitae.business.service;

import dev.java.curriVitae.business.dto.*;
import dev.java.curriVitae.business.mapper.*;
import dev.java.curriVitae.infrastructure.entity.*;
import dev.java.curriVitae.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAdminAtualizar {


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


    // métodos para atualização das tabelas
    public ExperienciaDTO atualizarExperiencia(ExperienciaDTO experienciaDTO, Long id) {

        ExperienciaEntity experencia = experienciaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Experiência não encontrada"));

        experienciaConverter.updateEntityExperiencia(experienciaDTO, experencia);

        return experienciaConverter.toDto(experienciaRepository.save(experencia));
    }



    public FormacaoDTO atualizarFormacao(FormacaoDTO formacaoDTO, Long id) {

        FormacaoEntity formacao = formacaoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tabela não encontrada"));

        formacaoConverter.updateEntityFormacao(formacaoDTO, formacao);

        return formacaoConverter.toDto(formacaoRepository.save(formacao));
    }



    public TecnologiasDTO atualizarTecnologias(TecnologiasDTO tecnologiasDTO, Long id) {

        TecnologiasEntity tecnologia = tecnologiasRepository.findById(id).orElseThrow(
                () -> new  RuntimeException("Tabela não encontrada"));

        tecnologiasConverter.updateEntityTecnologias(tecnologiasDTO, tecnologia);

        return tecnologiasConverter.toDto(tecnologiasRepository.save(tecnologia));
    }



    public ProjetosDTO atualizarProjetos(ProjetosDTO projetosDTO, Long id) {

        ProjetosEntity projetos = projetosRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tabela não encontrada"));

        projetosConverter.updateEntityProjetos(projetosDTO, projetos);

        return projetosConverter.toDto(projetosRepository.save(projetos));
    }



    public PerfilDTO atualizarPerfil(PerfilDTO perfilDTO, Long id) {

        PerfilEntity perfil = perfilRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tabela não encontrada"));

        perfilConverter.updateEntityPerfil(perfilDTO, perfil);

        return perfilConverter.toDto(perfilRepository.save(perfil));
    }

}
