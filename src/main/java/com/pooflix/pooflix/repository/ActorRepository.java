package com.pooflix.pooflix.repository;

import com.pooflix.pooflix.documents.Actor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<Actor, ObjectId> {
    Actor findBy_id(ObjectId _id);

    Actor findByFullName(String fullName);

}
