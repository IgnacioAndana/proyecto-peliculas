package com.example.proyecto_peliculas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class PeliculaController {

    private List<Pelicula> peliculaList = new ArrayList<>();

    public PeliculaController() {
        peliculaList.add(new Pelicula(1, "Interstellar", "Christopher Nolan", 2014, "Sci-Fi", "Un grupo de astronautas viaja por un agujero negro en busca de un nuevo hogar", 169, "PG-13", "2014-11-07", 8.6, "USA", 677471339));
        peliculaList.add(new Pelicula(2, "The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, "Sci-Fi", "Un hombre descubre que la realidad es una ilusión creada por máquinas", 136, "R", "1999-03-31", 8.7, "USA", 463517383));
        peliculaList.add(new Pelicula(3, "The Godfather", "Francis Ford Coppola", 1972, "Crime", "La historia de una familia mafiosa que lucha por mantener su poder", 175, "R", "1972-03-24", 9.2, "USA", 246120974));
        peliculaList.add(new Pelicula(4, "Pulp Fiction", "Quentin Tarantino", 1994, "Crime", "Una serie de historias entrelazadas en Los Ángeles de los años 90", 154, "R", "1994-10-14", 8.9, "USA", 214179088));
        peliculaList.add(new Pelicula(5, "Fight Club", "David Fincher", 1999, "Drama", "Un hombre frustrado comienza un club secreto de lucha como terapia", 139, "R", "1999-10-15", 8.8, "USA", 100853753));
        peliculaList.add(new Pelicula(6, "The Lion King", "Roger Allers, Rob Minkoff", 1994, "Animation", "Un joven león debe reclamar su trono en la sabana africana", 88, "G", "1994-06-24", 8.5, "USA", 968483777));

    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaList; 
    }

    @GetMapping("/peliculas/{id}")
    public ResponseEntity<Object> getId(@PathVariable int id) {
        return peliculaList.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .<ResponseEntity<Object>>map(ResponseEntity::ok)
            .orElseGet(() -> {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("status", HttpStatus.NOT_FOUND.value());
                errorResponse.put("error", "Not Found");
                errorResponse.put("message", "Película no encontrada");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            });
    }   

}
