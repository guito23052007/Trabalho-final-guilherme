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
import model.bean.Produtos;

/**
 *
 * @author aluno
 */
public class ProdutosDAO {

    public void cadastrarProduto(Produtos p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produtos (categoria, nome, valor, descricao,  link, imagem, imagem2, imagem3, imagem4, imagem5,imagem6,imagem7,imagem8) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)");
            stmt.setInt(1, p.getCategoria());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setString(4, p.getDescricao());
            stmt.setString(5, p.getLink());
            stmt.setString(6, p.getImagem());
            stmt.setString(7, p.getImagem2());
            stmt.setString(8, p.getImagem3());
            stmt.setString(9, p.getImagem4());
            stmt.setString(10, p.getImagem5());
            stmt.setString(11, p.getImagem6());
            stmt.setString(12, p.getImagem7());
            stmt.setString(13, p.getImagem8());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produtos> listarProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 1000");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setValor(rs.getFloat("valor"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setLink(rs.getString("link"));
                produto.setImagem(rs.getString("imagem"));
                produto.setImagem2(rs.getString("imagem2"));
                produto.setImagem3(rs.getString("imagem3"));
                produto.setImagem4(rs.getString("imagem4"));
                produto.setImagem5(rs.getString("imagem5"));
                produto.setImagem6(rs.getString("imagem6"));
                produto.setImagem7(rs.getString("imagem7"));
                produto.setImagem8(rs.getString("imagem8"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public List<Produtos> buscaProdutos(String busca) {
        List<Produtos> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoria(rs.getInt("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setLink(rs.getString("link"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getString("imagem"));
                prod.setImagem2(rs.getString("imagem2"));
                prod.setImagem3(rs.getString("imagem3"));
                prod.setImagem4(rs.getString("imagem4"));
                prod.setImagem5(rs.getString("imagem5"));
                prod.setImagem6(rs.getString("imagem6"));
                prod.setImagem7(rs.getString("imagem7"));
                prod.setImagem8(rs.getString("imagem8"));

                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }

    public List<Produtos> buscaCategoria(int categoria) {
        List<Produtos> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria =?");
            stmt.setInt(1, categoria);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoria(rs.getInt("categoria"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setLink(rs.getString("link"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getString("imagem"));
                prod.setImagem2(rs.getString("imagem2"));
                prod.setImagem3(rs.getString("imagem3"));
                prod.setImagem4(rs.getString("imagem4"));
                prod.setImagem5(rs.getString("imagem5"));
                prod.setImagem6(rs.getString("imagem6"));
                prod.setImagem7(rs.getString("imagem7"));
                prod.setImagem8(rs.getString("imagem8"));
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }

    public List<Produtos> unicoProdutos(int id) {
        List<Produtos> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE id_produto =?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setValor(rs.getFloat("valor"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setLink(rs.getString("link"));
                produto.setImagem(rs.getString("imagem"));
                produto.setImagem2(rs.getString("imagem2"));
                produto.setImagem3(rs.getString("imagem3"));
                produto.setImagem4(rs.getString("imagem4"));
                produto.setImagem5(rs.getString("imagem5"));
                produto.setImagem6(rs.getString("imagem6"));
                produto.setImagem7(rs.getString("imagem7"));
                produto.setImagem8(rs.getString("imagem8"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public List<Produtos> leia() {
        List<Produtos> produto = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos prt = new Produtos();
                prt.setIdProduto(rs.getInt("idProdutos"));
                prt.setNome(rs.getString("nome"));
                prt.setImagem(rs.getString("imagem"));
                prt.setImagem2(rs.getString("imagem2"));
                prt.setImagem2(rs.getString("imagem3"));
                prt.setImagem2(rs.getString("imagem4"));
                prt.setCategoria(rs.getInt("categoria"));
                prt.setDescricao(rs.getString("descricao"));
                prt.setValor(rs.getFloat("preco"));

                produto.add(prt);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<Produtos> ListarXbox() {
        List<Produtos> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome, produtos.imagem, produtos.descricao, produtos.valor, categorias.nome FROM produtos INNER JOIN categorias ON produtos.categoria = categorias.id_categoria WHERE produtos.categoria = 1");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setImagem(rs.getString("imagem"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome_categoria(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produtos.add(produto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;

    }

    public List<Produtos> ListarNintendo() {
        List<Produtos> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome, produtos.imagem, produtos.descricao, produtos.valor, categorias.nome FROM produtos INNER JOIN categorias ON produtos.categoria = categorias.id_categoria WHERE produtos.categoria = 2");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setImagem(rs.getString("imagem"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome_categoria(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produtos.add(produto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;

    }

    public List<Produtos> ListarPlaystation() {
        List<Produtos> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome, produtos.imagem, produtos.descricao, produtos.valor, categorias.nome FROM produtos INNER JOIN categorias ON produtos.categoria = categorias.id_categoria WHERE produtos.categoria = 3");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setImagem(rs.getString("imagem"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome_categoria(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produtos.add(produto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;

    }

    public List<Produtos> ListarRpg() {
        List<Produtos> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome, produtos.imagem, produtos.descricao, produtos.valor, categorias.nome FROM produtos INNER JOIN categorias ON produtos.categoria = categorias.id_categoria WHERE produtos.categoria = 4");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setImagem(rs.getString("imagem"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setNome_categoria(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produtos.add(produto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;

    }
}
