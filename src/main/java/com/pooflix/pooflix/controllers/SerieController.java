package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Episodio;
import com.pooflix.pooflix.documents.Serie;
import com.pooflix.pooflix.documents.Temporada;
import com.pooflix.pooflix.models.request.SerieModificacionRequest;
import com.pooflix.pooflix.models.request.SerieRequest;
import com.pooflix.pooflix.models.response.GenericResponse;
import com.pooflix.pooflix.services.SerieService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {
    @Autowired
    SerieService serieService;

    @PostMapping("/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody SerieRequest serieReq) {

        Serie serie = serieService.crearSerie(serieReq.titulo, serieReq.generos, serieReq.actores, serieReq.directores,
                serieReq.temporadas);
        if (serie == null) {
            return ResponseEntity.badRequest().build();
        }
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = serie.get_id();
        gR.mensaje = "La serie fue creada con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/series")
    public ResponseEntity<List<Serie>> traerTodasLasSeries() {

        return ResponseEntity.ok(serieService.listarSeries());
    }

    @GetMapping("/series/{_id}")
    public ResponseEntity<Serie> traerSeriePorId(@PathVariable ObjectId _id) {

        return ResponseEntity.ok(serieService.obtenerSeriePorId(_id));
    }

    @GetMapping("/series/titulo/{titulo}")
    public ResponseEntity<Serie> traerSeriePorTitulo(@PathVariable String titulo) {

        return ResponseEntity.ok(serieService.obtenerSeriePorTitulo(titulo));
    }

    // /series?genero=Ciencia%20Ficción
    @GetMapping("/series/genero/{genero}")
    public ResponseEntity<List<Serie>> traerSeriesPorGenero(@PathVariable String genero) {

        return ResponseEntity.ok(serieService.buscarPorGenero(genero));

    }

    @GetMapping("/series/actores/{_id}")
    public ResponseEntity<List<Serie>> traerSeriePorActorId(@PathVariable ObjectId _id) {
        return ResponseEntity.ok(serieService.obtenerSeriesByActor(_id));

    }

    @GetMapping("/series/temporadas/{_id}")
    public ResponseEntity<List<Temporada>> traerTemporadasPorSerieId(@PathVariable ObjectId _id) {

        return ResponseEntity.ok(serieService.traerTemporadasPorSerieId(_id));
    }

    //
    @GetMapping("/series/{id}/episodios")
    public ResponseEntity<List<Episodio>> traerEpisodios(@PathVariable ObjectId _id) {

        return ResponseEntity.ok(serieService.obtenerEpisodiosSerie(_id));

    }

    // @GetMapping("/series/{id}/temporadas/{nroTemporada}/episodios/{nroEpisodio}")
    @GetMapping("/series/{id}/episodios/{nroTemporada}-{nroEpisodio}")
    public ResponseEntity<Episodio> traerEpisodio(@PathVariable ObjectId _id, @PathVariable int nroTemporada,
            @PathVariable int nroEpisodio) {

        Episodio episodio = serieService.obtenerEpisodioPorNroEpisodio(_id, nroTemporada, nroEpisodio);
        if (episodio == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(episodio);

    }

    @PutMapping("/series/{_id}")
    public ResponseEntity<GenericResponse> modificarSerie(@PathVariable ObjectId _id,
            SerieModificacionRequest modifSerie) {
        Serie serie = serieService.obtenerSeriePorId(_id);
        if (serie == null) {
            return ResponseEntity.notFound().build();
        }

        else {

            Serie serieModificada = serieService.modificarSerie(serie, modifSerie);
            if (serieModificada == null) {
                return ResponseEntity.badRequest().build();
            } else {
                GenericResponse gR = new GenericResponse();
                gR.id = serieModificada.get_id();
                gR.isOk = true;
                gR.mensaje = "Se han actualizado los datos de la serie de forma exitosa";

                return ResponseEntity.ok(gR);

            }
        }
    }

    @PutMapping("/series/calificacion/{id}")
    ResponseEntity<GenericResponse> calificarLaSerie(@PathVariable ObjectId _id, double calificacion) {

        Serie serie = serieService.obtenerSeriePorId(_id);
        if (serie == null) {
            return ResponseEntity.notFound().build();
        } else {
            Serie serieCalificada = serieService.calificarSerie(serie, calificacion);
            GenericResponse gR = new GenericResponse();
            gR.id = serieCalificada.get_id();
            gR.isOk = true;
            gR.mensaje = "Calificacion exitosa. Calificacion de la pelicula es: " + serieCalificada.getCalificacion();
            return ResponseEntity.ok(gR);
        }

    }

}
