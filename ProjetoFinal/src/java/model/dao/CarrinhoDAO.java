package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Carrinho;

public class CarrinhoDAO {
    
    public List<Carrinho> leia(int idUsuario) {
        List<Carrinho> carrinho = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM carrinho WHERE idUsuario = ?");
            stmt.setInt(1, idUsuario);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Carrinho cro = new Carrinho();
                cro.setIdCarrinho(rs.getInt("idCarrinho"));
                cro.setNomeCarrinho(rs.getString("nome_carrinho"));
                cro.setImagemCarrinho(rs.getString("imagem_carrinho"));
                cro.setCategoriaCarrinho(rs.getString("categoria_carrinho"));
                cro.setDescricaoCarrinho(rs.getString("descricao_carrinho"));
                cro.setPrecoCarrinho(rs.getFloat("preco_carrinho"));
                cro.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
                cro.setIdProdutos(rs.getInt("idProdutos"));
                cro.setIdUsuario(rs.getInt("idUsuario"));
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

    public List<Carrinho> leia1(int idUsuario) {
        List<Carrinho> carrinho = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT total FROM carrinho WHERE idUsuario = ?");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carrinho cro = new Carrinho();
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

    public void inserirProdutoCarrinho(Carrinho carrinho) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinho (nome_carrinho, imagem_carrinho, descricao_carrinho, preco_carrinho, quantidade_carrinho, total, idProdutos, idUsuario) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1, carrinho.getNomeCarrinho());
            stmt.setString(2, carrinho.getImagemCarrinho());
            stmt.setString(3, carrinho.getDescricaoCarrinho());
            stmt.setFloat(4, carrinho.getPrecoCarrinho());
            stmt.setInt(5, carrinho.getQuantidadeCarrinho());
            stmt.setFloat(6, carrinho.getTotal());
            stmt.setInt(7, carrinho.getIdProdutos());
            stmt.setInt(8, carrinho.getIdUsuario());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public List<Carrinho> leiaTotal(int idUsuario) {
        List<Carrinho> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
  stmt = conexao.prepareStatement("SELECT SUM(preco_carrinho * 1) AS total FROM carrinho WHERE idUsuario = ?;");
         stmt.setInt(1, idUsuario);
         rs = stmt.executeQuery();
         if(rs.next()){
             Carrinho objCarrinho = new Carrinho();
             objCarrinho.setTotal(rs.getFloat("total"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }  
        return Carrinho;
    }
    public void deletarProduto(int idCarrinho) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE idCarrinho = ?");
        stmt.setInt(1, idCarrinho);
        stmt.executeUpdate();
        stmt.close();
        conexao.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
 
