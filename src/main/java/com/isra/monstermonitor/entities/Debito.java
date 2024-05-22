package com.isra.monstermonitor.entities;

import com.isra.monstermonitor.controllers.exceptions.AdicionarConsumoDebitoPagoExpection;
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
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Debito {

    public Debito(Pessoa devedor, Pessoa recebedor) {
        this.devedor = devedor;
        this.recebedor = recebedor;
    }

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
    private BigDecimal valorSerPago = BigDecimal.ZERO;

    private boolean pago = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    public void addQuantidade() throws AdicionarConsumoDebitoPagoExpection {
        if (!this.pago){
            this.quantidade++;
            this.atualizarValorASerPago();
            this.updatedAt = LocalDateTime.now();
        } else {
            throw new AdicionarConsumoDebitoPagoExpection("Debito já consta como PAGO");
        }
    }

    private void atualizarValorASerPago() {
        this.valorSerPago = valorSerPago.add(BigDecimal.TEN);
    }

    public void pagarDebito(){
        this.pago = true;
        this.updatedAt = LocalDateTime.now();
    }

}
