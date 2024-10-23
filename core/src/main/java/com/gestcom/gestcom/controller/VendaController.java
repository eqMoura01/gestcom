package com.gestcom.gestcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestcom.gestcom.dto.VendaDTO;
import com.gestcom.gestcom.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaDTO> save(@RequestBody VendaDTO vendaDTO) {
        return ResponseEntity.ok(vendaService.save(vendaDTO));
    }

    // @PostMapping
    // public ResponseEntity<ProdutoVendaDTO> save(@RequestBody ProdutoVendaDTO
    // produtoVendaDTO) {
    // return ResponseEntity.ok(produtoVendaService.save(produtoVendaDTO));
    // }

    // @GetMapping
    // public ResponseEntity<List<ProdutoVendaDTO>> findAll() {
    // return ResponseEntity.ok(produtoVendaService.findAll());
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<ProdutoVendaDTO> findById(@PathVariable Long id) {
    // return ResponseEntity.ok(produtoVendaService.findById(id));
    // }

    // @PutMapping
    // public ResponseEntity<ProdutoVendaDTO> update(@RequestBody ProdutoVendaDTO
    // produtoVendaDTO) {
    // return ResponseEntity.ok(produtoVendaService.update(produtoVendaDTO));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    // produtoVendaService.deleteById(id);
    // return ResponseEntity.noContent().build();
    // }
}
