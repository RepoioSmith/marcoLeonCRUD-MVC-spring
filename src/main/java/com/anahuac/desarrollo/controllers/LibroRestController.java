package com.anahuac.desarrollo.controllers;

import com.anahuac.desarrollo.entities.Libro;
import com.anahuac.desarrollo.services.LibroCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    @Autowired
    private LibroCRUDService libroService;

    // GET /api/libros - Regresa todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    // GET /api/libros/{id} - Regresa un libro por ID
    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Integer id) {
        return libroService.buscarLibroPorId(id);
    }

    // POST /api/libros - Crea un nuevo libro
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        libroService.agregarLibro(libro.getIsbn(), libro.getNombre(), libro.getAutor(), libro.getEditorial());
        return libro;
    }

    // PUT /api/libros/{id} - Actualiza un libro existente (excepto el ID)
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Integer id, @RequestBody Libro libroActualizado) {
        Libro libroExistente = libroService.buscarLibroPorId(id);
        if (libroExistente != null) {
            libroExistente.setIsbn(libroActualizado.getIsbn());
            libroExistente.setNombre(libroActualizado.getNombre());
            libroExistente.setAutor(libroActualizado.getAutor());
            libroExistente.setEditorial(libroActualizado.getEditorial());
            libroService.cambiarLibro(libroExistente);
        }
        return libroExistente;
    }

    // DELETE /api/libros/{id} - Borra un libro por ID
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Integer id) {
        libroService.borrarLibro(id);
    }
}
