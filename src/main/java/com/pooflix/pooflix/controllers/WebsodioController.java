package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Websodio;
import com.pooflix.pooflix.models.request.WebsodioRequest;
import com.pooflix.pooflix.models.response.GenericResponse;
import com.pooflix.pooflix.services.WebsodioService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebsodioController {
    @Autowired
    WebsodioService websodioService;

    @PostMapping("/websodios")
    public ResponseEntity<GenericResponse> crearWebsodio(@RequestBody WebsodioRequest webReq) {
        Websodio websodio = websodioService.crearWebsodio(webReq.numero, webReq.titulo, webReq.duracion, webReq.url);
        if (websodio == null) {
            return ResponseEntity.badRequest().build();
        }
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = websodio.get_id();
        gR.mensaje = "Creaste el websodio con exito!";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/websodios")
    public ResponseEntity<List<Websodio>> obtenerWebsodios() {
        return ResponseEntity.ok(websodioService.listarWebsodios());
    }

    @GetMapping("/websodios/{_id}")
    public ResponseEntity<Websodio> traerWebsodioPorId(@PathVariable ObjectId _id) {
        Websodio websodio = websodioService.obtenerWebsodioPorId(_id);
        if (websodio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(websodio);
    }

    @GetMapping("/api/websodios")
    public ResponseEntity<Websodio> buscarWebsodioPorTitulo(@RequestParam(value = "titulo") String titulo) {
        Websodio websodio = websodioService.obtenerWebsodioPorTitulo(titulo);
        if (websodio == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(websodio);

    }

    @GetMapping("/websodio/numero/{numero}")
    public ResponseEntity<Websodio> traerWebsodioPorNumero(@PathVariable Integer numero) {
        Websodio websodio = websodioService.obtenerWebsodioPorNumero(numero);
        if (websodio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(websodio);
    }

}
