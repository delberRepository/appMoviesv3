package com.cursospring.bibliopelis.repository;
import com.cursospring.bibliopelis.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenereRepository  extends JpaRepository<Genero,Integer> {
}
