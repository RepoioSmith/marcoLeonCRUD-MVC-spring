package com.anahuac.desarrollo.services;

import java.util.List;

import com.anahuac.desarrollo.entities.Libro;

public interface LibroCRUDService {
    public Libro agregarLibro(String isbn, String nombre, String autor, String editorial);
    public void cambiarLibro(Libro libro);
    public Libro obtenerLibro(int id);
    public Libro buscarLibroPorId(int id);
    public void borrarLibro(int id);
    public List<Libro> obtenerTodosLosLibros();
    public Libro buscarLibroPorIsbn(String isbn);
}