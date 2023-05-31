package org.example;

import java.util.List;

class FluxoDeCaixaView {
    public void exibirTransacoesDoDia(List<Transacao> transacoesDoDia) {
        System.out.println("Transações do dia:");
        for (Transacao transacao : transacoesDoDia) {
            System.out.println(transacao.getDescricao() + " - R$ " + transacao.getValor());
        }
    }

    public void exibirSaldoDoDia(double saldoDoDia) {
        System.out.println("Saldo do dia: R$ " + saldoDoDia);
    }
}
