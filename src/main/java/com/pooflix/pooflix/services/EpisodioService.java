package com.pooflix.pooflix.services;

import java.util.List;
import java.util.Optional;

import com.pooflix.pooflix.documents.Episodio;
import com.pooflix.pooflix.repository.EpisodioRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodioService {
    @Autowired
    EpisodioRepository epiRepo;

    public boolean crearNuevoEpisodio(Episodio episodio) {
        epiRepo.save(episodio);
        return true;
    }

    boolean existeEpisodio(Integer numero) {
        Episodio episodio = epiRepo.findByNumero(numero);
        if (episodio != null)
            return true;
        else
            return false;
    }

    public Episodio crearEpisodio(Integer numero, String titulo, double duracion) {
        if (existeEpisodio(numero)) {
            return null;
        } else {
            Episodio episodio = new Episodio();
            episodio.setNumero(numero);
            episodio.setTitulo(titulo);
            episodio.setDuracion(duracion);

            boolean epiCreado = crearNuevoEpisodio(episodio);
            if (epiCreado)
                return episodio;
            else
                return null;
        }

    }

    public List<Episodio> listarEpisodios() {
        return epiRepo.findAll();
    }

    public Episodio obtenerEpisodioPorId(ObjectId _id) {
        Optional<Episodio> opEpi = epiRepo.findById(_id);

        if (opEpi.isPresent())
            return opEpi.get();
        else
            return null;
    }

    public Episodio obtenerEpisodioPorNumero(Integer numero) {
        return epiRepo.findByNumero(numero);
    }

    public Episodio obtenerEpisodioPorTitulo(String titulo) {
        return epiRepo.findByTitulo(titulo);
    }

}
