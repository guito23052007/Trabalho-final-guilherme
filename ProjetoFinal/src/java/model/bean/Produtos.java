/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Iago
 */
public class Produtos {

    private int idProduto;
    private int categoria;
    private String nome;
    private float valor;
    private String descricao;
    private String link;
    private String imagem;
    private String imagem2;
    private String imagem3;
    private String imagem4;
    private String imagem5;
    private String imagem6;
    private String imagem7;
    private String imagem8;
    
    
    private String nome_categoria;

    public Produtos() {
    }

    public Produtos(int idProduto, int categoria, String nome, float valor, String descricao, String link, String imagem, String imagem2, String imagem3, String imagem4, String imagem5, String imagem6, String imagem7, String imagem8, String nome_categoria) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.link = link;
        this.imagem = imagem;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.imagem4 = imagem4;
        this.imagem5 = imagem5;
        this.imagem6 = imagem6;
        this.imagem7 = imagem7;
        this.imagem8 = imagem8;
        this.nome_categoria = nome_categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public String getImagem4() {
        return imagem4;
    }

    public void setImagem4(String imagem4) {
        this.imagem4 = imagem4;
    }

    public String getImagem5() {
        return imagem5;
    }

    public void setImagem5(String imagem5) {
        this.imagem5 = imagem5;
    }

    public String getImagem6() {
        return imagem6;
    }

    public void setImagem6(String imagem6) {
        this.imagem6 = imagem6;
    }

    public String getImagem7() {
        return imagem7;
    }

    public void setImagem7(String imagem7) {
        this.imagem7 = imagem7;
    }

    public String getImagem8() {
        return imagem8;
    }

    public void setImagem8(String imagem8) {
        this.imagem8 = imagem8;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

  
  
}
