package com.gestcom.gestcom.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.gestcom.gestcom.model.ItemVenda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {

    private Long id;

    private LocalDateTime dataVenda;

    private List<ItemVenda> itens;

    private Double total;
    
}
