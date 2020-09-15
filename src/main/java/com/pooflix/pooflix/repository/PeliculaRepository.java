package com.pooflix.pooflix.repository;

import java.util.List;

import com.pooflix.pooflix.documents.Pelicula;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, ObjectId> {
    Pelicula findBy_id(ObjectId _id);

    Pelicula findByTitulo(String titulo);

    List<Pelicula> findByActores(String fullName);

    List<Pelicula> findByDirectores(String fullName);


}
