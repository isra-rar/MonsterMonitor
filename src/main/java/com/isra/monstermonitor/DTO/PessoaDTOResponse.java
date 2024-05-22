package com.isra.monstermonitor.DTO;

import com.isra.monstermonitor.entities.Debito;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import java.util.List;

@Getter
@Setter
public class PessoaDTOResponse {

    private Long id;

    private String nome;
    private Integer totalConsumidos;
    private LocalDateTime createdAt;

    private List<Debito> debitos;

}
