package com.gestcom.gestcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
