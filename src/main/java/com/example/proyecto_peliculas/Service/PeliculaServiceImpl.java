package com.example.proyecto_peliculas.Service;

import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.exception.PeliculaNotFoundException;
import com.example.proyecto_peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service // Anotación para registrar esta clase como un bean de servicio
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getPeliculas() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        System.out.println("Peliculas encontradas: " + peliculas.size());
        return peliculas;
    }

    @Override
    public Pelicula getPeliculaById(int id) {
        return peliculaRepository.findById(id)
            .orElseThrow(() -> new PeliculaNotFoundException("Pelicula no encontrada con el id: " + id));
    }

    @Override
    public Pelicula addPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(int id, Pelicula pelicula) {
        Pelicula peliculaToUpdate = getPeliculaById(id);
        peliculaToUpdate.setTitulo(pelicula.getTitulo());
        peliculaToUpdate.setDirector(pelicula.getDirector());
        peliculaToUpdate.setGenero(pelicula.getGenero());
        peliculaToUpdate.setAnio(pelicula.getAnio());
        return peliculaRepository.save(peliculaToUpdate);
    }

    @Override
    public Pelicula deletePelicula(int id) {
        Pelicula pelicula = peliculaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id: " + id));
        peliculaRepository.deleteById(id);
        return pelicula;
    }

}
