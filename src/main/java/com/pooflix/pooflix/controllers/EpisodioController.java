package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Episodio;
import com.pooflix.pooflix.models.request.EpisodioRequest;
import com.pooflix.pooflix.models.response.GenericResponse;
import com.pooflix.pooflix.services.EpisodioService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EpisodioController {

    @Autowired
    EpisodioService episodioService;

    @PostMapping("/episodios")
    public ResponseEntity<GenericResponse> crearEpisodio(@RequestBody EpisodioRequest epiReq) {
        Episodio episodio = episodioService.crearEpisodio(epiReq.numero, epiReq.titulo, epiReq.duracion);
        if (episodio == null) {
            return ResponseEntity.badRequest().build();
        }
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = episodio.get_id();
        gR.mensaje = "Creaste el episodio con exito!";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/episodios")
    public ResponseEntity<List<Episodio>> obtenerEpisodios() {
        return ResponseEntity.ok(episodioService.listarEpisodios());
    }

    @GetMapping("/episodios/{_id}")
    public ResponseEntity<Episodio> traerEpisodioPorId(@PathVariable ObjectId _id) {
        Episodio episodio = episodioService.obtenerEpisodioPorId(_id);
        if (episodio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(episodio);
    }

    @GetMapping("/api/episodios")
    public ResponseEntity<Episodio> buscarEpisodioPorTitulo(@RequestParam(value = "titulo") String titulo) {
        Episodio episodio = episodioService.obtenerEpisodioPorTitulo(titulo);
        if (episodio == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(episodio);

    }

    @GetMapping("/episodio/numero/{numero}")
    public ResponseEntity<Episodio> traerEpisodioPorNumero(@PathVariable Integer numero) {
        Episodio episodio = episodioService.obtenerEpisodioPorNumero(numero);
        if (episodio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(episodio);
    }
}
