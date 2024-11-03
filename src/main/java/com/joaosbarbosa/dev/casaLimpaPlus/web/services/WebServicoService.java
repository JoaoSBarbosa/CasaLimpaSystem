package com.joaosbarbosa.dev.casaLimpaPlus.web.services;

import com.joaosbarbosa.dev.casaLimpaPlus.core.exceptions.EntityNotFoundExceptionCustomer;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.ServicoRepository;
import com.joaosbarbosa.dev.casaLimpaPlus.web.dto.ServicoFormDTO;
import com.joaosbarbosa.dev.casaLimpaPlus.web.mappers.WebServicoMapper;
import com.joaosbarbosa.dev.casaLimpaPlus.web.mappers.WebServicoMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WebServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    private WebServicoMapper webServicoMapper;
    @Autowired private WebServicoMapperImpl mapper;

    @Transactional(readOnly = true)
    public ServicoFormDTO buscarServicoPorId(Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        if( servico.isPresent() ){
            return new ServicoFormDTO(servico.get());
        }
        var exceptionMessage = String.format("Registro de serviço com ID '%d' não foi encontrado", id);
        throw new EntityNotFoundExceptionCustomer(exceptionMessage);
    }

    @Transactional( readOnly = true)
    public List<ServicoFormDTO> listarServicos() {
        List<Servico> servicos = servicoRepository.findAll();
        return servicos.stream().map(ServicoFormDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void cadastrarServico(ServicoFormDTO formDTO) {
        var modelServico = mapper.toModel(formDTO);
        servicoRepository.save(modelServico);
    }

    @Transactional
    public void editarServico(ServicoFormDTO formDTO, Long id) {

        var servicoAtual = buscarServicoPorId(id);
        var modelServico = mapper.toModel(formDTO);
        modelServico.setId(servicoAtual.getId());

        servicoRepository.save(modelServico);

    }

    @Transactional
    public void excluirPorId(Long id) {
        var servicoAtual = buscarServicoPorId(id);
        var modelServico = mapper.toModel(servicoAtual);
        servicoRepository.delete(modelServico);
    }

}
