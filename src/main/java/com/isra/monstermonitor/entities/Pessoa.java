package com.isra.monstermonitor.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer totalConsumidos = 0;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany
    private List<Debito> debitos = new ArrayList<>();

    public void addConsumo() {
        this.totalConsumidos++;
        this.updatedAt = LocalDateTime.now();
    }
}
