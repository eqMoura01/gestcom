package com.gestcom.gestcom.utils;

import com.gestcom.gestcom.dto.ProdutoDTO;
import com.gestcom.gestcom.model.Produto;

public class ProdutoMapper {

    public static Produto toProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getDescricao(),
                produtoDTO.getPreco(), produtoDTO.getQuantidade());

        return produto;
    }

    public static ProdutoDTO toProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(),
                produto.getPreco(), produto.getQuantidade());

        return produtoDTO;
    }
}
