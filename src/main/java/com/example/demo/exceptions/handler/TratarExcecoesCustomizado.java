package com.example.demo.exceptions.handler;

import com.example.demo.exceptions.ExcecaoOperacaoNaoSuportada;
import com.example.demo.exceptions.RespostaDeExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class TratarExcecoesCustomizado extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public final ResponseEntity<RespostaDeExcecao> tratarExcecoesPadrao(Exception excecao, WebRequest requisicao){
        RespostaDeExcecao resposta = new RespostaDeExcecao(
                new Date(),excecao.getMessage(),requisicao.getDescription(false)
        );
        return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ExcecaoOperacaoNaoSuportada.class})
    public final ResponseEntity<RespostaDeExcecao> tratarExcecaoOperacaoNaoSuportada(Exception excecao, WebRequest requisicao){
        RespostaDeExcecao resposta = new RespostaDeExcecao(
                new Date(),excecao.getMessage(),requisicao.getDescription(false)
        );
        return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
    }

}
