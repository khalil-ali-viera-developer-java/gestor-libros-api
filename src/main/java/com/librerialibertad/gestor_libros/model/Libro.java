package com.librerialibertad.gestor_libros.model;

public class Libro {

    // ESTADO: ATRIBUTOS;
    private Long id;
    private String isbn;
    private String titulo;
    private String genero;
    private Autor autor;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public Libro() {
    }

    // CONSTRUCTOR PARAMETRIZADO;
    public Libro(String isbn, String titulo, String genero, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

    // GETTERS Y SETTERS;
    // ID;
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ISBN;
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // TITULO;
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // GENERO;
    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // AUTOR;
    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
