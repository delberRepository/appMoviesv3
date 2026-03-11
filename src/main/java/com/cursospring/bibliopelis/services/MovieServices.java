package com.cursospring.bibliopelis.services;

import com.cursospring.bibliopelis.model.Genero;
import com.cursospring.bibliopelis.model.Peliculas;
import com.cursospring.bibliopelis.repository.IPeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {

    private IPeliculasRepository peliculasRepository;


    public MovieServices(IPeliculasRepository peliculasRepository) {
        this.peliculasRepository = peliculasRepository;
    }

    //OBTENER TODAS LAS PELICULAS
    public List<Peliculas> getAllPeliculas(){
        //LLAMA A LOS METODOS DE LA INTERFACE
        List<Peliculas> peliculas = this.peliculasRepository.findAll();
        return peliculas;
    }
    // Crear película
    public Peliculas crearPelicula(Peliculas pelicula) {
        return peliculasRepository.save(pelicula);
    }

    // Borrar película por id
    public void borrarPelicula(int id) {
        peliculasRepository.deleteById(id);
    }
    //Obtener peliculas por el Id
    public Peliculas getPeliculaById(int id) {
        return peliculasRepository.findById(id).orElse(null);
    }

    //Extraer el Id del Url
    public String extractYoutubeId(String url) {
        String[] parts = url.split("v=");
        if (parts.length > 1) {
            return parts[1].split("&")[0];
        }
        return url;
    }

    public List<Peliculas>findByTitleAndGenero(String titulo, int idGenero){
        //segun tenga genero valido como parametro llama a un metodo de la interface u otro.
      if (idGenero==0)  {
        List<Peliculas>peliculas= peliculasRepository.findByTituloContaining(titulo);
        return peliculas;
      }else{
          List<Peliculas>peliculas=peliculasRepository.findByTituloContainingAndGeneroId(titulo,idGenero);
        return  peliculas;
      }
    }
}
