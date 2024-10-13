package com.gestcom.gestcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestcom.gestcom.dto.ProdutoVendaDTO;
import com.gestcom.gestcom.service.ProdutoVendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private ProdutoVendaService produtoVendaService;

    @PostMapping
    public ResponseEntity<ProdutoVendaDTO> save(@RequestBody ProdutoVendaDTO produtoVendaDTO) {
        return ResponseEntity.ok(produtoVendaService.save(produtoVendaDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoVendaDTO>> findAll() {
        return ResponseEntity.ok(produtoVendaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoVendaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoVendaService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProdutoVendaDTO> update(@RequestBody ProdutoVendaDTO produtoVendaDTO) {
        return ResponseEntity.ok(produtoVendaService.update(produtoVendaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        produtoVendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
