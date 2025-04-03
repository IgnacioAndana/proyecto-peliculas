package com.example.proyecto_peliculas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.Service.PeliculaService;

import java.util.List;


@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getPeliculas() {
        List<Pelicula> peliculas = peliculaService.getPeliculas();
        if (peliculas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay datos
        }
        return ResponseEntity.ok(peliculas); // Devuelve 200 con la lista de películas
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable int id) {
        Pelicula pelicula = peliculaService.getPeliculaById(id);
        return ResponseEntity.ok(pelicula);
    }

}
