package com.gestcom.gestcom.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestcom.gestcom.dto.CategoriaDTO;
import com.gestcom.gestcom.model.Categoria;
import com.gestcom.gestcom.repository.CategoriaRepository;
import com.gestcom.gestcom.utils.CategoriaMapper;
import com.gestcom.gestcom.utils.ValidaObjetoPresente;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        return CategoriaMapper.toCategoriaDTO(categoriaRepository.save(CategoriaMapper.toCategoria(categoriaDTO)));
    }

    public CategoriaDTO findById(Long id) {

        return CategoriaMapper
                .toCategoriaDTO(ValidaObjetoPresente.validaObjetoPresente(categoriaRepository.findById(id),
                        "Categoria"));
    }

    public List<CategoriaDTO> findAll() {
        return CategoriaMapper.toCategoriaDTOs(categoriaRepository.findAll());
    }

    public CategoriaDTO update(CategoriaDTO categoriaDTO) {

        Categoria categoria = CategoriaMapper.toCategoria(findById(categoriaDTO.getId()));

        BeanUtils.copyProperties(CategoriaMapper.toCategoria(categoriaDTO), categoria);

        return save(CategoriaMapper.toCategoriaDTO(categoria));
    }

    public void deleteById(Long id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }
}
