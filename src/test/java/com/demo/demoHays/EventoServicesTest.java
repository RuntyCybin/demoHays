package com.demo.demoHays;

import com.demo.demoHays.model.Evento;
import com.demo.demoHays.model.Fuente;
import com.demo.demoHays.repository.EventoRepository;
import com.demo.demoHays.repository.FuenteRepository;
import com.demo.demoHays.service.EventoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventoServicesTest {

    @Mock
    EventoRepository eventoRepository;

    @Mock
    FuenteRepository fuenteRepository;

    @InjectMocks
    EventoService eventoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void buscarEventoPorNombreTest() {
        List<Evento> eventosBuscado = Arrays.asList(new Evento(1L,new Fuente(1L, "fuente1"), LocalDate.now(), 12));
        List<Evento> eventos = generarEventos();
        List<Fuente> fuentes = generarFuentes();

        when(eventoRepository.findAll())
                .thenReturn(eventos);
        when(fuenteRepository.findAll())
                .thenReturn(fuentes);
        when(eventoService.buscarEventoPorNombre("fuente1"))
                .thenReturn(eventosBuscado);

        // test
        List<Evento> eventoResult = eventoService.buscarEventoPorNombre("fuente1");

        assertTrue(eventoResult.size() == 1);
    }

    @Test
    public void buscarEventosEntreFechasTest() {
        LocalDate date = LocalDate.now();
        when(eventoService.buscarEventosEntreFechas(
                date.minusDays(1),
                date.plusDays(1)))
                .thenReturn(
                        Arrays.asList(new Evento(
                                1L,
                                new Fuente(1L, "fuente1"),
                                date,
                                12)));

        List<Evento> eventos = eventoService.buscarEventosEntreFechas(
                date.minusDays(1),
                date.plusDays(1));

        assertTrue(eventos.size() == 1);
    }

    @Test
    public void buscarEventosEntreValoresTest() {
        LocalDate date = LocalDate.now();
        when(eventoService.buscarEventosEntreValores(2, 6))
                .thenReturn(
                        Arrays.asList(new Evento(
                                1L,
                                new Fuente(1L, "fuente1"),
                                date,
                                4)));
        List<Evento> eventos = eventoService.buscarEventosEntreValores(2, 6);

        assertTrue(eventos.size() == 1);
    }

    private List<Evento> generarEventos() {
        LocalDate date = LocalDate.now();
        return Arrays.asList(
                new Evento(1L,
                        new Fuente(1L, "fuente1"),
                        date.minusDays(2),
                        12),
                new Evento(1L,
                        new Fuente(2L, "fuente2"),
                        LocalDate.now(),
                        12),
                new Evento(2L,
                        new Fuente(3L, "fuente3"),
                        date.plusDays(2),
                        15)
        );
    }

    private List<Fuente> generarFuentes() {
        return Arrays.asList(
                new Fuente(1L, "fuente1"),
                new Fuente(2L, "fuente2")
        );
    }
}
