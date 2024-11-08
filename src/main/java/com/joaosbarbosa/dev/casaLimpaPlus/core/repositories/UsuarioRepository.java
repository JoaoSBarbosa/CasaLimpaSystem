package com.joaosbarbosa.dev.casaLimpaPlus.core.repositories;

import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT count(*) > 0 FROM Usuario u WHERE u.email = :email and (:id is null or u.id != :id)")
    Boolean isEmailJaCadastrado(String email, Long id);
    
}
