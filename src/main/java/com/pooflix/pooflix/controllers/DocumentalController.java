package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Documental;
import com.pooflix.pooflix.models.request.DocuCalif;
import com.pooflix.pooflix.models.request.DocuRequest;
import com.pooflix.pooflix.models.request.ModifDoc;
import com.pooflix.pooflix.models.response.GenericResponse;
import com.pooflix.pooflix.services.DocumentalService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentalController {
    @Autowired
    DocumentalService docuService;

    @PostMapping("/documentales")
    public ResponseEntity<GenericResponse> crearDocumental(@RequestBody DocuRequest docuReq) {

        Documental documental = docuService.crearDocumental(docuReq.titulo, docuReq.generos, docuReq.directores,
                docuReq.actores);
        if (documental == null) {
            return ResponseEntity.badRequest().build();
        }
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = documental.get_id();
        gR.mensaje = "El documental fue creado exitosamente";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/documentales")
    public ResponseEntity<List<Documental>> listarPeliculas() {
        return ResponseEntity.ok(docuService.obtenerTodosLosDocumentals());
    }

    @GetMapping("/documentales/{_id}")
    public ResponseEntity<Documental> buscarDocumentaPorId(@PathVariable ObjectId _id) {
        Documental documental = docuService.obtenerDocumentalPorId(_id);
        if (documental == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(documental);

    }

    @GetMapping("/api/documentales")
    public ResponseEntity<Documental> buscarDocumentalPorTitulo(@RequestParam(value = "titulo") String titulo) {
        Documental documental = docuService.obtenerDocumentalPorTitulo(titulo);
        if (documental == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(documental);

    }

    @PutMapping("/documentales/{id}")
    public ResponseEntity<GenericResponse> modificarDocumental(@PathVariable ObjectId _id, ModifDoc modifDoc) {
        Documental documental = docuService.obtenerDocumentalPorId(_id);
        if (documental == null) {
            return ResponseEntity.notFound().build();
        }

        else {

            Documental docModificado = docuService.modificarDocumental(documental, modifDoc);
            if (docModificado == null) {
                return ResponseEntity.badRequest().build();
            } else {
                GenericResponse gR = new GenericResponse();
                gR.id = docModificado.get_id();
                gR.isOk = true;
                gR.mensaje = "Los datos del documental fueron actualizados exitosamente";

                return ResponseEntity.ok(gR);

            }
        }
    }

    @PutMapping("/api/documentales/{_id}")
    ResponseEntity<GenericResponse> calificarDocumental(@PathVariable ObjectId _id, DocuCalif calificacion) {

        Documental documental = docuService.obtenerDocumentalPorId(_id);
        if (documental == null) {
            return ResponseEntity.notFound().build();
        } else {
            Documental docuCalificado = docuService.calificarDocumental(documental, calificacion);
            GenericResponse gR = new GenericResponse();
            gR.id = docuCalificado.get_id();
            gR.isOk = true;
            gR.mensaje = "enviaste tu calificacion exitosamente, el puntaje del documental es: "
                    + docuCalificado.getCalificacion();
            return ResponseEntity.ok(gR);
        }

    }

}
