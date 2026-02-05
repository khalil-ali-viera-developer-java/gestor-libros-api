package com.librerialibertad.gestor_libros.reposity.implement;

import com.librerialibertad.gestor_libros.model.Libro;
import com.librerialibertad.gestor_libros.reposity.LibroRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LibroRepositoryImpl implements LibroRepository {

    // ESTADO: ATRIBUTOS;
    private List<Libro> listaLibros = new ArrayList<>();
    private Long counts = 0L;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // findAll();
    @Override
    public List<Libro> findAllRepository() {
        return this.listaLibros;
    }

    // save(Libro libro);
    @Override
    public Libro saveRepository(Libro libro) {
        counts++;
        libro.setId(counts);
        listaLibros.add(libro);
        return libro;
    }

    // getBy(Long id);
    @Override
    public Optional<Libro> getByRepository(Long id) {

        for (Libro libro : this.listaLibros) {
            if (Objects.equals(libro.getId(), id)) {
                return Optional.of(libro);
            }
        }
        return Optional.empty();
    }

    // deleteBy(Long id);
    @Override
    public void deleteByRepository(Long id) {
        Optional<Libro> optionalLibro = this.getByRepository(id);

        if (optionalLibro.isPresent()) {
            this.listaLibros.remove(optionalLibro.get());
        }
    }

    // modifyBy(Long id);
    @Override
    public Optional<Libro> modifyByRepository(Long id, Libro libro) {

        Optional<Libro> optionalLibro = this.getByRepository(id);

        if (optionalLibro.isPresent()) {
            Libro libroModify = optionalLibro.get();

            // ISBN;
            libroModify.setIsbn(libro.getIsbn());

            // TITULO;
            libroModify.setTitulo(libro.getTitulo());

            // GENERO;
            libroModify.setGenero(libro.getGenero());

            // AUTOR;
            // NOMBRE;
            libroModify.getAutor().setNombre(libro.getAutor().getNombre());

            // APELLIDO;
            libroModify.getAutor().setApellido(libro.getAutor().getApellido());

            // FECHANACIMIENTO;
            libroModify.getAutor().setFechaNacimiento(libro.getAutor().getFechaNacimiento());

            // PAIS;
            libroModify.getAutor().setPais(libro.getAutor().getPais());

        }

        return optionalLibro;
    }


}
