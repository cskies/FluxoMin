package org.example;

import org.example.service.FluxoDeCaixaServiceImpl;

import java.util.List;

class FluxoDeCaixaView {

    private FluxoDeCaixaServiceImpl fluxoDeCaixaService;

    public FluxoDeCaixaView( ) {
    }

    public FluxoDeCaixaView(FluxoDeCaixaServiceImpl fluxoDeCaixaService) {
        this.fluxoDeCaixaService = fluxoDeCaixaService;
    }
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
