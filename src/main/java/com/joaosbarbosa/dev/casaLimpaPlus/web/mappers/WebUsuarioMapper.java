package com.joaosbarbosa.dev.casaLimpaPlus.web.mappers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioCadastroDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.UsuarioEdicaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {

    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    Usuario toModel(UsuarioCadastroDTO form);
    UsuarioCadastroDTO toDTO(Usuario usuario);


    Usuario toModelForEdit(UsuarioEdicaoDTO form);
    UsuarioEdicaoDTO toDTOForEdit(Usuario usuario);
}
