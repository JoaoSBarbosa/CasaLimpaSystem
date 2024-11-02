package com.joaosbarbosa.dev.casaLimpaPlus.core.repository;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
