package com.anahuac.desarrollo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.anahuac.desarrollo.entities.Libro;
import com.anahuac.desarrollo.services.LibroCRUDService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LibroController {

    @Autowired
    public LibroCRUDService libroService;

    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable Integer id, Model  model) {
        model.addAttribute("libro", libroService.buscarLibroPorId(id));
        return "libroform";
    }

    @RequestMapping(value = "/updatelibro", method=RequestMethod.POST)
    public String UpdateLibro(Libro libro) {
        libroService.cambiarLibro(libro);
        System.out.println(">>>Update libro");

        return "redirect:/index";
    }
    

    @RequestMapping(value="/delete/{id}")
    public String deleteLibro(@PathVariable int id) {
        libroService.borrarLibro(id);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showLibroList(Model modelo) {
        modelo.addAttribute("libros", libroService.obtenerTodosLosLibros());
        return "index";
    }

    @RequestMapping(value="libro/new")
    public String newLibro(Model modelo) {
        modelo.addAttribute("libro", new Libro());
        return "add-libro";
    }

   @PostMapping("addlibro")
    public String saveLibro(Libro libro) {
        libroService.agregarLibro(libro.getIsbn(),libro.getNombre(),libro.getAutor(),libro.getEditorial());
        System.out.println(">>> Save Libro");
        return "redirect:/index";
    }
}
