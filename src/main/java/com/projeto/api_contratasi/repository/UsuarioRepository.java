package com.projeto.api_contratasi.repository;

import com.projeto.api_contratasi.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByLogin(String login);
}
