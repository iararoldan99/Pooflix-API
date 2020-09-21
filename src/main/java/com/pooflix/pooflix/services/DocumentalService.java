package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.*;
import com.pooflix.pooflix.documents.Documental;
import com.pooflix.pooflix.models.request.DocuCalif;
import com.pooflix.pooflix.models.request.ModifDoc;
import com.pooflix.pooflix.repository.DocumentalRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentalService {
    @Autowired
    DocumentalRepository docuRepo;

    public boolean crearNuevoDocumental(Documental documental) {
        docuRepo.save(documental);
        return true;
    }

    public Documental crearDocumental(String titulo, List<Genero> generos, List<Director> directores,
            List<Actor> actores) {
        if (existeDocumental(titulo)) {
            return null;
        } else {
            Documental documental = new Documental();
            documental.setTitulo(titulo);
            documental.setGeneros(generos);
            documental.setDirectores(directores);
            documental.setActores(actores);

            boolean DocumentalCreado = crearNuevoDocumental(documental);
            if (DocumentalCreado)
                return documental;
            else
                return null;
        }

    }

    boolean existeDocumental(String titulo) {
        Documental documental = docuRepo.findByTitulo(titulo);
        if (documental != null)
            return true;
        else
            return false;
    }

    public List<Documental> obtenerTodosLosDocumentals() {
        return docuRepo.findAll();

    }

    public Documental obtenerDocumentalPorTitulo(String titulo) {
        return docuRepo.findByTitulo(titulo);
    }

    public Documental obtenerDocumentalPorId(ObjectId _id) {
        return docuRepo.findBy_id(_id);
    }

    public Documental modificarDocumental(Documental documental, ModifDoc modifDocumental) {

        documental.setTitulo(modifDocumental.titulo);
        documental.setGeneros(modifDocumental.generos);
        documental.setActores(modifDocumental.actores);
        documental.setDirectores(modifDocumental.directores);

        boolean documentalModificado = this.crearNuevoDocumental(documental);
        if (documentalModificado) {
            return documental;
        } else {
            return null;
        }

    }

    public void borrarDocumentalPorId(ObjectId _id) {
        docuRepo.deleteById(_id);

    }

    public void borrarTodasLasDocumentals() {
        docuRepo.deleteAll();
    }

    public Documental calificarDocumental(Documental peli, DocuCalif calificacion) {

        peli.setCalificacion(calificacion.calificacion);

        return peli;

    }

}
