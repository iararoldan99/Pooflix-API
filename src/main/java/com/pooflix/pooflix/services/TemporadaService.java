package com.pooflix.pooflix.services;

import java.util.List;
import java.util.Optional;

import com.pooflix.pooflix.documents.Episodio;
import com.pooflix.pooflix.documents.Temporada;
import com.pooflix.pooflix.documents.Websodio;
import com.pooflix.pooflix.repository.TemporadaRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemporadaService {
    @Autowired
    TemporadaRepository tRepo;

    public boolean crearNuevaTemporada(Temporada temporada) {
        tRepo.save(temporada);
        return true;
    }

    boolean existeTemporada(Integer numero) {
        Temporada temporada = tRepo.findByNumero(numero);
        if (temporada != null)
            return true;
        else
            return false;
    }

    public Temporada crearTemporada(Integer numero, Integer numTotalEpisodios, List<Episodio> episodios, List<Websodio> websodios) {
        if (existeTemporada(numero)) {
            return null;
        } else {
            Temporada temporada = new Temporada();
            temporada.setNumero(numero);
            temporada.setNumTotalEpisodios(numTotalEpisodios);
            temporada.setEpisodios(episodios);
            temporada.setWebsodios(websodios);

            boolean tempCreada = crearNuevaTemporada(temporada);
            if (tempCreada)
                return temporada;
            else
                return null;
        }

    }

    public List<Temporada> listarTemporadas() {
        return tRepo.findAll();
    }

    public Temporada obtenerTemporadaPorId(ObjectId _id) {
        Optional<Temporada> opTemporada = tRepo.findById(_id);

        if (opTemporada.isPresent())
            return opTemporada.get();
        else
            return null;
    }

    public Temporada obtenerTemporadaPorNumero(Integer numero) {
        return tRepo.findByNumero(numero);
    }

    public List<Temporada> obtenerTemporadaPorNumeroDeEpisodio(Integer numero) {
        return tRepo.findByEpisodios_numero(numero);
    }
}
