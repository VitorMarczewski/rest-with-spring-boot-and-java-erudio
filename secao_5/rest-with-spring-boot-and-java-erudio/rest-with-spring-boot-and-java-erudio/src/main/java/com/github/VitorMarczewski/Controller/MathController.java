package com.github.VitorMarczewski.Controller;
import com.github.VitorMarczewski.Math.SimpleMath;
import com.github.VitorMarczewski.Converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.VitorMarczewski.Exception.UnsupportedMathOperationException;

@RestController //informa que a classe é um controller rest
@RequestMapping("/math") //informa que a classe vai operar em cima dessa url
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public double sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
       if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }


    @RequestMapping("subtraction/{numberOne}/{numberTwo}")
    public double subtraction(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        return math.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("multiplication/{numberOne}/{numberTwo}")
    public double multiplication(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
         if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        return math.multiplication(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("division/{numberOne}/{numberTwo}")
    public double division(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        if(NumberConverter.convertToDouble(numberTwo) == 0) throw new UnsupportedMathOperationException("Please, the divisor must not be 0");
        return math.division(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }
    
    @RequestMapping("average/{numberOne}/{numberTwo}")
    public double average(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        return math.average(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }
    
    @RequestMapping("squareroot/{numberOne}")
    public double squareroot(
        @PathVariable("numberOne") String numberOne  
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        return math.squareroot(NumberConverter.convertToDouble(numberOne));
    }

}
