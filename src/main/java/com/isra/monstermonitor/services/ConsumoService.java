package com.isra.monstermonitor.services;

public interface ConsumoService {

    void adicionarConsumo(Long pessoaId);
    Integer getConsumoToday(Long pessoaId);
    Integer getAllConsumo(Long pessoaId);
}
