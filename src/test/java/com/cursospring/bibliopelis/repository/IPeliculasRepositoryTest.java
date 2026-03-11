package com.cursospring.bibliopelis.repository;

import com.cursospring.bibliopelis.model.Genero;
import com.cursospring.bibliopelis.model.Peliculas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IPeliculasRepositoryTest {


    @Autowired
    private IPeliculasRepository ipr;


    void create() {
        Peliculas pelicula = new Peliculas("El hombre con rayos X en los ojos", "Roger Corman", "https://pics.filmaffinity.com/El_hombre_con_rayos_X_en_los_ojos-763033877-large.jpg", "https://youtu.be/STlGp8ZuDG0?si=lu3UsqN-cxDEo34Z", new Genero(1,"Terror"));
        this.ipr.save(pelicula);
    }


    void findAllPeliculas() {
        List<Peliculas> peliculas = ipr.findAll();
        peliculas.forEach(pelicula -> {
            System.out.println(pelicula);
        });
    }

}


