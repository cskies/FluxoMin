package org.example;

import java.time.LocalDate;

public class Transacao {
    private String descricao;
    private double valor;
    private LocalDate data;

    public Transacao(String descricao, double valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}