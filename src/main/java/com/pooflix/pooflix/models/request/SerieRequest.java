package com.pooflix.pooflix.models.request;

import java.util.ArrayList;
import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.documents.Director;
import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.documents.Temporada;

public class SerieRequest {
    public String titulo;
    public List<Director> directores;
    public List<Genero> generos = new ArrayList<>();
    public List<Actor> actores = new ArrayList<>();
    public List<Temporada> temporadas = new ArrayList<>();

}
