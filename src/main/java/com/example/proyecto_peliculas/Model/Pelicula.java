package com.example.proyecto_peliculas.Model;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "PELICULA")
public class Pelicula extends RepresentationModel<Pelicula> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "DIRECTOR", nullable = false, length = 100)
    private String director;

    @Column(name = "ANIO", nullable = false)
    private int anio;

    @Column(name = "GENERO", nullable = false, length = 50)
    private String genero;

    @Lob
    @Column(name = "SINOPSIS", nullable = false)
    private String sinopsis;

    @Column(name = "DURACION", nullable = false, precision = 4)
    private int duracion;

    @Column(name = "CLASIFICACION", nullable = false, length = 20)
    private String clasificacion;

    @Column(name = "FECHA_ESTRENO", nullable = false)
    private LocalDate fechaEstreno;

    @Column(name = "CALIFICACION", nullable = false)
    private double calificacion;

    @Column(name = "PAIS_ORIGEN", nullable = false, length = 50)
    private String paisOrigen;

    @Column(name = "RECAUDACION", nullable = false)
    private long recaudacion;

    public Pelicula() {}

    public Pelicula(int id, String titulo, String director, int anio, String genero, String sinopsis, int duracion,
                    String clasificacion, LocalDate fechaEstreno, double calificacion, String paisOrigen, long recaudacion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.fechaEstreno = fechaEstreno;
        this.calificacion = calificacion;
        this.paisOrigen = paisOrigen;
        this.recaudacion = recaudacion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public long getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(long recaudacion) {
        this.recaudacion = recaudacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", fechaEstreno='" + fechaEstreno + '\'' +
                ", calificacion=" + calificacion +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", recaudacion=" + recaudacion +
                '}';
    }
}
