package com.joaosbarbosa.dev.casaLimpaPlus.core.repository;
import com.joaosbarbosa.dev.casaLimpaPlus.core.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findByEmail(String email);

//    @Query("SELECT COUNT(*) > 0 FROM Usuario u WHERE u.email = :email AND :id (is null or u.id != :id)")
//    Boolean existsByEmailAndId2(@Param("email") String email, @Param("id") Long id);

    @Query("SELECT COUNT(*) > 0 FROM Usuario u WHERE u.email = :email AND (:id IS NULL OR u.id != :id)")
    Boolean existsByEmailAndId(@Param("email") String email, @Param("id") Long id);

}
