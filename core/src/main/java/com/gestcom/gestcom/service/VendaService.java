package com.gestcom.gestcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestcom.gestcom.dto.VendaDTO;
import com.gestcom.gestcom.model.ItemVenda;
import com.gestcom.gestcom.model.Produto;
import com.gestcom.gestcom.repository.VendaRepository;
import com.gestcom.gestcom.utils.ProdutoMapper;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    ProdutoService produtoService;

    public VendaDTO save(VendaDTO vendaDTO) {

        Double totalVenda = 0.0;

        for (ItemVenda item : vendaDTO.getItens()) {
            Produto produto = ProdutoMapper.toProduto(produtoService.findById(item.getProduto().getId()));
            item.setPrecoUnitario(produto.getPreco());
            item.setTotalByProduto(item.getQuantidade() * item.getPrecoUnitario());
            totalVenda += item.getTotal();
        }

        vendaDTO.setTotal(totalVenda);

        return vendaDTO;
    }
}
