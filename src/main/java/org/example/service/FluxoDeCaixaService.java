package org.example.service;

import org.example.Transacao;

import java.time.LocalDate;
import java.util.List;

interface FluxoDeCaixaService {
    void adicionarTransacao(String descricao, double valor);
    List<Transacao> getTransacoesDoDia(LocalDate data);
    double calcularSaldoDoDia(LocalDate data);
}