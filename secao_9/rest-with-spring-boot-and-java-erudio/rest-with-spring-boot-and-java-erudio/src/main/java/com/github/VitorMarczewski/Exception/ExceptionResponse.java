
package com.github.VitorMarczewski.Exception;

import java.util.Date;

// Um record automaticamente gera:
//  - Construtor que recebe todos os campos
//  - Getters (nomes iguais aos campos)
//  - equals(), hashCode() e toString() prontos
// Aqui, usamos para criar uma **estrutura de resposta de erro** consistente.
public record ExceptionResponse( Date timestamp,String message,String details) {
    // Note que não é necessário criar construtor ou getters manualmente.
    // O Java gera automaticamente o construtor e métodos de acesso para cada campo do record.
    // Exemplo de uso:
    // ExceptionResponse response = new ExceptionResponse(new Date(), "Erro de validação", "/api/clientes/123");
}
