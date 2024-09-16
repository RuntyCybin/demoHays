package com.demo.demoHays.repository;

import com.demo.demoHays.model.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuenteRepository extends JpaRepository<Fuente, Long> {
}
