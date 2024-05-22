package com.isra.monstermonitor.repositories;

import com.isra.monstermonitor.entities.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {

    @Query( nativeQuery = true, value = "SELECT COUNT(c) FROM Consumo c WHERE DATE(c.created_at) = CURRENT_DATE AND c.pessoa_id = :pessoaId")
    Integer countConsumoByCreatedAtDate(@Param("pessoaId") Long pessoaId);

    @Query( nativeQuery = true, value = "SELECT COUNT(c) FROM Consumo c WHERE c.pessoa_id = :pessoaId")
    Integer countAllConsumo(@Param("pessoaId") Long pessoaId);
}
