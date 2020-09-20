package com.pooflix.pooflix.services;

import java.util.ArrayList;
import java.util.List;

import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.repository.GeneroRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepo;

    public Genero crearGenero(Genero genero) {
        return generoRepo.save(genero);

    }

    public Genero crearGenero(String nombre) {

        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoRepo.save(genero);

        return genero;

    }

    public List<Genero> obtenerGeneros() {
        return generoRepo.findAll();

    }

    public Genero obtenerGeneroById(ObjectId _objectId) {

        return generoRepo.findBy_id(_objectId);
    }

    public Genero obtenerGeneroPorNombre(String nombre) {
        Genero genero = generoRepo.findByNombre(nombre);
        return genero;
    }

    public Genero actualizarGenero(Genero genero) {
        return generoRepo.save(genero);
    }

    public void borrarGeneroPorId(ObjectId _id) {
        generoRepo.deleteById(_id);

    }

    public void borrarTodosLosGeneros() {
        generoRepo.deleteAll();
    }

}
