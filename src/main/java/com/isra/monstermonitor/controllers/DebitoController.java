package com.isra.monstermonitor.controllers;


import com.isra.monstermonitor.DTO.DebitoDTORequest;
import com.isra.monstermonitor.DTO.DebitoDTOResponse;
import com.isra.monstermonitor.controllers.exceptions.AdicionarConsumoDebitoPagoExpection;
import com.isra.monstermonitor.entities.Debito;
import com.isra.monstermonitor.entities.Pessoa;
import com.isra.monstermonitor.services.DebitoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/debito")
@RequiredArgsConstructor
public class DebitoController {

    private final DebitoService debitoService;
    private final ModelMapper modelMapper;

    @GetMapping("/{debitoId}")
    private ResponseEntity<DebitoDTOResponse> getDebitoById(@PathVariable long debitoId) {
        Debito debito = debitoService.getDebitoById(debitoId).get();
        return ResponseEntity.ok(modelMapper.map(debito, DebitoDTOResponse.class));
    }

    @PostMapping
    public ResponseEntity<DebitoDTOResponse> criarDebito(@RequestBody DebitoDTORequest debitoDTORequest) {
        DebitoDTOResponse debito = debitoService.criarDebito(debitoDTORequest);
        return ResponseEntity
                .created(URI.create("/" + debito.getId()))
                .body(debito);
    }

    @PatchMapping("/add/{debitoId}")
    public ResponseEntity adicionarDebito(@PathVariable Long debitoId) throws AdicionarConsumoDebitoPagoExpection {
        debitoService.adicionarDebito(debitoId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/pagar/{debitoId}")
    public ResponseEntity pagarDebito(@PathVariable Long debitoId) {
        debitoService.pagarDebito(debitoId);
        return ResponseEntity.noContent().build();
    }
}
