package br.com.danilodorgam.desafio.model.domain;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class ItemSimples {

    private String codigo;
    private String descricao;



    public ItemSimples(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }


    public ItemSimples() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
