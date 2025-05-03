package com.anahuac.desarrollo.daos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.anahuac.desarrollo.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    Libro findByIsbn(String isbn);
    Libro deleteById(int id);

}
