package com.example.manual_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "manual")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(nullable = false)
    private String titulo;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "url_pdf")
    private String urlPdf;
    
    @Column(name = "es_basico")
    private Boolean esBasico;
    
    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
    
    @Column(name = "fabricante_id")
    private Long fabricanteId;
    
    @Column(name = "categoria_id")
    private Long categoriaId;
    
    @PrePersist
    protected void onCreate() {
        if (fechaPublicacion == null) fechaPublicacion = LocalDate.now();
        if (esBasico == null) esBasico = false;
    }
}