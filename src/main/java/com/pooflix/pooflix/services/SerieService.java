package com.pooflix.pooflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pooflix.pooflix.documents.*;
import com.pooflix.pooflix.models.request.SerieModificacionRequest;
import com.pooflix.pooflix.repository.SerieRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    public boolean crearNuevaSerie(Serie serie) {
        serieRepo.save(serie);
        return true;
    }

    boolean existeSerie(String titulo) {
        Serie serie = serieRepo.findByTitulo(titulo);
        if (serie != null)
            return true;
        else
            return false;
    }

    public Serie crearSerie(String titulo, List<Genero> generos, List<Actor> actores, List<Director> directores, List<Temporada> temporadas) {
        if (existeSerie(titulo)) {
            return null;
        } else {
            Serie serie = new Serie();
            serie.setTitulo(titulo);
            serie.setGeneros(generos);
            serie.setDirectores(directores);
            serie.setActores(actores);
            serie.setTemporadas(temporadas);

            boolean serieCreada = crearNuevaSerie(serie);
            if (serieCreada)
                return serie;
            else
                return null;
        }

    }

    public List<Serie> listarSeries() {
        return serieRepo.findAll();
    }

    public Serie obtenerSeriePorId(ObjectId _id) {
        Optional<Serie> opSerie = serieRepo.findById(_id);

        if (opSerie.isPresent())
            return opSerie.get();
        else
            return null;
    }

    public Serie obtenerSeriePorTitulo(String titulo) {
        return serieRepo.findByTitulo(titulo);
    }

    public boolean tieneGenero(Serie serie, String genero) {
        return serie.getGeneros().stream().filter(g -> g.getNombre().equals(genero)).count() > 0;
    }

    public List<Serie> buscarPorGenero(String genero) {

        return listarSeries().stream().filter(p -> this.tieneGenero(p, genero)).collect(Collectors.toList());
    }

    public List<Temporada> traerTemporadasPorSerieId(ObjectId _id) {

        return obtenerSeriePorId(_id).getTemporadas();
    }

    public Serie calificarSerie(Serie serie, Double calificacion) {

        serie.setCalificacion(calificacion);
        boolean serieCalificada = this.crearNuevaSerie(serie);
        if (serieCalificada) {
            return serie;

        } else {
            return null;
        }

    }

    public List<Serie> obtenerSeriesByActor(ObjectId actorId) {
        // En este caso trae solo info del Actor.
        List<Serie> series = serieRepo.findSeriesByActores_IdSoloInfoActor(actorId);
        // List<Serie> series = serieRepo.findSeriesByActor_IdEntero(actorId);
        return series;
    }

    public List<Episodio> obtenerEpisodiosSerie(ObjectId _id) {

        return this.obtenerSeriePorId(_id).getTemporadas().stream().map(t -> t.getEpisodios()).flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public Episodio obtenerEpisodioPorNroEpisodio(ObjectId serieId, Integer temporadaNro, Integer episodioNumero) {

        return obtenerEpisodioPorNroEpisodioVersionPerfomante(serieId, temporadaNro, episodioNumero);
    }

    public Episodio obtenerEpisodioPorNroEpisodioVersionPesada(ObjectId serieId, Integer temporadaNro,
            Integer episodioNumero) {

        Episodio episodio = serieRepo.findBy_id(serieId).getTemporadas().stream()
                .filter(t -> t.getNumero() == temporadaNro).findFirst().get().getEpisodios().stream()
                .filter(e -> e.getNumero() == episodioNumero).findFirst().get();

        return episodio;
    }

    public Episodio obtenerEpisodioPorNroEpisodioVersionPerfomante(ObjectId serieId, Integer temporadaNro,
            Integer episodioNumero) {

        // Pipelines
        // Stage1: filtro por la serie especifica
        MatchOperation matchSerieStage = Aggregation.match(new Criteria("_id").is(serieId));

        // Stage2: Proyectar solo temporadas
        ProjectionOperation projectTemporadaStage = Aggregation.project("temporadas");

        // Stage3: Unwind temporada (las separa)
        UnwindOperation unwindTemporadaStage = Aggregation.unwind("temporadas");

        // Stage4: Match temporada(filtra de las separadas)
        MatchOperation matchTemporadaStage = Aggregation.match(new Criteria("temporadas.numero").is(temporadaNro));

        // Stage5: Reemplaza la raiz para que tome ahora el de documentos
        ReplaceRootOperation replaceRootTemporadaStage = Aggregation.replaceRoot("temporadas");

        // Stage6: Unwind episodios (separa los episodios)
        UnwindOperation unwindEpisodiosStage = Aggregation.unwind("episodios");

        // Stage7: Reemplaza la raiz para que tome ahora el de documentos
        ReplaceRootOperation replaceRootEpisodiosStage = Aggregation.replaceRoot("episodios");
        // Stage8: Match episodio(filtra de los separados)
        MatchOperation matchEpisodioStage = Aggregation.match(new Criteria("numero").is(episodioNumero));

        Aggregation aggregation = Aggregation.newAggregation(matchSerieStage, projectTemporadaStage,
                unwindTemporadaStage, matchTemporadaStage, replaceRootTemporadaStage, unwindEpisodiosStage,
                replaceRootEpisodiosStage, matchEpisodioStage);

        AggregationResults<Episodio> result = mongoTemplate.aggregate(aggregation, "series", Episodio.class);

        Episodio episodio = result.getUniqueMappedResult();
        return episodio;

    }

    public Serie modificarSerie(Serie serie, SerieModificacionRequest modifSerie) {

        serie.setTitulo(modifSerie.titulo);
        serie.setGeneros(modifSerie.generos);
        serie.setActores(modifSerie.actores);
        serie.setDirectores(modifSerie.directores);
        serie.setTemporadas(modifSerie.temporadas);

        boolean serieModificada = this.crearNuevaSerie(serie);
        if (serieModificada) {
            return serie;
        } else {
            return null;
        }

    }

}
