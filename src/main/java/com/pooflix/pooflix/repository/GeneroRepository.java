package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.documents.Pelicula;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends MongoRepository<Genero, ObjectId> {
    Genero findBy_id(ObjectId _id);

}