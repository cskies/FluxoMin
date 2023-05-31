package org.example.service;

import org.example.Transacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FluxoDeCaixaServiceImpl implements FluxoDeCaixaService {

    private Connection connection;

    private List<Transacao> transacoes;

    public FluxoDeCaixaServiceImpl(Connection connection) {
        this.connection = connection;
        this.transacoes = new ArrayList<>(); // Inicializa a lista de transações
    }

    public FluxoDeCaixaServiceImpl() {

    }


    @Override
    public void adicionarTransacao(String descricao, double valor) {
        LocalDate data = LocalDate.now();
        Transacao transacao = new Transacao(descricao, valor, data);
        transacoes.add(transacao);
    }

    @Override
    public List<Transacao> getTransacoesDoDia(LocalDate data) {
        List<Transacao> transacoesDoDia = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getData().equals(data)) {
                transacoesDoDia.add(transacao);
            }
        }
        return transacoesDoDia;
    }

    @Override
    public double calcularSaldoDoDia(LocalDate data) {
        double saldo = 0;
        for (Transacao transacao : transacoes) {
            if (transacao.getData().equals(data)) {
                saldo += transacao.getValor();
            }
        }
        return saldo;
    }
}
