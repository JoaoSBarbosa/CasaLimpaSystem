package com.joaosbarbosa.dev.casaLimpaPlus.core.repository;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
