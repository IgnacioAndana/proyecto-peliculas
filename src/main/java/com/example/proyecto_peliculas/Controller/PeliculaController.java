package com.example.proyecto_peliculas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyecto_peliculas.Exception.PeliculaNotFoundException;
import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.Service.PeliculaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<EntityModel<Pelicula>>> getPeliculas() {
        List<Pelicula> peliculas = peliculaService.getPeliculas();
        if (peliculas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay datos
        }

        // Encapsula cada película en EntityModel y agrega links
        List<EntityModel<Pelicula>> entityModels = peliculas.stream()
                .map(pelicula -> {
                    EntityModel<Pelicula> model = EntityModel.of(pelicula);
                    Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(PeliculaController.class).getPeliculaById(pelicula.getId())).withSelfRel();
                    model.add(selfLink);
                    return model;
                })
                .toList();

        return ResponseEntity.ok(entityModels); // Devuelve 200 con la lista de películas
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Pelicula>> getPeliculaById(@PathVariable int id) {
        Pelicula pelicula = peliculaService.getPeliculaById(id);
    
        if (pelicula == null) {
            throw new PeliculaNotFoundException("Pelicula con ID " + id + " no encontrada");
        }
    
        // Encapsula la película en EntityModel y agrega links
        EntityModel<Pelicula> model = EntityModel.of(pelicula);
        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(PeliculaController.class).getPeliculaById(id)).withSelfRel();
        Link allPeliculasLink = WebMvcLinkBuilder.linkTo(methodOn(PeliculaController.class).getPeliculas()).withRel("peliculas");
        model.add(selfLink, allPeliculasLink);
    
        return ResponseEntity.ok(model); // Devuelve 200 con la película
    }

    @PostMapping
    public ResponseEntity<EntityModel<Pelicula>> addPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.addPelicula(pelicula);
    
        // Encapsula la película en EntityModel y agrega link
        EntityModel<Pelicula> model = EntityModel.of(nuevaPelicula);
        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(PeliculaController.class).getPeliculaById(nuevaPelicula.getId())).withSelfRel();
        model.add(selfLink);
    
        return ResponseEntity.created(selfLink.toUri()).body(model); // Devuelve 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Pelicula>> updatePelicula(@PathVariable int id, @RequestBody Pelicula pelicula) {
        Pelicula peliculaActualizada = peliculaService.updatePelicula(id, pelicula);
    
        if (peliculaActualizada == null) {
            throw new PeliculaNotFoundException("Pelicula con ID " + id + " no encontrada");
        }
    
        // Encapsula la película en EntityModel y agrega links
        EntityModel<Pelicula> model = EntityModel.of(peliculaActualizada);
        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(PeliculaController.class).getPeliculaById(id)).withSelfRel();
        model.add(selfLink);
    
        return ResponseEntity.ok(model); // Devuelve 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePelicula(@PathVariable int id) {
        boolean deleted = peliculaService.deletePelicula(id); // Suponiendo que el servicio devuelve true si se eliminó correctamente

        if (!deleted) {
            throw new PeliculaNotFoundException("Pelicula con ID " + id + " no encontrada");
        }

        // Construye la respuesta JSON
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Registro con id " + id + " eliminado exitosamente.");
    
        return ResponseEntity.ok(response); // Devuelve 200 OK con el JSON
    }

}
