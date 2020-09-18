package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.Director;
import com.pooflix.pooflix.repository.DirectorRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    public Director crearDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director crearDirector(String fullName) {
        Director director = new Director();
        director.setFullName(fullName);
        directorRepository.save(director);
        return director;
    }

    public List<Director> listarDirectores() {
        return directorRepository.findAll();
    }

    public Director obtenerPorNombre(String fullName){
        return directorRepository.findByFullName(fullName);
    }

    public ObjectId obtenerDirectorPorId(ObjectId _id) {
        directorRepository.findBy_id(_id);
        return _id;
    }

    public Director obtenerDPorId(ObjectId _id) {
        return directorRepository.findBy_id(_id);
    }

    public Director actualizarDirector(Director director) {
        return directorRepository.save(director);
    }

    public void borrarDirectorPorId(ObjectId _id) {
        directorRepository.deleteById(_id);

    }

    public void borrarTodosLosDirectores() {
        directorRepository.deleteAll();
    }
}
