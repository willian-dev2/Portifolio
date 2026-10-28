package dev.java.curriVitae.business.mapper;

import dev.java.curriVitae.business.dto.ProjetosDTO;
import dev.java.curriVitae.infrastructure.entity.ProjetosEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjetosConverter {

    ProjetosEntity toEntity(ProjetosDTO projetosDTO);

    ProjetosDTO toDto(ProjetosEntity projetosEntity);

    List<ProjetosEntity> listaEntity(List<ProjetosDTO> projetosDTO);

    List<ProjetosDTO> listaDto(List<ProjetosEntity> projetosDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityProjetos(ProjetosDTO dto, @MappingTarget ProjetosEntity projetosEntity);

}
