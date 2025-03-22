package com.example.proyecto_peliculas;

public class Pelicula {

    private int id;
    private String titulo;
    private String director;
    private int anio;
    private String genero;
    private String sinopsis;
    private int duracion;
    private String clasificacion;
    private String fechaEstreno;
    private double calificacion;
    private String paisOrigen;
    private int recaudacion;

    public Pelicula() {}

    public Pelicula(int id, String titulo, String director, int anio, String genero, String sinopsis, int duracion,
                    String clasificacion, String fechaEstreno, double calificacion, String paisOrigen, int recaudacion) {
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

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
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

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
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
