package dev.java.curriVitae.infrastructure.repository;

import dev.java.curriVitae.infrastructure.entity.ExperienciaEntity;
import dev.java.curriVitae.infrastructure.entity.ProjetosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjetosRepository extends JpaRepository<ProjetosEntity, Long> {

    List<ProjetosEntity> findAll();

    Optional<ProjetosEntity> findAllby();

    Optional<ProjetosEntity> findById(Long id);

}
