package com.gestcom.gestcom.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoVendaDTO {
    
    private Long id;
    
    private List<ProdutoDTO> produtos;
    
    private Integer quantidade;
    
    private Double valorUnitario;
    
    private Double valorTotal;

    public Double getValorTotal() {
        return valorUnitario * quantidade;
    }
}
