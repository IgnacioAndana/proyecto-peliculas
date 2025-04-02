package com.example.proyecto_peliculas.Service;

import com.example.proyecto_peliculas.Model.Pelicula;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> getPeliculas();
    Optional <Pelicula> getPeliculaById(int id);
    // Pelicula addPelicula(Pelicula pelicula);
    // Pelicula updatePelicula(int id, Pelicula pelicula);
    // void deletePelicula(int id);
}
