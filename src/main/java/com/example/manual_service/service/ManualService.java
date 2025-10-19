package com.example.manual_service.service;

import com.example.manual_service.model.Manual;
import java.util.List;

public interface ManualService {
    Manual crear(Manual manual);
    List<Manual> obtenerTodos();
    Manual obtenerPorId(Long id);
    Manual actualizar(Long id, Manual manual);
    void eliminar(Long id);
    List<Manual> obtenerPorFabricante(Long fabricanteId);
    List<Manual> obtenerPorCategoria(Long categoriaId);
    List<Manual> obtenerBasicos();
}
