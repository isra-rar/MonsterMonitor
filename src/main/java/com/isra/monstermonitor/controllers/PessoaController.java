package com.isra.monstermonitor.controllers;

import com.isra.monstermonitor.DTO.PessoaDTORequest;
import com.isra.monstermonitor.DTO.PessoaDTOResponse;
import com.isra.monstermonitor.entities.Pessoa;
import com.isra.monstermonitor.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/pessoa")
@RequiredArgsConstructor
public class PessoaController {


    private final PessoaService pessoaService;

    @GetMapping("/{pessoaId}")
    private ResponseEntity<Optional<Pessoa>> getChurch(@PathVariable long pessoaId) {
        return ResponseEntity.ok(pessoaService.getPessoaById(pessoaId));
    }

    @PostMapping
    public ResponseEntity<PessoaDTOResponse> insertPerson(@RequestBody PessoaDTORequest pessoaRequest) {
        PessoaDTOResponse person = pessoaService.adicionarPessoa(pessoaRequest);
        return ResponseEntity
                .created(URI.create("/" + person.getId()))
                .body(person);
    }
}
