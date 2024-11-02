package com.joaosbarbosa.dev.casaLimpaPlus.web.mappers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.ServicoFormDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WebServicoMapper {

    public Servico convertDTOToModel(ServicoFormDTO dto){
        if (dto == null) throw new IllegalArgumentException("DTO não pode ser nulo");
        var model = new Servico();
        BeanUtils.copyProperties(dto, model);


        Optional.ofNullable(dto.getId()).ifPresent(model::setId);
        Optional.ofNullable(dto.getNome()).ifPresent(model::setNome);
        Optional.ofNullable(dto.getQtdHoras()).ifPresent(model::setQtdHoras);
        Optional.ofNullable(dto.getHorasQuarto()).ifPresent(model::setHorasQuarto);
        Optional.ofNullable(dto.getHorasSala()).ifPresent(model::setHorasSala);
        Optional.ofNullable(dto.getHorasCozinha()).ifPresent(model::setHorasCozinha);
        Optional.ofNullable(dto.getHorasBanheiro()).ifPresent(model::setHorasBanheiro);
        Optional.ofNullable(dto.getHorasQuintal()).ifPresent(model::setHorasQuintal);
        Optional.ofNullable(dto.getHorasOutros()).ifPresent(model::setHorasOutros);
        Optional.ofNullable(dto.getPosicao()).ifPresent(model::setPosicao);
        Optional.ofNullable(dto.getValorMinimo()).ifPresent(model::setValorMinimo);
        Optional.ofNullable(dto.getPorcentagemComissao()).ifPresent(model::setPorcentagemComissao);
        Optional.ofNullable(dto.getValorQuarto()).ifPresent(model::setValorQuarto);
        Optional.ofNullable(dto.getValorSala()).ifPresent(model::setValorSala);
        Optional.ofNullable(dto.getValorCozinha()).ifPresent(model::setValorCozinha);
        Optional.ofNullable(dto.getValorBanheiro()).ifPresent(model::setValorBanheiro);
        Optional.ofNullable(dto.getValorQuintal()).ifPresent(model::setValorQuintal);
        Optional.ofNullable(dto.getValorOutros()).ifPresent(model::setValorOutros);
        Optional.ofNullable(dto.getIcone()).ifPresent(model::setIcone);

        return model;
    }

    public ServicoFormDTO convertModelToDTO(Servico model) {
        if (model == null) throw new IllegalArgumentException("Model não pode ser nulo");

        var formDto = new ServicoFormDTO();
        BeanUtils.copyProperties(model, formDto);

        Optional.ofNullable(model.getId()).ifPresent(formDto::setId);
        Optional.ofNullable(model.getNome()).ifPresent(formDto::setNome);
        Optional.ofNullable(model.getQtdHoras()).ifPresent(formDto::setQtdHoras);
        Optional.ofNullable(model.getHorasQuarto()).ifPresent(formDto::setHorasQuarto);
        Optional.ofNullable(model.getHorasSala()).ifPresent(formDto::setHorasSala);
        Optional.ofNullable(model.getHorasCozinha()).ifPresent(formDto::setHorasCozinha);
        Optional.ofNullable(model.getHorasBanheiro()).ifPresent(formDto::setHorasBanheiro);
        Optional.ofNullable(model.getHorasQuintal()).ifPresent(formDto::setHorasQuintal);
        Optional.ofNullable(model.getHorasOutros()).ifPresent(formDto::setHorasOutros);
        Optional.ofNullable(model.getPosicao()).ifPresent(formDto::setPosicao);
        Optional.ofNullable(model.getValorMinimo()).ifPresent(formDto::setValorMinimo);
        Optional.ofNullable(model.getPorcentagemComissao()).ifPresent(formDto::setPorcentagemComissao);
        Optional.ofNullable(model.getValorQuarto()).ifPresent(formDto::setValorQuarto);
        Optional.ofNullable(model.getValorSala()).ifPresent(formDto::setValorSala);
        Optional.ofNullable(model.getValorCozinha()).ifPresent(formDto::setValorCozinha);
        Optional.ofNullable(model.getValorBanheiro()).ifPresent(formDto::setValorBanheiro);
        Optional.ofNullable(model.getValorQuintal()).ifPresent(formDto::setValorQuintal);
        Optional.ofNullable(model.getValorOutros()).ifPresent(formDto::setValorOutros);
        Optional.ofNullable(model.getIcone()).ifPresent(formDto::setIcone);

        return formDto;
    }

}
