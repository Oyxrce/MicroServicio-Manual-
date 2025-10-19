package com.example.manual_service.repository;

import com.example.manual_service.model.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {
    List<Manual> findByFabricanteId(Long fabricanteId);
    List<Manual> findByCategoriaId(Long categoriaId);
    List<Manual> findByEsBasico(Boolean esBasico);
    List<Manual> findByTituloContainingIgnoreCase(String titulo);
}

