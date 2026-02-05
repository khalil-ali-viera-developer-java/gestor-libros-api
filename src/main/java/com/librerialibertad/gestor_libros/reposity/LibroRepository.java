package com.librerialibertad.gestor_libros.reposity;

import com.librerialibertad.gestor_libros.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroRepository {

    List<Libro> findAllRepository();

    Libro saveRepository(Libro libro);

    Optional<Libro> getByRepository(Long id);

    void deleteByRepository(Long id);

    Optional<Libro> modifyByRepository(Long id, Libro libro);
}
