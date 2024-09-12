package com.gestcom.gestcom.utils;

import java.util.ArrayList;
import java.util.List;

import com.gestcom.gestcom.dto.CategoriaDTO;
import com.gestcom.gestcom.model.Categoria;

public class CategoriaMapper {

    public static Categoria toCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO.getId(), categoriaDTO.getNome(), categoriaDTO.getDescricao());

        return categoria;
    }

    public static CategoriaDTO toCategoriaDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());

        return categoriaDTO;
    }

    public static List<CategoriaDTO> toCategoriaDTOs(List<Categoria> categorias) {
        List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();

        for (Categoria categoria : categorias) {
            categoriaDTOs.add(toCategoriaDTO(categoria));
        }

        return categoriaDTOs;
    }
}
