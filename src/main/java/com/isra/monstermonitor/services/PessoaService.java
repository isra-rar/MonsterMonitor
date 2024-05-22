package com.isra.monstermonitor.services;

import com.isra.monstermonitor.DTO.PessoaDTORequest;
import com.isra.monstermonitor.DTO.PessoaDTOResponse;
import com.isra.monstermonitor.entities.Pessoa;

import java.util.Optional;

public interface PessoaService {

    PessoaDTOResponse adicionarPessoa(PessoaDTORequest request);
    void atualizarConsumo(Long pessoaId);
    Optional<Pessoa> getPessoaById(Long pessoaId);

}
