// Pacote onde a classe está localizada, ajudando na organização e evitando conflitos de nomes.
package com.github.VitorMarczewski.Exception.Handler;

// Importa a classe Date para registrar o momento em que a exceção ocorreu.
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.VitorMarczewski.Exception.ExceptionResponse;
import com.github.VitorMarczewski.Exception.UnsupportedMathOperationException;

// @ControllerAdvice indica que esta classe fornece tratamento global de exceções para todos os controllers.
@ControllerAdvice

// @RestController combina @Controller e @ResponseBody, permitindo que métodos retornem objetos diretamente como JSON.
@RestController

// Extende ResponseEntityExceptionHandler para aproveitar métodos prontos do Spring
// e personalizar respostas de exceções HTTP de forma padronizada.
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    // ---------------------------------------------
    // Tratamento global de exceções genéricas
    // ---------------------------------------------
    
    // @ExceptionHandler(Exception.class) intercepta todas as exceções do tipo Exception (genéricas)
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
        
        ExceptionResponse response  = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false) // false indica que não incluirá o tipo da requisição
        );

        // Retorna uma resposta HTTP com status 500 INTERNAL_SERVER_ERROR
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ---------------------------------------------
    // Tratamento de exceções específicas
    // ---------------------------------------------
    
    // @ExceptionHandler para tratar a exceção personalizada UnsupportedMathOperationException
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest request){
        
        // Cria o mesmo modelo de ExceptionResponse, com dados da exceção e da requisição
        ExceptionResponse response  = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );

        // Retorna uma resposta HTTP 400 BAD_REQUEST, indicando que a requisição do cliente estava incorreta
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
