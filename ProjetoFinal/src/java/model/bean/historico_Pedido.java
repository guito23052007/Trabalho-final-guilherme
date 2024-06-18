/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
import java.time.LocalDateTime;

public class historico_Pedido {
    private int id_pedido;
    private int usuario;
    private String nome_produto;
    private String imagem_produto;
    private float valor_produto;
    private int idUsuario;
    private LocalDateTime datahora;
    private float total;

    public historico_Pedido() {
    }

    public historico_Pedido(int id_pedido, int usuario, String nome_produto, String imagem_produto, float valor_produto, int idUsuario, LocalDateTime datahora, float total) {
        this.id_pedido = id_pedido;
        this.usuario = usuario;
        this.nome_produto = nome_produto;
        this.imagem_produto = imagem_produto;
        this.valor_produto = valor_produto;
        this.idUsuario = idUsuario;
        this.datahora = datahora;
        this.total = total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getImagem_produto() {
        return imagem_produto;
    }

    public void setImagem_produto(String imagem_produto) {
        this.imagem_produto = imagem_produto;
    }

    public float getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(float valor_produto) {
        this.valor_produto = valor_produto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

 
}
