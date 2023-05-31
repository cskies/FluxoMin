package org.example;

import org.example.service.FluxoDeCaixaServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sql/create_table_transacao.sql");

            String sql = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();

            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }



        FluxoDeCaixaServiceImpl fluxoDeCaixaService = new FluxoDeCaixaServiceImpl();
        fluxoDeCaixaService.adicionarTransacao("Venda de produto A", 1000);
        fluxoDeCaixaService.adicionarTransacao("Pagamento de fornecedor", -500);
        fluxoDeCaixaService.adicionarTransacao("Venda de produto B", 800);

        LocalDate hoje = LocalDate.now();

        List<Transacao> transacoesDoDia = fluxoDeCaixaService.getTransacoesDoDia(hoje);
        double saldoDoDia = fluxoDeCaixaService.calcularSaldoDoDia(hoje);

        // Exibindo as transações e o saldo do dia atual
        FluxoDeCaixaView fluxoDeCaixaView = new FluxoDeCaixaView();
        fluxoDeCaixaView.exibirTransacoesDoDia(transacoesDoDia);
        fluxoDeCaixaView.exibirSaldoDoDia(saldoDoDia);

    }
}