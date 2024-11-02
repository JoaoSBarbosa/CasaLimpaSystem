package com.joaosbarbosa.dev.casaLimpaPlus.web.mappers;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.ServicoFormDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WebServicoMapper {

//    public Servico convertDTOToModel(ServicoFormDTO dto){
//        if(dto == null) throw new IllegalArgumentException();
//        var model = new Servico();
//
//
//        if ( dto.getId() != null) model.setId(dto.getId());
//        if ( dto.getNome() != null) model.setNome(dto.getNome());
//        if ( dto.getQtdHoras() != null) model.setQtdHoras(dto.getQtdHoras());
//
//        if ( dto.getHorasQuarto() != null) model.setHorasQuarto(dto.getHorasQuarto());
//        if ( dto.getHorasSala() != null) model.setHorasSala(dto.getHorasSala());
//        if ( dto.getHorasCozinha() !=null) model.setHorasCozinha(dto.getHorasCozinha());
//        if ( dto.getHorasBanheiro() != null) model.setHorasBanheiro(dto.getHorasBanheiro());
//        if ( dto.getHorasQuintal() != null) model.setHorasQuintal(dto.getHorasQuintal());
//        if ( dto.getHorasOutros() != null) model.setHorasOutros(dto.getHorasOutros());
//
//        if ( dto.getPosicao() != null) model.setPosicao(dto.getPosicao());
//
//        if ( dto.getValorMinimo() != null) model.setValorMinimo(dto.getValorMinimo());
//        if ( dto.getPorcentagemComissao() != null) model.setPorcentagemComissao( dto.getPorcentagemComissao());
//        if ( dto.getValorQuarto() != null) model.setValorQuarto( dto.getValorQuarto());
//        if ( dto.getValorSala() != null) model.setValorSala( dto.getValorSala());
//        if ( dto.getValorCozinha() != null) model.setValorCozinha( dto.getValorCozinha());
//        if ( dto.getValorBanheiro() != null) model.setValorBanheiro( dto.getValorBanheiro());
//        if ( dto.getValorQuintal() != null) model.setValorQuintal( dto.getValorQuintal());
//        if ( dto.getValorOutros() != null) model.setValorOutros( dto.getValorOutros());
//        if ( dto.getIcone() != null) model.setIcone( dto.getIcone());
//
//        return model;
//    }

//    public ServicoFormDTO convertModelToDTO(Servico model){
//        if(model == null) throw new IllegalArgumentException();
//        var formDto = new ServicoFormDTO();
//
//        if ( model.getId() != null) formDto.setId(model.getId());
//        if ( model.getNome() != null) formDto.setNome(model.getNome());
//        if ( model.getQtdHoras() != null) formDto.setQtdHoras(model.getQtdHoras());
//
//        if ( model.getHorasQuarto() != null) formDto.setHorasQuarto(model.getHorasQuarto());
//        if ( model.getHorasSala() != null) formDto.setHorasSala(model.getHorasSala());
//        if ( model.getHorasCozinha() !=null) formDto.setHorasCozinha(model.getHorasCozinha());
//        if ( model.getHorasBanheiro() != null) formDto.setHorasBanheiro(model.getHorasBanheiro());
//        if ( model.getHorasQuintal() != null) formDto.setHorasQuintal(model.getHorasQuintal());
//        if ( model.getHorasOutros() != null) formDto.setHorasOutros(model.getHorasOutros());
//
//        if ( model.getPosicao() != null) formDto.setPosicao(model.getPosicao());
//
//        if ( model.getValorMinimo() != null) formDto.setValorMinimo(model.getValorMinimo());
//        if ( model.getPorcentagemComissao() != null) formDto.setPorcentagemComissao( model.getPorcentagemComissao());
//        if ( model.getValorQuarto() != null) formDto.setValorQuarto( model.getValorQuarto());
//        if ( model.getValorSala() != null) formDto.setValorSala( model.getValorSala());
//        if ( model.getValorCozinha() != null) formDto.setValorCozinha( model.getValorCozinha());
//        if ( model.getValorBanheiro() != null) formDto.setValorBanheiro( model.getValorBanheiro());
//        if ( model.getValorQuintal() != null) formDto.setValorQuintal( model.getValorQuintal());
//        if ( model.getValorOutros() != null) formDto.setValorOutros( model.getValorOutros());
//        if ( model.getIcone() != null) formDto.setIcone( model.getIcone());
//
//        return formDto;
//    }

    public Servico convertDTOToModel(ServicoFormDTO dto) {
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
