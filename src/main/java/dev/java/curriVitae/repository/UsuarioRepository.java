package dev.java.curriVitae.repository;

import dev.java.curriVitae.domain.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
