package com.librerialibertad.gestor_libros.service;

import com.librerialibertad.gestor_libros.exception.LibroNotFoundException;
import com.librerialibertad.gestor_libros.model.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> findAllService();

    Libro saveService(Libro libro);

    Libro getByService(Long id) throws LibroNotFoundException;

    Libro getByService(String titulo) throws LibroNotFoundException;

    void deleteByService(Long id) throws LibroNotFoundException;

    Libro modifyByService(Long id, Libro libro) throws LibroNotFoundException;
}
