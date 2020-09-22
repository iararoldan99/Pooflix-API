package com.pooflix.pooflix.repository;

import java.util.List;

import com.pooflix.pooflix.documents.Temporada;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporadaRepository extends MongoRepository<Temporada, ObjectId> {
    Temporada findBy_id(ObjectId id);

    Temporada findByNumero(Integer numero);

    List<Temporada> findByEpisodios_numero(Integer numero);
}
