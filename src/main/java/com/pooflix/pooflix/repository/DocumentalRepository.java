package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Documental;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentalRepository extends MongoRepository<Documental, ObjectId> {
    Documental findBy_id(ObjectId id);

    Documental findByTitulo(String titulo);

}
