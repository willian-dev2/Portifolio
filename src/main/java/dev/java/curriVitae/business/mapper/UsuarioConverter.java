package dev.java.curriVitae.business.mapper;

import dev.java.curriVitae.business.dto.RegistroRequest;
import dev.java.curriVitae.infrastructure.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioConverter {

    UsuarioEntity paraUsuarioEntity(RegistroRequest registroRequest);


    RegistroRequest paraRegistroRequest(UsuarioEntity usuarioEntity);

}
