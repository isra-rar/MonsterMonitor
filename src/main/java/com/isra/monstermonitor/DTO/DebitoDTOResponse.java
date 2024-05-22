package com.isra.monstermonitor.DTO;

import com.isra.monstermonitor.entities.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DebitoDTOResponse {

    private Long id;

    private PessoaDTODebitoResponse devedor;

    private PessoaDTODebitoResponse recebedor;

    private int quantidade;

    private BigDecimal valorSerPago;

    private boolean pago;

    private LocalDateTime updatedAt;
}
