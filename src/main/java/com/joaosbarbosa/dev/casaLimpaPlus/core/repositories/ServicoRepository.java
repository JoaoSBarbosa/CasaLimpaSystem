package com.joaosbarbosa.dev.casaLimpaPlus.core.repositories;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
