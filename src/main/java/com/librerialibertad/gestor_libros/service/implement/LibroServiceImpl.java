package com.librerialibertad.gestor_libros.service.implement;

import com.librerialibertad.gestor_libros.exception.LibroNotFoundException;
import com.librerialibertad.gestor_libros.model.Libro;
import com.librerialibertad.gestor_libros.reposity.LibroRepository;
import com.librerialibertad.gestor_libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    // ESTADO: ATRIBUTOS;
    private LibroRepository libroRepository;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    public LibroServiceImpl(@Autowired LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // findAll();
    @Override
    public List<Libro> findAllService() {
        return this.libroRepository.findAllRepository();
    }

    // save(Libro libro);
    @Override
    public Libro saveService(Libro libro) {

        // LIBRO;
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }

        if (libro.getIsbn() == null || libro.getIsbn().isBlank()) {
            throw new IllegalArgumentException("El isbn del libro no puede ser nulo");
        }

        if (libro.getTitulo() == null || libro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El titulo del libro no puede ser nulo");
        }

        if (libro.getGenero() == null || libro.getGenero().isBlank()) {
            throw new IllegalArgumentException("El genero del libro no puede ser nulo");
        }

        // AUTOR;
        if (libro.getAutor() == null) {
            throw new IllegalArgumentException("El autor del libro no puede nulo");
        }

        if (libro.getAutor().getNombre() == null || libro.getAutor().getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del autor no puede ser nulo");
        }

        if (libro.getAutor().getApellido() == null || libro.getAutor().getApellido().isBlank()) {
            throw new IllegalArgumentException("El apellido del autor no puede ser nulo");
        }

        if (libro.getAutor().getPais() == null || libro.getAutor().getPais().isBlank()) {
            throw new IllegalArgumentException("El pais del autor no puede ser nulo");
        }

        if (libro.getAutor().getFechaNacimiento() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento del autor no puede ser nula");
        }

        return this.libroRepository.saveRepository(libro);
    }

    // getBy(Long id);
    @Override
    public Libro getByService(Long id) throws LibroNotFoundException {

        // ID;
        if (id == null) {
            throw new IllegalArgumentException("El id del libro no puede ser nulo");
        }

        if (id <= 0L) {
            throw new IllegalArgumentException("El id del libro no puede ser 0 ni negativo");
        }

        Optional<Libro> libroOptional = this.libroRepository.getByRepository(id);

        if (libroOptional.isEmpty()) {
            throw new LibroNotFoundException("El libro con id " + id + " no encontrado");
        }

        return libroOptional.get();
    }

    // getBy(String titulo);
    @Override
    public Libro getByService(String titulo) throws LibroNotFoundException {

        // TITULO;
        if (titulo == null) {
            throw new IllegalArgumentException("El titulo del libro no puede ser nulo");
        }

        if (titulo.isBlank()) {
            throw new IllegalArgumentException("El titulo del libro no puede estar vacio");
        }

        String tituloSinEspacios = titulo.trim();

        Optional<Libro> optionalLibro = this.libroRepository.getByRepository(tituloSinEspacios);
        if (optionalLibro.isEmpty()) {
            throw new LibroNotFoundException("El titulo del libro: " + tituloSinEspacios + " no encontrado");
        }

        return optionalLibro.get();

    }

    // deleteBy(Long id);
    @Override
    public void deleteByService(Long id) throws LibroNotFoundException {

        // id;
        if (id == null) {
            throw new IllegalArgumentException("El id del libro no puede ser nulo");
        }

        Optional<Libro> optionalLibro = this.libroRepository.getByRepository(id);

        if (optionalLibro.isEmpty()) {
            throw new LibroNotFoundException("El libro con el id " + id + " no encontrado");
        }

        this.libroRepository.deleteByRepository(id);
    }

    // modifyBy(Long id);
    @Override
    public Libro modifyByService(Long id, Libro libro) throws LibroNotFoundException {

        // ID;
        if (id == null) {
            throw new IllegalArgumentException("El id del libro no puede ser nulo");
        }

        // LIBRO;
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }

        // AUTOR;
        if (libro.getAutor() == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }

        Optional<Libro> optionalLibro = this.libroRepository.modifyByRepository(id, libro);

        if (optionalLibro.isEmpty()) {
            throw new LibroNotFoundException("El libro con id " + id + " no encontrado");
        }

        return optionalLibro.get();
    }

}
