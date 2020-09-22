package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Episodio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodioRepository extends MongoRepository<Episodio, ObjectId> {
    Episodio findBy_id(ObjectId _id);

    Episodio findByNumero(Integer numero);

    Episodio findByTitulo(String titulo);
}
