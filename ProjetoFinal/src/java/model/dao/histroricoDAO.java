/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.bean.historico_Pedido;

/**
 *
 * @author Edson
 */
public class histroricoDAO {

    public List<historico_Pedido> historico() {
        List<historico_Pedido> carrinho = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM historico_pedidos");

            rs = stmt.executeQuery();
            while (rs.next()) {
                historico_Pedido cro = new historico_Pedido();
                cro.setId_pedido(rs.getInt("id_pedido"));
                cro.setNome_produto(rs.getString("nome_produto"));
                cro.setImagem_produto(rs.getString("imagem"));
                cro.setValor_produto(rs.getFloat("valor"));

                cro.setIdUsuario(rs.getInt("idUsuario"));
                LocalDateTime datahora = rs.getTimestamp("datahora").toLocalDateTime();
                cro.setDatahora(datahora);
                carrinho.add(cro);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }

    public List<historico_Pedido> Total() {
        List<historico_Pedido> carrinho = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT SUM(valor) AS total FROM historico_pedidos");
            rs = stmt.executeQuery();

            if (rs.next()) {
                historico_Pedido cro = new historico_Pedido();
                cro.setTotal(rs.getFloat("total"));
                carrinho.add(cro);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }

  
    
    public void inserirHistorico(historico_Pedido historicoUser) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO carrinho (imagem_carrinho, nome_produto, preco_carrinho, dataHora, idUsuario) VALUES (?, ?, ?, ?, ?)"
            );

            stmt.setString(1, historicoUser.getImagem_produto());
            stmt.setString(2, historicoUser.getNome_produto());
            stmt.setFloat(3, historicoUser.getValor_produto());
            stmt.setTimestamp(4, Timestamp.valueOf(historicoUser.getDatahora()));
            stmt.setInt(5, historicoUser.getIdUsuario());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Outros métodos do DAO aqui



    public List<historico_Pedido> historicoUser(int idUsuario) {
        List<historico_Pedido> carrinho = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM historico_pedidos WHERE idusuario = ?");
            stmt.setInt(1, idUsuario);

            rs = stmt.executeQuery();
            while (rs.next()) {
                historico_Pedido cro = new historico_Pedido();
                cro.setId_pedido(rs.getInt("id_pedido"));
                cro.setNome_produto(rs.getString("nome_produto"));
                cro.setImagem_produto(rs.getString("imagem"));
                cro.setValor_produto(rs.getFloat("valor"));
                cro.setDatahora(rs.getTimestamp("dataHora").toLocalDateTime());
                cro.setIdUsuario(rs.getInt("idusuario"));
                carrinho.add(cro);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }

}
