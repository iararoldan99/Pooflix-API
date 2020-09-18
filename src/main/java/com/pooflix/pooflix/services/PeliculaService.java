package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.documents.Director;
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

    @Autowired
    ActorService actorService;

    @Autowired
    DirectorService directorService;

    public Pelicula crearPelicula(Pelicula pelicula) {
        return crearPelicula(pelicula.getTitulo(), pelicula.getDuracion(), new ObjectId(pelicula.getGenero().get_id()),
                new ObjectId(pelicula.getActor().get_id()), new ObjectId(pelicula.getDirector().get_id()));

    }

    public Pelicula crearPelicula(String titulo, double duracion, ObjectId _generoId, ObjectId _actorId,
            ObjectId _directorId) {

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(titulo);
        pelicula.setDuracion(duracion);
        Genero g = generoService.obtenerGeneroById(_generoId);
        pelicula.setGenero(g);
        Actor a = actorService.obtenerAPorId(_actorId);
        pelicula.setActor(a);
        Director d = directorService.obtenerDPorId(_directorId);
        pelicula.setDirector(d);
        peliculaRepo.save(pelicula);

        return pelicula;

    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepo.findAll();

    }

    public Pelicula obtenerPeliculaPorTitulo(String titulo) {
        return peliculaRepo.findByTitulo(titulo);
    }

    public Pelicula obtenerPeliculaPorId(ObjectId _id) {
        return peliculaRepo.findBy_id(_id);
    }

    public Pelicula actualizarPelicula(Pelicula pelicula) {
        return peliculaRepo.save(pelicula);
    }

    public void borrarPeliculaPorId(ObjectId _id) {
        peliculaRepo.deleteById(_id);

    }

    public void borrarTodasLasPeliculas() {
        peliculaRepo.deleteAll();
    }

    /*
     * public boolean asignarActor(ObjectId _id, ObjectId _idActor) { Pelicula
     * pelicula = obtenerPeliculaPorId(_id);
     * 
     * pelicula.asignarActor(actorService.obtenerActorPorId(_idActor));
     * 
     * peliculaRepo.save(pelicula);
     * 
     * return true; }
     * 
     */

}
