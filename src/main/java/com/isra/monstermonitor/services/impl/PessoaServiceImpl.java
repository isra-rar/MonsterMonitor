package com.isra.monstermonitor.services.impl;

import com.isra.monstermonitor.DTO.PessoaDTORequest;
import com.isra.monstermonitor.DTO.PessoaDTOResponse;
import com.isra.monstermonitor.entities.Pessoa;
import com.isra.monstermonitor.repositories.PessoaRepository;
import com.isra.monstermonitor.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    @Override
    public PessoaDTOResponse adicionarPessoa(PessoaDTORequest request) {
        Pessoa pessoa = modelMapper.map(request, Pessoa.class);
        pessoaRepository.save(pessoa);
        return modelMapper.map(pessoa, PessoaDTOResponse.class);
    }

    @Override
    public void atualizarConsumo(Long pessoaId) {
        Pessoa pessoa = getPessoaById(pessoaId).get();
        pessoa.addConsumo();
        pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> getPessoaById(Long pessoaId) {
        return Optional.ofNullable(pessoaRepository.findById(pessoaId))
                .orElseThrow(() -> new IllegalArgumentException("User não encontrado com o ID: " + pessoaId));
    }
}
