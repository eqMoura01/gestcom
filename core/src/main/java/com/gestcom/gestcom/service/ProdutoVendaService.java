package com.gestcom.gestcom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestcom.gestcom.dto.ProdutoDTO;
import com.gestcom.gestcom.dto.ProdutoVendaDTO;
import com.gestcom.gestcom.model.Produto;
import com.gestcom.gestcom.model.ProdutoVenda;
import com.gestcom.gestcom.repository.ProdutoVendaRepository;
import com.gestcom.gestcom.utils.ProdutoMapper;
import com.gestcom.gestcom.utils.ProdutoVendaMapper;
import com.gestcom.gestcom.utils.ValidaObjetoPresente;

@Service
public class ProdutoVendaService {

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    @Autowired
    private ProdutoService produtoService;

    public ProdutoVendaDTO save(ProdutoVendaDTO produtoVendaDTO) {

        for (ProdutoDTO produtoDTO : produtoVendaDTO.getProdutos()) {
            if (!verificaEstoque(produtoDTO)) {
                throw new RuntimeException(produtoDTO.getNome() + " sem estoque suficiente para venda.");
            }
            ProdutoDTO produto = produtoService.findById(produtoDTO.getId());
            produto.setQuantidade(produto.getQuantidade() - produtoDTO.getQuantidade());
            produtoService.update(produto);
        }

        return ProdutoVendaMapper
                .toProdutoVendaDTO(produtoVendaRepository.save(ProdutoVendaMapper.toProdutoVenda(produtoVendaDTO)));
    }

    public ProdutoVendaDTO findById(Long id) {

        Optional<ProdutoVenda> produtoVenda = produtoVendaRepository.findById(id);

        return ProdutoVendaMapper
                .toProdutoVendaDTO(ValidaObjetoPresente.validaObjetoPresente(produtoVenda, "Produto da Venda"));
    }

    public List<ProdutoVendaDTO> findAll() {
        return ProdutoVendaMapper.toProdutoVendaDTOs(produtoVendaRepository.findAll());
    }

    public ProdutoVendaDTO update(ProdutoVendaDTO produtoVendaDTO) {

        ProdutoVenda produtoVenda = ProdutoVendaMapper.toProdutoVenda(findById(produtoVendaDTO.getId()));

        BeanUtils.copyProperties(produtoVendaDTO, produtoVenda);

        return save(produtoVendaDTO);
    }

    public void deleteById(Long id) {
        produtoVendaRepository.deleteById(id);
    }

    // TODO: Implementar o método que verifica se um Produto ainda tem estoque
    // suficiente para ser vendido.
    // Dica: Utilize o método findById da classe ProdutoService para buscar um
    // Produto pelo id.

    private boolean verificaEstoque(ProdutoDTO produtoDTO) {

        ProdutoDTO produto = produtoService.findById(produtoDTO.getId());

        if (produto.getQuantidade() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
