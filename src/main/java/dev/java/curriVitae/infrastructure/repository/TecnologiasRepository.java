package dev.java.curriVitae.infrastructure.repository;

import dev.java.curriVitae.infrastructure.entity.ExperienciaEntity;
import dev.java.curriVitae.infrastructure.entity.TecnologiasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TecnologiasRepository extends JpaRepository<TecnologiasEntity, Long> {

}
