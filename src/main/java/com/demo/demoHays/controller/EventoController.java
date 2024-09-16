package com.demo.demoHays.controller;

import com.demo.demoHays.exception.EventoNotFoundException;
import com.demo.demoHays.model.Evento;
import com.demo.demoHays.service.EventoService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/eventosPorNombre")
    public ResponseEntity<List<Evento>> buscarEventosPorNombre(
            @RequestParam @NotNull String nombre
    ) throws EventoNotFoundException {
        List<Evento> eventos = eventoService.buscarEventoPorNombre(nombre);
        if (eventos.size() == 0) {
            throw new EventoNotFoundException("Eventos no encontrado con este nombre");
        }
        return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
    }

    @GetMapping("/eventosPorFechas")
    public ResponseEntity<List<Evento>> buscarEventosPorFechas(
            @RequestParam @NotNull LocalDate fechaIni,
            @RequestParam @NotNull LocalDate fechaFin) throws EventoNotFoundException {

        List<Evento> eventos = eventoService.buscarEventosEntreFechas(
                fechaIni,
                fechaFin);
        if (eventos.size() == 0) {
            throw new EventoNotFoundException("Eventos no encontrado en este rango de fechas");
        }
        return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
    }

    @GetMapping("/eventosPorValores")
    public ResponseEntity<List<Evento>> buscarEventosPorValores(
            @RequestParam
            @Min(value = 0, message = "Valor demasiado perquenio")
            @NotNull Integer valMin,
            @RequestParam
            @Max(value = 25, message = "Valor demasiado alto")
            @NotNull Integer valMax) throws EventoNotFoundException {

        List<Evento> eventos = eventoService.buscarEventosEntreValores(valMin, valMax);
        if (eventos.size() == 0) {
            throw new EventoNotFoundException("Eventos no encontrado en este rango de valores");
        }
        return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
    }

}
