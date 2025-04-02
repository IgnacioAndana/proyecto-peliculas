package com.example.proyecto_peliculas.Service;

import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.proyecto_peliculas.Model.Pelicula;
// import com.example.proyecto_peliculas.repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;

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
    public Optional<Pelicula> getPeliculaById(int id) {
        return peliculaRepository.findById(id);
    }

    // Implementar otros métodos según sea necesario

}
