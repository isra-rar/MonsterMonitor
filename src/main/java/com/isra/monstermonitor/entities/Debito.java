package com.isra.monstermonitor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "devedor_id", nullable = false)
    private Pessoa devedor;

    @ManyToOne
    @JoinColumn(name = "recebedor_id", nullable = false)
    private Pessoa recebedor;

    @Column(nullable = false)
    private int quantidade = 0;

    @Column(nullable = false)
    private BigDecimal valorSerPago = BigDecimal.valueOf(0);

    private boolean pago = false;
}
