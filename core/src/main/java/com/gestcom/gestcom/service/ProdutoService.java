package com.gestcom.gestcom.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestcom.gestcom.dto.ProdutoDTO;
import com.gestcom.gestcom.model.Produto;
import com.gestcom.gestcom.repository.ProdutoRepository;
import com.gestcom.gestcom.utils.ProdutoMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        return ProdutoMapper.toProdutoDTO(produtoRepository.save(ProdutoMapper.toProduto(produtoDTO)));
    }

    public ProdutoDTO findById(Long id) {
        return ProdutoMapper.toProdutoDTO(produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com id " + id + " não encontrado")));
    }

    public List<ProdutoDTO> findAll() {
        return ProdutoMapper.toProdutoDTOs(produtoRepository.findAll());
    }

    public ProdutoDTO update(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toProduto(findById(produtoDTO.getId()));
        BeanUtils.copyProperties(ProdutoMapper.toProduto(produtoDTO), produto);
        return save(ProdutoMapper.toProdutoDTO(produto));
    }

    public void deleteById(Long id) {
        findById(id);
        produtoRepository.deleteById(id);
    }
}