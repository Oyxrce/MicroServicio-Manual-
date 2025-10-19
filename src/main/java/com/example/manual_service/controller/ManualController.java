package com.example.manual_service.controller;

import com.example.manual_service.model.Manual;
import com.example.manual_service.service.ManualService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/manuales")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ManualController {
    
    private final ManualService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manual crear(@Valid @RequestBody Manual manual) {
        return service.crear(manual);
    }
    
    @GetMapping
    public List<Manual> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public Manual obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    
    @GetMapping("/fabricante/{fabricanteId}")
    public List<Manual> obtenerPorFabricante(@PathVariable Long fabricanteId) {
        return service.obtenerPorFabricante(fabricanteId);
    }
    
    @GetMapping("/categoria/{categoriaId}")
    public List<Manual> obtenerPorCategoria(@PathVariable Long categoriaId) {
        return service.obtenerPorCategoria(categoriaId);
    }
    
    @GetMapping("/basicos")
    public List<Manual> obtenerBasicos() {
        return service.obtenerTodos();
    }
    
    @PutMapping("/{id}")
    public Manual actualizar(@PathVariable Long id, @Valid @RequestBody Manual manual) {
        return service.actualizar(id, manual);
    }
    
    @PatchMapping("/{id}")
    public Manual actualizarParcial(@PathVariable Long id, @RequestBody Manual manual) {
        return service.actualizar(id, manual);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}