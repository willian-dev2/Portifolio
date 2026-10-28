package dev.java.curriVitae.business.mapper;

import dev.java.curriVitae.business.dto.PerfilDTO;
import dev.java.curriVitae.infrastructure.entity.PerfilEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PerfilConverter {

    PerfilEntity toEntity(PerfilDTO dto);

    PerfilDTO toDto(PerfilEntity entity);

    List<PerfilEntity> listaEntity(List<PerfilDTO> dtoList);

    List<PerfilDTO> listaDto(List<PerfilEntity> dtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityPerfil(PerfilDTO dto, @MappingTarget PerfilEntity perfilEntity);

}
