package com.example.proyecto_peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyecto_peliculas.Model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    // JpaRepository ya incluye métodos como findAll(), findById(), save(), delete(), etc.
}
