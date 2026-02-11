package com.librerialibertad.gestor_libros.controller;

import com.librerialibertad.gestor_libros.exception.LibroNotFoundException;
import com.librerialibertad.gestor_libros.model.Libro;
import com.librerialibertad.gestor_libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    // ESTADO: ATRIBUTOS;
    private LibroService libroService;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    public LibroController(@Autowired LibroService libroService) {
        this.libroService = libroService;
    }

    // findAll();
    @GetMapping
    public ResponseEntity<List<Libro>> findAllController() {
        List<Libro> libros = this.libroService.findAllService(); // 200;
        return ResponseEntity.ok(libros);
    }

    // save(Libro libro);
    @PostMapping
    public ResponseEntity<?> saveController(@RequestBody Libro libro) {
        try {
            Libro libroGuardado = this.libroService.saveService(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado); // 200;
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        }
    }

    // getBy(Long id);
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByController(@PathVariable Long id) {
        try {
            Libro libro = this.libroService.getByService(id);
            return ResponseEntity.ok(libro); // 200;
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        } catch (LibroNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404;
        }
    }

    // getBy(String titulo);
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> getByController(@PathVariable String titulo) {
        try {
            Libro libro = this.libroService.getByService(titulo);
            return ResponseEntity.ok(libro); // 200;
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        } catch (LibroNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404;
        }
    }

    // deleteBy(Long id);
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByController(@PathVariable Long id) {
        try {
            this.libroService.deleteByService(id);
            return ResponseEntity.noContent().build(); // 204;
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400;
        } catch (LibroNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404;
        }
    }

    // modifyBy(Long id, Libro libro);
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyByController(@PathVariable Long id, @RequestBody Libro libro) {
        try {
            Libro libroModifyController = this.libroService.modifyByService(id, libro);
            return ResponseEntity.ok(libroModifyController); // 200;
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        } catch (LibroNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404;
        }
    }

}
