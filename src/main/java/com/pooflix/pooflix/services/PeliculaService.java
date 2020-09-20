package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.documents.Director;
import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.models.request.ModifPeli;
import com.pooflix.pooflix.models.request.PeliCalif;
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

    public boolean crearNuevaPelicula(Pelicula pelicula) {
        peliculaRepo.save(pelicula);
        return true;
    }

    public Pelicula crearPelicula(String titulo, List<Genero> generos, List<Director> directores, List<Actor> actores) {
        if (existePelicula(titulo)) {
            return null;
        } else {
            Pelicula pelicula = new Pelicula();
            pelicula.setTitulo(titulo);
            pelicula.setGeneros(generos);
            pelicula.setDirectores(directores);
            pelicula.setActores(actores);

            boolean peliculaCreada = crearNuevaPelicula(pelicula);
            if (peliculaCreada)
                return pelicula;
            else
                return null;
        }

    }

    boolean existePelicula(String titulo) {
        Pelicula pelicula = peliculaRepo.findByTitulo(titulo);
        if (pelicula != null)
            return true;
        else
            return false;
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

    public Pelicula modificarPelicula(Pelicula pelicula, ModifPeli modifPelicula) {

        pelicula.setTitulo(modifPelicula.titulo);
        pelicula.setGeneros(modifPelicula.generos);
        pelicula.setActores(modifPelicula.actores);
        pelicula.setDirectores(modifPelicula.directores);

        boolean peliculaModificada = this.crearNuevaPelicula(pelicula);
        if (peliculaModificada) {
            return pelicula;
        } else {
            return null;
        }

    }

    public void borrarPeliculaPorId(ObjectId _id) {
        peliculaRepo.deleteById(_id);

    }

    public void borrarTodasLasPeliculas() {
        peliculaRepo.deleteAll();
    }

    public Pelicula calificarPelicula(Pelicula peli, PeliCalif calificacion) {

        peli.setCalificacion(calificacion.calificacion);

        return peli;

    }

}
