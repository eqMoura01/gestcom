package com.gestcom.gestcom.utils;

import java.util.List;
import java.util.ArrayList;

import com.gestcom.gestcom.dto.ProdutoVendaDTO;
import com.gestcom.gestcom.model.ProdutoVenda;

public class ProdutoVendaMapper {

    public static ProdutoVendaDTO toProdutoVendaDTO(ProdutoVenda produtoVenda) {
        ProdutoVendaDTO produtoVendaDTO = new ProdutoVendaDTO(produtoVenda.getId(),
                ProdutoMapper.toProdutoDTO(produtoVenda.getProduto()), produtoVenda.getQuantidade(),
                produtoVenda.getValorUnitario(), produtoVenda.getValorTotal());

        return produtoVendaDTO;
    }

    public static ProdutoVenda toProdutoVenda(ProdutoVendaDTO produtoVendaDTO) {
        ProdutoVenda produtoVenda = new ProdutoVenda(produtoVendaDTO.getId(),
                ProdutoMapper.toProduto(produtoVendaDTO.getProdutos()), produtoVendaDTO.getQuantidade(),
                produtoVendaDTO.getValorUnitario(), produtoVendaDTO.getValorTotal());

        return produtoVenda;
    }

    public static List<ProdutoVendaDTO> toProdutoVendaDTOs(List<ProdutoVenda> produtoVendas) {
        List<ProdutoVendaDTO> produtoVendaDTOs = new ArrayList<>();

        for (ProdutoVenda produtoVenda : produtoVendas) {
            produtoVendaDTOs.add(toProdutoVendaDTO(produtoVenda));
        }

        return produtoVendaDTOs;
    }
}
