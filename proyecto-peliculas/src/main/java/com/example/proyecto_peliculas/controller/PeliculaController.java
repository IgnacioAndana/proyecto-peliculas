package com.example.proyecto_peliculas.controller;

import com.example.proyecto_peliculas.model.Pelicula;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
public class PeliculaController {

    private List<Pelicula> peliculaList = new ArrayList<>(); // Lista de películas predefinidas

    public PeliculaController() {
        peliculaList.add(new Pelicula(1, "Interstellar", "Christopher Nolan", 2014, "Sci-Fi", "Un grupo de astronautas viaja por un agujero negro en busca de un nuevo hogar", 169, "PG-13", "2014-11-07", 8.6, "USA", 677471339));
        peliculaList.add(new Pelicula(2, "The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, "Sci-Fi", "Un hombre descubre que la realidad es una ilusión creada por máquinas", 136, "R", "1999-03-31", 8.7, "USA", 463517383));
        peliculaList.add(new Pelicula(3, "The Godfather", "Francis Ford Coppola", 1972, "Crime", "La historia de una familia mafiosa que lucha por mantener su poder", 175, "R", "1972-03-24", 9.2, "USA", 246120974));
        peliculaList.add(new Pelicula(4, "Pulp Fiction", "Quentin Tarantino", 1994, "Crime", "Una serie de historias entrelazadas en Los Ángeles de los años 90", 154, "R", "1994-10-14", 8.9, "USA", 214179088));
        peliculaList.add(new Pelicula(5, "Fight Club", "David Fincher", 1999, "Drama", "Un hombre frustrado comienza un club secreto de lucha como terapia", 139, "R", "1999-10-15", 8.8, "USA", 100853753));
        peliculaList.add(new Pelicula(6, "The Lion King", "Roger Allers, Rob Minkoff", 1994, "Animation", "Un joven león debe reclamar su trono en la sabana africana", 88, "G", "1994-06-24", 8.5, "USA", 968483777));

    }

    // Método para obtener todas las películas
    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaList; // Retorna todas las películas
    }

    // Método para obtener una película por su ID
    @GetMapping("/peliculas/{id}")
    public Pelicula getPelicula(@PathVariable Long id) {
        return pelicula.stream()
                         .filter(pelicula -> pelicula.getId() == id)
                         .findFirst()
                         .orElse(null); // Retorna la película por ID, o null si no se encuentra
    }

}
