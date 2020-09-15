package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Serie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SerieRepository extends MongoRepository<Serie, ObjectId> {
    Serie findBy_id(ObjectId _id);
    Serie findByTitulo(String titulo);


    
}
