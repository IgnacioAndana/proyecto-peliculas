package com.example.proyecto_peliculas.controller;

import com.example.proyecto_peliculas.Controller.PeliculaController;
import com.example.proyecto_peliculas.Model.Pelicula;
import com.example.proyecto_peliculas.Service.PeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaService;

    private Pelicula pelicula1;
    private Pelicula pelicula2;

    @BeforeEach
    void setUp() {
        pelicula1 = new Pelicula(1, "Inception", "Christopher Nolan", 0, "Ciencia Ficción", null, 2010, null, null, 0, null, 0);
        pelicula2 = new Pelicula(2, "The Matrix", "Wachowski", 0, "Acción", null, 1999, null, null, 0, null, 0);
    }

    @Test
    void testGetAllPeliculas() throws Exception {
        List<Pelicula> mockPeliculas = Arrays.asList(pelicula1, pelicula2);

        when(peliculaService.getPeliculas()).thenReturn(mockPeliculas);

        mockMvc.perform(get("/peliculas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Inception"))
                .andExpect(jsonPath("$[1].titulo").value("The Matrix"));

        verify(peliculaService, times(1)).getPeliculas();
    }

    @Test
    void testGetPeliculaById() throws Exception {
        when(peliculaService.getPeliculaById(1)).thenReturn(pelicula1);

        mockMvc.perform(get("/peliculas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Inception"))
                .andExpect(jsonPath("$.director").value("Christopher Nolan"));

        verify(peliculaService, times(1)).getPeliculaById(1);
    }
}