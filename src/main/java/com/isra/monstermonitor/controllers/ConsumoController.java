package com.isra.monstermonitor.controllers;


import com.isra.monstermonitor.services.ConsumoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/consumo")
@RequiredArgsConstructor
public class ConsumoController {

    private final ConsumoService consumoService;

    @PostMapping("/{pessoaId}")
    public ResponseEntity adicionarConsumo(@PathVariable Long pessoaId) {
        consumoService.adicionarConsumo(pessoaId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/today/{pessoaId}")
    public ResponseEntity<Integer> getConsumoToday(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(consumoService.getConsumoToday(pessoaId));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<Integer> getAllConsumo(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(consumoService.getAllConsumo(pessoaId));
    }
}
