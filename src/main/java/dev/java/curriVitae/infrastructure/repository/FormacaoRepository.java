package dev.java.curriVitae.infrastructure.repository;

import dev.java.curriVitae.infrastructure.entity.ExperienciaEntity;
import dev.java.curriVitae.infrastructure.entity.FormacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FormacaoRepository extends JpaRepository<FormacaoEntity, Long> {

    List<FormacaoEntity> findAll();

    Optional<FormacaoEntity> findAllby();

    Optional<FormacaoEntity> findById(Long id);

}
