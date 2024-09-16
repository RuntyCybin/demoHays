package com.demo.demoHays.repository;

import com.demo.demoHays.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>, EventoCustomRepository {
}
