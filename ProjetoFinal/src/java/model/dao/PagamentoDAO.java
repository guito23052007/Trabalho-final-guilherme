package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Pagamento;

public class PagamentoDAO {
    public void checalt(Pagamento p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO pagamentos (id_usuario, nome_sobrenome, tipo_pagamento) VALUES (?, ?, ?)");
            stmt.setInt(1, p.getId_usuario());
            stmt.setString(2, p.getNome_sobrenome());
            stmt.setString(3, p.getTipo_pagamento());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
