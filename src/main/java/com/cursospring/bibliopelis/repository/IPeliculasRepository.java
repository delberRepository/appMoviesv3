package com.cursospring.bibliopelis.repository;
import com.cursospring.bibliopelis.model.Genero;
import com.cursospring.bibliopelis.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPeliculasRepository extends JpaRepository<Peliculas,Integer> {

    List<Peliculas> findByTituloContaining(String titulo);

    //aqui tengo que pasarle el tipo de consulta a traves del nombre de la funcion, es importante que este bien formulado para que lo
    //coja, tiene que coincidir con el nombre de la identidad en la clase.
    List<Peliculas> findByTituloContainingAndGeneroId(String titulo, int genero_id);
}
