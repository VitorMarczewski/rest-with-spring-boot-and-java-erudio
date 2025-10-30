// Define o pacote da classe. É recomendável manter organizado, por exemplo, controllers separados.
package com.github.VitorMarczewski.Controller;

import java.util.concurrent.atomic.AtomicLong; // Importa AtomicLong, usado para criar um contador thread-safe

import org.springframework.web.bind.annotation.RequestMapping; // Importa anotação para mapear URLs
import org.springframework.web.bind.annotation.RequestParam;   // Importa anotação para parâmetros de requisição
import org.springframework.web.bind.annotation.RestController; // Importa anotação para indicar que esta classe é um REST controller

import com.github.VitorMarczewski.Model.Greeting; // Importa a classe record Greeting que será usada para retorno

// Anotação que indica que esta classe será um controlador REST
// Ele retorna dados diretamente (geralmente JSON), sem precisar de View
@RestController
public class GreetingControllers {

    // Template de string para a saudação, %s será substituído pelo nome do usuário
    private static final String template = "Hello, %s!";

    // Contador thread-safe que será incrementado a cada requisição
    private final AtomicLong counter = new AtomicLong();

    // Mapeia o método para a URL /greeting
    // Pode receber requisições GET ou POST por padrão
    @RequestMapping("/greeting")
    public Greeting greeting(
            // Recebe um parâmetro de query "name", com valor padrão "World" caso não seja enviado
            @RequestParam(value = "name", defaultValue = "World") String name
    ) {
        // Retorna um objeto Greeting com:
        // - id gerado pelo contador
        // - mensagem formatada com o nome informado
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
