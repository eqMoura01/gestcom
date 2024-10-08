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

import com.gestcom.gestcom.dto.ProdutoDTO;
import com.gestcom.gestcom.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.save(produtoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.update(produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
