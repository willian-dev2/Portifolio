package dev.java.curriVitae.business.service;

import dev.java.curriVitae.business.mapper.*;
import dev.java.curriVitae.infrastructure.exception.ResourceNotFoundException;
import dev.java.curriVitae.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAdminDeletar {

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


    // métodos de delete

    public void deletarExperiencia(Long id) {
        if(!experienciaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Experiencia não encontrada");
        }

        experienciaRepository.deleteById(id);
    }



    public void deletarFormacao(Long id) {
        if(!formacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Formação não encontrada");
        }

        formacaoRepository.deleteById(id);
    }



    public void deletarPerfil(Long id) {
        if(!perfilRepository.existsById(id)) {
            throw new ResourceNotFoundException("Perfil não encontrado");
        }

        perfilRepository.deleteById(id);
    }



    public void deletarProjetos(Long id) {
        if(!projetosRepository.existsById(id)) {
            throw new ResourceNotFoundException("Projeto não encontrado");
        }

        projetosRepository.deleteById(id);
    }



    public void deletarTecnologias(Long id) {
        if(!tecnologiasRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tecnologia não encontrada");
        }

        tecnologiasRepository.deleteById(id);
    }

}
