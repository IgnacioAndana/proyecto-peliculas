package com.example.proyecto_peliculas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.Service.PeliculaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @PostMapping
    public ResponseEntity<Pelicula> addPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.addPelicula(pelicula);
        return ResponseEntity.status(201).body(nuevaPelicula); // Devuelve 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable int id, @RequestBody Pelicula pelicula) {
        Pelicula peliculaActualizada = peliculaService.updatePelicula(id, pelicula);
        return ResponseEntity.ok(peliculaActualizada); // Devuelve 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePelicula(@PathVariable int id) {
        peliculaService.deletePelicula(id); // Llama al servicio para eliminar la película
    
        // Construye la respuesta JSON
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Registro con id " + id + " eliminado exitosamente.");
    
        return ResponseEntity.ok(response); // Devuelve 200 OK con el JSON
    }

}
