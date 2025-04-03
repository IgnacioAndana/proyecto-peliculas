package com.example.proyecto_peliculas.Service;

import com.example.proyecto_peliculas.Model.Pelicula;
import java.util.List;

public interface PeliculaService {
    List<Pelicula> getPeliculas();
    Pelicula getPeliculaById(int id); // Tipo de retorno debe ser Pelicula
    Pelicula addPelicula(Pelicula pelicula);
    Pelicula updatePelicula(int id, Pelicula pelicula);
    void deletePelicula(int id);
}
