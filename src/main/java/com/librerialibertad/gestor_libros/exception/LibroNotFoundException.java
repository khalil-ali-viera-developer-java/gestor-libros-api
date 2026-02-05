package com.librerialibertad.gestor_libros.exception;

public class LibroNotFoundException extends RuntimeException{

    public LibroNotFoundException() {
    }

    public LibroNotFoundException(String message) {
        super(message);
    }
}
