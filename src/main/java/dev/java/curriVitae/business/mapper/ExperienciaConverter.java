package dev.java.curriVitae.business.mapper;

import dev.java.curriVitae.business.dto.ExperienciaDTO;
import dev.java.curriVitae.infrastructure.entity.ExperienciaEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienciaConverter {

    ExperienciaEntity toEntity(ExperienciaDTO experienciaDTO);

    ExperienciaDTO toDto(ExperienciaEntity experienciaEntity);

    List<ExperienciaEntity> listaEntity(List<ExperienciaDTO> experienciasDTOList);

    List<ExperienciaDTO> listaDto(List<ExperienciaEntity> experienciasEntityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityExperiencia(ExperienciaDTO dto, @MappingTarget ExperienciaEntity experienciaEntity);

}
