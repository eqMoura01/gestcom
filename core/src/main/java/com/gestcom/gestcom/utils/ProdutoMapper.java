package com.gestcom.gestcom.utils;

import java.util.ArrayList;
import java.util.List;

import com.gestcom.gestcom.dto.ProdutoDTO;
import com.gestcom.gestcom.model.Produto;

public class ProdutoMapper {

    public static Produto toProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getDescricao(),
                produtoDTO.getPreco(), produtoDTO.getQuantidade(),
                CategoriaMapper.toCategoria(produtoDTO.getCategoria()));

        return produto;
    }

    public static ProdutoDTO toProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(),
                produto.getPreco(), produto.getQuantidade(), CategoriaMapper.toCategoriaDTO(produto.getCategoria()));

        return produtoDTO;
    }

    public static List<ProdutoDTO> toProdutosDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtoDTOs = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            produtoDTOs.add(toProdutoDTO(produto));
        }

        return produtoDTOs;
    }

    public static List<Produto> toProdutos(List<ProdutoDTO> produtoDTOs) {
        List<Produto> produtos = new ArrayList<Produto>();

        for (ProdutoDTO produtoDTO : produtoDTOs) {
            produtos.add(toProduto(produtoDTO));
        }

        return produtos;
    }
}
