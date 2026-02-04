package com.example.demo.exceptions;

import java.util.Date;

public record RespostaDeExcecao(Date dataInicio, String mensagem, String detalhe) {
}
