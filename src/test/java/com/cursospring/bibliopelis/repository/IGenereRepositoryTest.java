package com.cursospring.bibliopelis.repository;

import com.cursospring.bibliopelis.model.Genero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IGenereRepositoryTest {
    @Autowired
    IGenereRepository gr;

    public void crearGenero(){
        gr.save(new Genero("Terror"));
    }

}