package com.example.demo.controllers;

import com.example.demo.model.Saudacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaudacaoController {

    private static final String saudacaoTemplate = "Olá,  %s!";
    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/saudacao")
    public Saudacao saudacao(@RequestParam(value = "nome", defaultValue = "Mundo") String nome){
        return new Saudacao(contador.incrementAndGet(), String.format(saudacaoTemplate, nome));
    }

}
