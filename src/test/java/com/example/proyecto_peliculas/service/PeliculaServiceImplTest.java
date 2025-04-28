package com.example.proyecto_peliculas.service;

import com.example.proyecto_peliculas.Exception.PeliculaNotFoundException;
import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.Service.PeliculaServiceImpl;
import com.example.proyecto_peliculas.repository.PeliculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PeliculaServiceImplTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    private Pelicula pelicula1;
    private Pelicula pelicula2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pelicula1 = new Pelicula(1, "Inception", "Christopher Nolan", 0, "Ciencia Ficción", null, 2010, null, null, 0, null, 0);
        pelicula2 = new Pelicula(2, "The Matrix", "Wachowski", 0, "Acción", null, 1999, null, null, 0, null, 0);
    }

    @Test
    void testGetPeliculas() {
        List<Pelicula> mockPeliculas = Arrays.asList(pelicula1, pelicula2);

        when(peliculaRepository.findAll()).thenReturn(mockPeliculas);

        List<Pelicula> result = peliculaService.getPeliculas();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Inception", result.get(0).getTitulo());
        verify(peliculaRepository, times(1)).findAll();
    }

    @Test
    void testGetPeliculaById() {
        when(peliculaRepository.findById(1)).thenReturn(Optional.of(pelicula1));

        Pelicula result = peliculaService.getPeliculaById(1);

        assertNotNull(result);
        assertEquals("Inception", result.getTitulo());
        verify(peliculaRepository, times(1)).findById(1);
    }

    @Test
    void testGetPeliculaByIdNotFound() {
        when(peliculaRepository.findById(99)).thenReturn(Optional.empty());

        PeliculaNotFoundException exception = assertThrows(PeliculaNotFoundException.class, () -> {
            peliculaService.getPeliculaById(99);
        });

        assertEquals("Pelicula no encontrada con el id: 99", exception.getMessage());
        verify(peliculaRepository, times(1)).findById(99);
    }

    @Test
    void testAddPelicula() {
        Pelicula nuevaPelicula = new Pelicula(3, "Interstellar", "Christopher Nolan", 0, "Ciencia Ficción", null, 2014, null, null, 0, null, 0);

        when(peliculaRepository.save(nuevaPelicula)).thenReturn(nuevaPelicula);

        Pelicula result = peliculaService.addPelicula(nuevaPelicula);

        assertNotNull(result);
        assertEquals("Interstellar", result.getTitulo());
        verify(peliculaRepository, times(1)).save(nuevaPelicula);
    }

    @Test
    void testUpdatePelicula() {
        Pelicula peliculaExistente = new Pelicula(1, "Inception", "Christopher Nolan", 0, "Ciencia Ficción", null, 2010, null, null, 0, null, 0);
        Pelicula peliculaActualizada = new Pelicula(1, "Inception Updated", "Christopher Nolan", 0, "Ciencia Ficción", null, 2010, null, null, 0, null, 0);

        when(peliculaRepository.findById(1)).thenReturn(Optional.of(peliculaExistente));
        when(peliculaRepository.save(any(Pelicula.class))).thenReturn(peliculaActualizada);

        Pelicula result = peliculaService.updatePelicula(1, peliculaActualizada);

        assertNotNull(result);
        assertEquals("Inception Updated", result.getTitulo());
        verify(peliculaRepository, times(1)).findById(1);
        verify(peliculaRepository, times(1)).save(any(Pelicula.class));
    }

    @Test
    void testDeletePelicula() {
        when(peliculaRepository.existsById(1)).thenReturn(true);

        peliculaService.deletePelicula(1);

        verify(peliculaRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeletePeliculaNotFound() {
        when(peliculaRepository.existsById(99)).thenReturn(false);

        boolean resultado = peliculaService.deletePelicula(99);

        assertFalse(resultado);

        verify(peliculaRepository, never()).deleteById(99);
    }
}
