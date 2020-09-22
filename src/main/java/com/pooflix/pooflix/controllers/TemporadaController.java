package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Temporada;
import com.pooflix.pooflix.models.request.TemporadaRequest;
import com.pooflix.pooflix.models.response.GenericResponse;
import com.pooflix.pooflix.services.TemporadaService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemporadaController {

    @Autowired
    TemporadaService temporadaService;

    @PostMapping("/temporadas")
    public ResponseEntity<GenericResponse> crearTemporada(@RequestBody TemporadaRequest reqTemp) {
        Temporada temporada = temporadaService.crearTemporada(reqTemp.numero, reqTemp.numTotalEpisodios,
                reqTemp.episodios, reqTemp.websodios);
        if (temporada == null) {
            return ResponseEntity.badRequest().build();
        }
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = temporada.get_id();
        gR.mensaje = "Temporada creada con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/temporadas")
    public ResponseEntity<List<Temporada>> obtenerTemporadas() {
        return ResponseEntity.ok(temporadaService.listarTemporadas());
    }

    @GetMapping("/temporadas/{_id}")
    public ResponseEntity<Temporada> obtenerTemporadaPorId(@PathVariable ObjectId _id) {
        return ResponseEntity.ok(temporadaService.obtenerTemporadaPorId(_id));
    }

    @GetMapping("/temporadas/numero/{numero}")
    public ResponseEntity<Temporada> obtenerTemporadaPorNumero(@PathVariable Integer numero) {
        return ResponseEntity.ok(temporadaService.obtenerTemporadaPorNumero(numero));
    }

    @GetMapping("/temporadas/episodios/{numero}")
    public ResponseEntity<List<Temporada>> obtenerTemporadaPorNumeroDeEpisodio(@PathVariable Integer numero) {
        return ResponseEntity.ok(temporadaService.obtenerTemporadaPorNumeroDeEpisodio(numero));
    }
}
