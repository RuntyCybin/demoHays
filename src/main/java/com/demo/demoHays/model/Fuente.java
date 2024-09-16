package com.demo.demoHays.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fuente")
public class Fuente {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long fuenteid;
    private String nombre;
}
