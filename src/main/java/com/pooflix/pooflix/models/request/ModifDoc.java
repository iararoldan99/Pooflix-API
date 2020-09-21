package com.pooflix.pooflix.models.request;

import java.util.ArrayList;
import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.documents.Director;
import com.pooflix.pooflix.documents.Genero;

public class ModifDoc {
    public String titulo;
    public List<Director> directores;
    public List<Genero> generos = new ArrayList<>();
    public List<Actor> actores = new ArrayList<>();
}
