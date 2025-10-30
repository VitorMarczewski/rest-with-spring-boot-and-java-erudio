
package com.github.VitorMarczewski.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anotação do Spring que associa esta exceção a um código HTTP específico.
// Aqui, sempre que essa exceção for lançada, a resposta HTTP será 400 BAD_REQUEST.
// Isso é útil em APIs REST para informar que houve um erro na requisição do cliente.
@ResponseStatus(HttpStatus.BAD_REQUEST)


// Ela estende RuntimeException, portanto é uma exceção não verificada (unchecked exception).
// Exceções não verificadas não precisam ser declaradas no método com throws.
public class UnsupportedMathOperationException extends RuntimeException {

    // Quando criamos uma instância desta exceção, podemos passar uma string explicando o motivo do erro.
    public UnsupportedMathOperationException(String message){
        
        // Chama o construtor da superclasse RuntimeException passando a mensagem.
        // Isso garante que a mensagem seja armazenada corretamente e possa ser recuperada posteriormente
        // com métodos como getMessage().
        super(message);
    }

    // Observações importantes:
    // 1. Como essa exceção é anotada com @ResponseStatus, quando lançada em um controller Spring,
    //    o framework automaticamente converte em uma resposta HTTP 400, sem necessidade de tratamento explícito.
    // 2. Por ser RuntimeException, não é obrigatório capturá-la com try/catch.
    // 3. Essa classe é útil para APIs REST que precisam sinalizar erros específicos de forma clara
    //    para o cliente, permitindo também mensagens descritivas.
    // 4. Podemos criar outros construtores ou métodos auxiliares, se precisarmos, como por exemplo
    //    receber a causa da exceção (Throwable) para encadeamento de erros.
}
