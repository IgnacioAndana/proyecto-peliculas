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

    // Método que se ejecuta antes de cada prueba para inicializar objetos comunes (pelicula 1 y 2)
    @BeforeEach
    void setUp() {
        pelicula1 = new Pelicula(1, "Inception", "Christopher Nolan", 0, "Ciencia Ficción", null, 2010, null, null, 0, null, 0);
        pelicula2 = new Pelicula(2, "The Matrix", "Wachowski", 0, "Acción", null, 1999, null, null, 0, null, 0);
    }

    // Test para validar que el endpoint GET /peliculas devuelve todas las películas
    @Test
    void testGetAllPeliculas() throws Exception {
        // Simulamos el comportamiento del servicio para que retorne una lista con las dos películas creadas
        List<Pelicula> mockPeliculas = Arrays.asList(pelicula1, pelicula2);

        when(peliculaService.getPeliculas()).thenReturn(mockPeliculas);

        // Realizamos una petición GET al endpoint /peliculas
        mockMvc.perform(get("/peliculas")
                .contentType(MediaType.APPLICATION_JSON))

                // Verificamos que la respuesta sea HTTP 200 OK
                .andExpect(status().isOk())

                // Verificamos que el primer elemento de la respuesta tenga el título "Inception"
                .andExpect(jsonPath("$[0].titulo").value("Inception"))

                // Verificamos que el segundo elemento tenga el título "The Matrix"
                .andExpect(jsonPath("$[1].titulo").value("The Matrix"));

        // Confirmamos que el método getPeliculas() del servicio fue llamado exactamente una vez
        verify(peliculaService, times(1)).getPeliculas();
    }

    // Test para validar que el endpoint GET /peliculas/{id} devuelve la película correcta según el ID
    @Test
    void testGetPeliculaById() throws Exception {
        // Simulamos el comportamiento del servicio para que retorne pelicula1 al buscar por ID 1
        when(peliculaService.getPeliculaById(1)).thenReturn(pelicula1);

        // Realizamos una petición GET al endpoint /peliculas/1
        mockMvc.perform(get("/peliculas/1")
                .contentType(MediaType.APPLICATION_JSON))

                // Verificamos que la respuesta sea HTTP 200 OK
                .andExpect(status().isOk())

                // Verificamos que el título en la respuesta sea "Inception"
                .andExpect(jsonPath("$.titulo").value("Inception"))

                // Verificamos que el director sea "Christopher Nolan"
                .andExpect(jsonPath("$.director").value("Christopher Nolan"));

        // Confirmamos que el método getPeliculaById(1) del servicio fue llamado exactamente una vez
        verify(peliculaService, times(1)).getPeliculaById(1);
    }
}