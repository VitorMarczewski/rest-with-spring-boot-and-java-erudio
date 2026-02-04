package com.example.demo.controllers;

import com.example.demo.exceptions.ExcecaoOperacaoNaoSuportada;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calcular")
public class CalcularController {

    @GetMapping("/somar/{num1}/{num2}")
    public double somar(@PathVariable(name = "num1") String num1,
                        @PathVariable(name = "num2") String num2){
        if(!valorNumerico(num1) || !valorNumerico(num2)) throw new ExcecaoOperacaoNaoSuportada("Argumentos devem ser numéricos");

        return converterParaDouble(num1)+converterParaDouble(num2);
    }

    @GetMapping("/subtrair/{num1}/{num2}")
    public double subtrair(@PathVariable(name = "num1") String num1,
                           @PathVariable(name= "num2") String num2){
        if(!valorNumerico(num1) || !valorNumerico(num2)) throw new ExcecaoOperacaoNaoSuportada("Argumentos devem ser numéricos");
        return converterParaDouble(num1)-converterParaDouble(num2);
    }

    @GetMapping("/multiplicar/{num1}/{num2}")
    public double multiplicar(@PathVariable(name = "num1") String num1,
                              @PathVariable(name="num2")  String num2){
        if(!valorNumerico(num1) || !valorNumerico(num2)) throw new ExcecaoOperacaoNaoSuportada("Argumentos devem ser numéricos");
        return converterParaDouble(num1)*converterParaDouble(num2);
    }

    @GetMapping("/dividir/{num1}/{num2}")
    public double dividir(@PathVariable(name = "num1") String num1, @PathVariable(name = "num2") String num2){
        if(!valorNumerico(num1) || !valorNumerico(num2)) throw new ExcecaoOperacaoNaoSuportada("Argumentos devem ser numéricos");
        if(converterParaDouble(num2) == 0) throw new ExcecaoOperacaoNaoSuportada("Não é possivel dividir por zero");
        return converterParaDouble(num1)/converterParaDouble(num2);
    }


    private double converterParaDouble(String num) throws ExcecaoOperacaoNaoSuportada{
        if(num == null || num.isEmpty()) throw new ExcecaoOperacaoNaoSuportada("Argumento não pode ser nulo ou vazio");
        String strNum = num.replaceAll(",", ".");
        return Double.parseDouble(strNum);
    }

    private boolean valorNumerico(String num) {
        if(num == null || num.isEmpty()) return false;
        String strNum = num.replaceAll(",", ".");
        return strNum.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

}
