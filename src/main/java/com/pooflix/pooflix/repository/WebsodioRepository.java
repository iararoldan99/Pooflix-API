package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Websodio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsodioRepository extends MongoRepository<Websodio, ObjectId> {
    Websodio findBy_id(ObjectId id);

    Websodio findByNumero(Integer numero);

    Websodio findByTitulo(String titulo);
}
