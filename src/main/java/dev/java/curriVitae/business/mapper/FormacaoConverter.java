package dev.java.curriVitae.business.mapper;

import dev.java.curriVitae.business.dto.FormacaoDTO;
import dev.java.curriVitae.infrastructure.entity.FormacaoEntity;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FormacaoConverter {

    FormacaoEntity toEntity(FormacaoDTO formacaoDTO);

    FormacaoDTO toDto(FormacaoEntity formacaoEntity);

    List<FormacaoDTO> listaDto(List<FormacaoEntity> formacaoEntityList);

    List<FormacaoEntity> listaEntity(List<FormacaoDTO> formacaoDTOList);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFormacao(FormacaoDTO formacaoDTO, @MappingTarget FormacaoEntity formacaoEntity);

}
