package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.repository.PeliculaRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepo;

    @Autowired
    GeneroService generoService;

    public Pelicula crearPelicula(Pelicula pelicula) {
      //  return peliculaRepo.save(pelicula);
      return crearPelicula(pelicula.getTitulo(), pelicula.getDuracion(), new ObjectId(pelicula.getGenero().get_id()));

    }

    public Pelicula crearPelicula(String titulo, double duracion, ObjectId _generoId) {

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(titulo);
        pelicula.setDuracion(duracion);
        Genero g = generoService.obtenerGeneroById(_generoId);
        pelicula.setGenero(g);
        peliculaRepo.save(pelicula);


        return pelicula;

    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepo.findAll();

    }

    public Pelicula obtenerPeliculaPorTitulo(String titulo){
        return peliculaRepo.findByTitulo(titulo);
    }

    public Pelicula obtenerPeliculaPorId(ObjectId _id){
        return peliculaRepo.findBy_id(_id);
    }

    public List<Pelicula> obtenerPeliculaPorActor(String fullName){
        return peliculaRepo.findByActores(fullName);
    }

    public List<Pelicula> obtenerPeliculaPorDirector(String fullName){
        return peliculaRepo.findByDirectores(fullName);
    }

}
