package com.anahuac.desarrollo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name = "autor", nullable = false, length = 100)
	private String autor;
	@Column(name="isbn", unique=true, nullable=false, length =100)
	private String isbn;
    @Column(name="editorial", nullable=false, length =100)
	private String editorial;

    public Libro(String nombre, String autor, String isbn, String editorial) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
    }

    public Libro() {}
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", autor=").append(autor);
        sb.append(", isbn=").append(isbn);
        sb.append(", editorial=").append(editorial);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

}