package com.demo.demoHays.service;

import com.demo.demoHays.model.Evento;
import com.demo.demoHays.model.Fuente;
import com.demo.demoHays.repository.EventoRepository;
import com.demo.demoHays.repository.FuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private FuenteRepository fuenteRepository;

    public List<Evento> buscarEventoPorNombre(String nombre) {
        List<Evento> eventos = eventoRepository.findAll();
        List<Fuente> fuentes = fuenteRepository.findAll();

        return eventoRepository.buscarEventoPorNombre(
                fuentes,
                eventos,
                nombre);
    }

    public List<Evento> buscarEventosEntreFechas(LocalDate fechaIni, LocalDate fechaFin) {
        return eventoRepository.buscarEventoPorFechas(fechaIni, fechaFin);
    }

    public List<Evento> buscarEventosEntreValores(int valMin, int valMax) {
        return eventoRepository.buscarEventoPorValores(valMin, valMax);
    }
}
