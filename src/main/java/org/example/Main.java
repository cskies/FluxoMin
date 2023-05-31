package org.example;

import org.example.Transacao;
import org.example.service.FluxoDeCaixaServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

            FluxoDeCaixaServiceImpl fluxoDeCaixaService = new FluxoDeCaixaServiceImpl(connection);

            FluxoDeCaixaView
                    fluxoDeCaixaView = new FluxoDeCaixaView(fluxoDeCaixaService);

            fluxoDeCaixaService.adicionarTransacao("Venda de produto A", 1000);
            fluxoDeCaixaService.adicionarTransacao("Pagamento de fornecedor", -500);
            fluxoDeCaixaService.adicionarTransacao("Venda de produto B", 800);

            LocalDate hoje = LocalDate.now();

            List<Transacao> transacoesDoDia = fluxoDeCaixaService.getTransacoesDoDia(hoje);
            double saldoDoDia = fluxoDeCaixaService.calcularSaldoDoDia(hoje);

            fluxoDeCaixaView.exibirTransacoesDoDia(transacoesDoDia);
            fluxoDeCaixaView.exibirSaldoDoDia(saldoDoDia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
