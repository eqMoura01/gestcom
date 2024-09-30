package com.gestcom.gestcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestcom.gestcom.model.ProdutoVenda;

@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {
    
}
