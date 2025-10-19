package com.example.manual_service.service;

import com.example.manual_service.model.Manual;
import com.example.manual_service.repository.ManualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManualServiceImpl implements ManualService {
    
    private final ManualRepository repository;
    
    @Override
    @Transactional
    public Manual crear(Manual manual) {
        return repository.save(manual);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Manual> obtenerTodos() {
        return repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Manual obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Manual no encontrado: " + id));
    }
    
    @Override
    @Transactional
    public Manual actualizar(Long id, Manual manual) {
        Manual existe = obtenerPorId(id);
        existe.setTitulo(manual.getTitulo());
        existe.setDescripcion(manual.getDescripcion());
        existe.setUrlPdf(manual.getUrlPdf());
        existe.setEsBasico(manual.getEsBasico());
        existe.setFechaPublicacion(manual.getFechaPublicacion());
        existe.setFabricanteId(manual.getFabricanteId());
        existe.setCategoriaId(manual.getCategoriaId());
        return repository.save(existe);
    }
    
    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Manual no encontrado: " + id);
        }
        repository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Manual> obtenerPorFabricante(Long fabricanteId) {
        return repository.findByFabricanteId(fabricanteId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Manual> obtenerPorCategoria(Long categoriaId) {
        return repository.findByCategoriaId(categoriaId);
    }
    
    @Transactional(readOnly = true)
    public List<Manual> obtenerBasicos() {
        return repository.findByEsBasico(true);
    }
}