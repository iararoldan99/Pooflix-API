package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.documents.Persona;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonaRepository extends MongoRepository<Persona, ObjectId> {
    Pelicula findBy_id(ObjectId _id);
}
