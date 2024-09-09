package com.gestcom.gestcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestcom.gestcom.dto.ProdutoDTO;
import com.gestcom.gestcom.model.Produto;
import com.gestcom.gestcom.repository.ProdutoRepository;
import com.gestcom.gestcom.utils.ProdutoMapper;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        return ProdutoMapper.toProdutoDTO(produtoRepository.save(ProdutoMapper.toProduto(produtoDTO)));
    }

}
