package com.demo.demoHays.repository.impl;

import com.demo.demoHays.model.Evento;
import com.demo.demoHays.model.Fuente;
import com.demo.demoHays.repository.EventoCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EventoCustomRepositoryImpl implements EventoCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Evento> buscarEventoPorNombre(
            List<Fuente> fuentes,
            List<Evento> eventos,
            String nombre) {

        return eventos.stream()
                .filter(evento -> fuentes.stream()
                        .anyMatch(fuente -> fuente.getNombre()
                                .contains(nombre) && evento.getIdfuente().getFuenteid() == fuente.getFuenteid()))
                .toList();
    }

    @Override
    public List buscarEventoPorFechas(LocalDate fechaIni, LocalDate fechaFin) {

        return entityManager.createQuery("FROM Evento AS e WHERE e.timestamp BETWEEN :ini AND :fin")
                .setParameter("ini", fechaIni)
                .setParameter("fin", fechaFin)
                .getResultList();
    }

    @Override
    public List<Evento> buscarEventoPorValores(Integer valMin, Integer valMax) {
        return entityManager.createQuery("FROM Evento AS e WHERE e.valor > :min AND e.valor < :max")
                .setParameter("min", valMin)
                .setParameter("max", valMax)
                .getResultList();
    }
}
