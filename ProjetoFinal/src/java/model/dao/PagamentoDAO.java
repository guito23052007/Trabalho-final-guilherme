/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Pagamento;

/**
 *
 * @author Edson
 */
public class PagamentoDAO {
      public void pagamento(Pagamento p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO formas_pagamento (id_usuario, nome_sobrenome) VALUES (?, ?)");
            stmt.setInt(1, p.getId_usuario());
            stmt.setString(2, p.getNome_sobrenome());
      
           
        
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
