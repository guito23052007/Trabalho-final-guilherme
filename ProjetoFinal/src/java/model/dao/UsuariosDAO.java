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
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuarios;

/**
 *
 * @author aluno
 */
public class UsuariosDAO {
    
    public void cadastrarUsuario(Usuarios user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO usuarios (nome, senha, usuario, telefone, data_nascimento, cpf, status) VALUES (?, ?, ?, ?, ?, ?, 1)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getUsuario());
            stmt.setString(4, user.getTelefone());
            stmt.setDate(5, user.getData_nascimento());
            stmt.setString(6, user.getCpf());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Usuarios buscarLogin(Usuarios user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT id_usuario, status FROM usuarios WHERE usuario = ? AND senha = ?");
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getSenha());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setStatus(rs.getInt("status"));
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public List<Usuarios> listarUser() {
        List<Usuarios> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM usuarios ");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuarios usuer = new Usuarios();
                usuer.setId_usuario(rs.getInt("id_usuario"));
                usuer.setUsuario(rs.getString("usuario"));
                usuer.setNome(rs.getString("nome"));
                usuer.setCpf(rs.getString("cpf"));
                usuer.setTelefone(rs.getString("telefone"));


                produtos.add(usuer);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
public void deletarUsuario(int idUsuario) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
        stmt.setInt(1, idUsuario);
        stmt.executeUpdate();
        stmt.close();
        conexao.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
