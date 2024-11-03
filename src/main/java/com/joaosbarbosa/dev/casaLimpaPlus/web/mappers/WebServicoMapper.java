package com.joaosbarbosa.dev.casaLimpaPlus.web.mappers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.ServicoFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface WebServicoMapper {

    WebServicoMapper INSTANCE = Mappers.getMapper(WebServicoMapper.class);

    Servico toModel(ServicoFormDTO dto);
    ServicoFormDTO toForm(Servico model);


}
