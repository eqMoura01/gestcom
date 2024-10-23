package com.gestcom.gestcom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    private Double precoUnitario;

    private Double totalByProduto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    // Método auxiliar para calcular o total do item
    public Double getTotal() {
        return this.quantidade * this.precoUnitario;
    }
}
