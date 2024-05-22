package com.isra.monstermonitor.repositories;

import com.isra.monstermonitor.entities.Debito;
import com.isra.monstermonitor.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitoRepository extends JpaRepository<Debito, Long> {
}
