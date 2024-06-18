package model.bean;



/**
 *
 * @author consa
 */
public class Carrinho {
    private int idCarrinho;
    private String nomeCarrinho;
    private String imagemCarrinho;
    private String categoriaCarrinho;
    private String descricaoCarrinho;
    private float precoCarrinho;
    private int quantidadeCarrinho;
    private int idProdutos;
  private int idUsuario;
    private float total;

    public Carrinho() {
    }

    public Carrinho(int idCarrinho, String nomeCarrinho, String imagemCarrinho, String categoriaCarrinho, String descricaoCarrinho, float precoCarrinho, int quantidadeCarrinho, int idProdutos, int idUsuario, float total) {
        this.idCarrinho = idCarrinho;
        this.nomeCarrinho = nomeCarrinho;
        this.imagemCarrinho = imagemCarrinho;
        this.categoriaCarrinho = categoriaCarrinho;
        this.descricaoCarrinho = descricaoCarrinho;
        this.precoCarrinho = precoCarrinho;
        this.quantidadeCarrinho = quantidadeCarrinho;
        this.idProdutos = idProdutos;
        this.idUsuario = idUsuario;
        this.total = total;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getNomeCarrinho() {
        return nomeCarrinho;
    }

    public void setNomeCarrinho(String nomeCarrinho) {
        this.nomeCarrinho = nomeCarrinho;
    }

    public String getImagemCarrinho() {
        return imagemCarrinho;
    }

    public void setImagemCarrinho(String imagemCarrinho) {
        this.imagemCarrinho = imagemCarrinho;
    }

    public String getCategoriaCarrinho() {
        return categoriaCarrinho;
    }

    public void setCategoriaCarrinho(String categoriaCarrinho) {
        this.categoriaCarrinho = categoriaCarrinho;
    }

    public String getDescricaoCarrinho() {
        return descricaoCarrinho;
    }

    public void setDescricaoCarrinho(String descricaoCarrinho) {
        this.descricaoCarrinho = descricaoCarrinho;
    }

    public float getPrecoCarrinho() {
        return precoCarrinho;
    }

    public void setPrecoCarrinho(float precoCarrinho) {
        this.precoCarrinho = precoCarrinho;
    }

    public int getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(int quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

   
    

   
}
