package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Director;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends MongoRepository<Director, ObjectId> {
    Director findBy_id(ObjectId _id);

    Director findByFullName(String fullName);

}
