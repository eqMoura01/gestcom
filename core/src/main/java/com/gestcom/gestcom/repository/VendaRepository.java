package com.gestcom.gestcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestcom.gestcom.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    
}
