package com.demo.demoHays.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idfuente")
    private Fuente idfuente;
    private LocalDate timestamp;
    private Integer valor;


}
