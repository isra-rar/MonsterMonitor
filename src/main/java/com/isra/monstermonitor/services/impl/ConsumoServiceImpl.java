package com.isra.monstermonitor.services.impl;

import com.isra.monstermonitor.entities.Consumo;
import com.isra.monstermonitor.entities.Pessoa;
import com.isra.monstermonitor.repositories.ConsumoRepository;
import com.isra.monstermonitor.services.ConsumoService;
import com.isra.monstermonitor.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumoServiceImpl implements ConsumoService {

    private final ConsumoRepository consumoRepository;
    private final PessoaService pessoaService;

    @Override
    public void adicionarConsumo(Long pessoaId) {
        Pessoa pessoa = pessoaService.getPessoaById(pessoaId).get();
        Consumo consumo = new Consumo(pessoa);
        pessoaService.atualizarConsumo(pessoa.getId());
        consumoRepository.save(consumo);

    }

    @Override
    public Integer getConsumoToday(Long pessoaId) {
        return consumoRepository.countConsumoByCreatedAtDate(pessoaId);
    }

    @Override
    public Integer getAllConsumo(Long pessoaId) {
        return consumoRepository.countAllConsumo(pessoaId);
    }
}
