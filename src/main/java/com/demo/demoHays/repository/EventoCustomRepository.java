package com.demo.demoHays.repository;

import com.demo.demoHays.model.Evento;
import com.demo.demoHays.model.Fuente;

import java.time.LocalDate;
import java.util.List;

public interface EventoCustomRepository {
    List<Evento> buscarEventoPorNombre(List<Fuente> fuentes, List<Evento> eventos, String nombre);
    List<Evento> buscarEventoPorFechas(LocalDate fechaIni, LocalDate fechaFin);

    List<Evento> buscarEventoPorValores(Integer valMin, Integer valMax);
}
