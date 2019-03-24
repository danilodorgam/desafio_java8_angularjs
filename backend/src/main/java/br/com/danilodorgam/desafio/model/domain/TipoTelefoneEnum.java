package br.com.danilodorgam.desafio.model.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public enum TipoTelefoneEnum {
    R("R", "Residencial"),
    C("C", "Comercial"),
    P("P", "Celular");

    private String codigo;
    private String descricao;

    TipoTelefoneEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;

    }

    public static List<ItemSimples> listar() {
        List<ItemSimples> listagem = new ArrayList<>();
        for (TipoTelefoneEnum e : values()) {
            listagem.add(new ItemSimples(e.codigo,e.descricao));
        }
        return listagem;
    }
}
