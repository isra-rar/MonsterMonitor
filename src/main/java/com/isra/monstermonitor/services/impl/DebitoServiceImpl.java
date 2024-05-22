package com.isra.monstermonitor.services.impl;

import com.isra.monstermonitor.DTO.DebitoDTORequest;
import com.isra.monstermonitor.DTO.DebitoDTOResponse;
import com.isra.monstermonitor.controllers.exceptions.AdicionarConsumoDebitoPagoExpection;
import com.isra.monstermonitor.entities.Debito;
import com.isra.monstermonitor.entities.Pessoa;
import com.isra.monstermonitor.repositories.DebitoRepository;
import com.isra.monstermonitor.services.DebitoService;
import com.isra.monstermonitor.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DebitoServiceImpl implements DebitoService {

    private final DebitoRepository debitoRepository;
    private final PessoaService pessoaService;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Debito> getDebitoById(Long debitoId) {
        return Optional.ofNullable(debitoRepository.findById(debitoId))
                .orElseThrow(() -> new IllegalArgumentException("Debito não encontrado com o ID: " + debitoId));
    }

    @Override
    public DebitoDTOResponse criarDebito(DebitoDTORequest request) {
        Pessoa devedor = pessoaService.getPessoaById(request.getDevedorId()).get();
        Pessoa recebedor = pessoaService.getPessoaById(request.getRecebedorId()).get();
        Debito debito = new Debito(devedor, recebedor);
        debitoRepository.save(debito);
        return modelMapper.map(debito, DebitoDTOResponse.class);
    }

    @Override
    public void adicionarDebito(Long debitoId) throws AdicionarConsumoDebitoPagoExpection {
        Debito debito = getDebitoById(debitoId).get();
        debito.addQuantidade();
        debitoRepository.save(debito);
    }

    @Override
    public void pagarDebito(Long debitoId) {
        Debito debito = getDebitoById(debitoId).get();
        debito.pagarDebito();
        debitoRepository.save(debito);
    }
}
