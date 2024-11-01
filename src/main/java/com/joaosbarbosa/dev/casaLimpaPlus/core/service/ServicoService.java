package com.joaosbarbosa.dev.casaLimpaPlus.core.service;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import com.joaosbarbosa.dev.casaLimpaPlus.core.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired private ServicoRepository servicoRepository;


    public void cadastrarServico(Servico servico) {
        servicoRepository.save(servico);
    }

}
