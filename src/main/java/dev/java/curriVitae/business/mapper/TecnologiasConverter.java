package dev.java.curriVitae.business.mapper;

import dev.java.curriVitae.business.dto.TecnologiasDTO;
import dev.java.curriVitae.infrastructure.entity.TecnologiasEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TecnologiasConverter {

    TecnologiasEntity toEntity(TecnologiasDTO tecnologiasDTO);

    TecnologiasDTO toDto(TecnologiasEntity tecnologiasEntity);

    List<TecnologiasEntity> listaEntity(List<TecnologiasDTO> tecnologiasDTOList);

    List<TecnologiasDTO> listaDto(List<TecnologiasEntity> tecnologiasEntityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityTecnologias(TecnologiasDTO dto, @MappingTarget TecnologiasEntity tecnologiasEntity);

}
