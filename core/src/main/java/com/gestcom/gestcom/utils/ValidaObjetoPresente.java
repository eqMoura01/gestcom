package com.gestcom.gestcom.utils;

import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

public abstract class ValidaObjetoPresente {

    public static <T> T validaObjetoPresente(Optional<T> objeto, String entidadeErro) {
        if (!objeto.isPresent()) {
            throw new EntityNotFoundException(String.format("%s não encontrado(a).", entidadeErro));
        }
        return objeto.get();
    }
    
}