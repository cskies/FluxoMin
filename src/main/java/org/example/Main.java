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

            FluxoDeCaixaServiceImpl instance = FluxoDeCaixaServiceImpl.getInstance(connection);

//            FluxoDeCaixaServiceImpl fluxoDeCaixaService = new FluxoDeCaixaServiceImpl(connection);

            FluxoDeCaixaView
                    fluxoDeCaixaView = new FluxoDeCaixaView();

            instance.adicionarTransacao("Venda de produto A", 1000);
            instance.adicionarTransacao("Pagamento de fornecedor", -500);
            instance.adicionarTransacao("Venda de produto B", 800);

            LocalDate hoje = LocalDate.now();

            List<Transacao> transacoesDoDia = instance.getTransacoesDoDia(hoje);
            double saldoDoDia = instance.calcularSaldoDoDia(hoje);

            fluxoDeCaixaView.exibirTransacoesDoDia(transacoesDoDia);
            fluxoDeCaixaView.exibirSaldoDoDia(saldoDoDia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
