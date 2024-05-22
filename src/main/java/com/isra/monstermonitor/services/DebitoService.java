package com.isra.monstermonitor.services;

import com.isra.monstermonitor.DTO.DebitoDTORequest;
import com.isra.monstermonitor.DTO.DebitoDTOResponse;
import com.isra.monstermonitor.controllers.exceptions.AdicionarConsumoDebitoPagoExpection;
import com.isra.monstermonitor.entities.Debito;

import java.util.Optional;

public interface DebitoService {

    Optional<Debito> getDebitoById(Long debitoId);

    DebitoDTOResponse criarDebito(DebitoDTORequest request);
    void adicionarDebito(Long debitoId) throws AdicionarConsumoDebitoPagoExpection;
    void pagarDebito(Long debitoId);
}
