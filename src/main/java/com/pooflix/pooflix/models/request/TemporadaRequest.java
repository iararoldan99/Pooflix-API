package com.pooflix.pooflix.models.request;

import java.util.ArrayList;
import java.util.List;

import com.pooflix.pooflix.documents.Episodio;
import com.pooflix.pooflix.documents.Websodio;

public class TemporadaRequest {
    public Integer numero;
    public Integer numTotalEpisodios;
    public List<Episodio> episodios = new ArrayList<>();
    public List<Websodio> websodios = new ArrayList<>();
}
