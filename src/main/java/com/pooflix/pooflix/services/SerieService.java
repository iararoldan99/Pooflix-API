package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.Serie;
import com.pooflix.pooflix.repository.SerieRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepo;

    public Serie crearSerie(Serie serie) {
        return serieRepo.save(serie);
    }

    public Serie crearSerie(String titulo) {
        Serie serie = new Serie();
        serie.setTitulo(titulo);
        serieRepo.save(serie);
        return serie;
    }

    public List<Serie> listarSeries() {
        return serieRepo.findAll();
    }

    public Serie obtenerSeriePorId(ObjectId _id) {
        return serieRepo.findBy_id(_id);
    }

    public Serie obtenerSeriePorTitulo(String titulo) {
        return serieRepo.findByTitulo(titulo);
    }

}
