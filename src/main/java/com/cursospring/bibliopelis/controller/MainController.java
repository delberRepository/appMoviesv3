package com.cursospring.bibliopelis.controller;

import com.cursospring.bibliopelis.model.Genero;
import com.cursospring.bibliopelis.model.Peliculas;
import com.cursospring.bibliopelis.repository.IGenereRepository;
import com.cursospring.bibliopelis.services.GenereServices;
import com.cursospring.bibliopelis.services.MovieServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    private GenereServices gs;
    private MovieServices ms;

    public MainController(GenereServices gs, MovieServices ms) {
        this.ms = ms;
        this.gs = gs;

    }
    //aqui le inyecto el genereServices, es decir se inyectan servicios y repositorios

    @GetMapping("/")
    public String getMainPage(Model model){

        //OBTENER PELIS DEL SERVICIO y LOS AÑADE A OBJETO MODELO
        List<Genero> generosList = gs.getAllGeneros();
        model.addAttribute("generos", generosList);

        //OBTENER PELIS DEL SERVICIO
        List<Peliculas> peliculasList =ms.getAllPeliculas();
        model.addAttribute("peliculas",peliculasList);


        return "index";
    }


    @GetMapping("/createMovie")
    public String createMovie(Model model) {
        model.addAttribute("pelicula", new Peliculas());

        //OBTENER PELIS DEL SERVICIO y LOS AÑADE A OBJETO MODELO
        List<Genero> generosList = gs.getAllGeneros();
        model.addAttribute("generos", generosList);
        return "nuevaPelicula";
    }

    @PostMapping("/createMovie")
    public String createMovie(@ModelAttribute Peliculas pelicula){
        this.ms.crearPelicula(pelicula);
        return "redirect:/";
    }
    @GetMapping("/verFicha/{id}")
    public String verFicha(@PathVariable int id, Model model) {

        Peliculas pelicula = ms.getPeliculaById(id);
        //aqui llamo al metodo para extraer el identificador y
        //luego vuelvo a cagar en la variable videoUrl.
        String videoId = ms.extractYoutubeId(pelicula.getVideoUrl());
        pelicula.setVideoUrl(videoId);

        model.addAttribute("pelicula", pelicula);

        return "fichaBorrar";
    }
    @PostMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable int id){
        this.ms.borrarPelicula(id);
        return "redirect:/";

    }
   @PostMapping("/searchMovie")
    public String searchMovie(@RequestParam String searchTitle, @RequestParam Integer searchGenero,Model model){
       List<Genero> generosList = gs.getAllGeneros();
       List<Peliculas> peliculasList =ms.findByTitleAndGenero(searchTitle,searchGenero);
       model.addAttribute("generos",generosList);
       model.addAttribute("peliculas",peliculasList);
       return"index";
    }


}
