package model.bean;

public class Pagamento {

    private int id_forma_pagamento;
    private int id_usuario;
    private String nome_sobrenome;
    private String tipo_pagamento;

    public Pagamento() {
    }

    public Pagamento(int id_forma_pagamento, int id_usuario, String nome_sobrenome, String tipo_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
        this.id_usuario = id_usuario;
        this.nome_sobrenome = nome_sobrenome;
        this.tipo_pagamento = tipo_pagamento;
    }

    public int getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_sobrenome() {
        return nome_sobrenome;
    }

    public void setNome_sobrenome(String nome_sobrenome) {
        this.nome_sobrenome = nome_sobrenome;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

}
