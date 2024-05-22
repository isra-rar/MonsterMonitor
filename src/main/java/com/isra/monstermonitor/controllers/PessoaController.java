package com.isra.monstermonitor.controllers;

import com.isra.monstermonitor.DTO.PessoaDTORequest;
import com.isra.monstermonitor.DTO.PessoaDTOResponse;
import com.isra.monstermonitor.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "api/pessoa")
@RequiredArgsConstructor
public class PessoaController {


    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTOResponse> insertPerson(@RequestBody PessoaDTORequest pessoaRequest) {
        PessoaDTOResponse person = pessoaService.adicionarPessoa(pessoaRequest);
        return ResponseEntity
                .created(URI.create("/" + person.getId()))
                .body(person);
    }
}
