package com.cursospring.bibliopelis.services;

import com.cursospring.bibliopelis.model.Genero;
import com.cursospring.bibliopelis.repository.IGenereRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenereServices {

    //PROPIEDADES
    private IGenereRepository generoRepository;

    //CONSTRUCTOR
    public GenereServices(IGenereRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    // ///////////// METODOS

    //OBTENER TODOS LOS GENEROS
    public List<Genero> getAllGeneros(){
        //LLAMA A LOS METODOS DE LA INTERFACE
        List<Genero> generos = this.generoRepository.findAll();
        return generos;
    }
  //CREAR GENEROS
    public void createGenero(Genero genero) {
        this.generoRepository.save(genero);
    }
}
