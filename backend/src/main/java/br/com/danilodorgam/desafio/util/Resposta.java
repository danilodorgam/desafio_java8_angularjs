package br.com.danilodorgam.desafio.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class Resposta<T> {

    private T dados;
    private List<Mensagem> mensagens = new ArrayList();

    public Resposta(T data, List<Mensagem> msg) {
        this.dados = data;
        this.mensagens = msg;
    }

    public Resposta(T data, String msg, Mensagem.TipoMensagem tipoMensagem) {
        this.dados = data;
        this.mensagens = add(msg, tipoMensagem);
    }

    public Resposta(String msg, Mensagem.TipoMensagem tipoMensagem) {
        this.mensagens = add(msg, tipoMensagem);
    }

    public Resposta(T data) {
        this.dados = data;
    }

    public Resposta() {
    }

    public Resposta(Mensagem mensagem) {
        addMensagem(mensagem);
    }

    public List<Mensagem> add(String msg, Mensagem.TipoMensagem tipoMensagem) {
        if (this.mensagens == null) {
            this.mensagens = new ArrayList<>();
        }
        Mensagem mensagem = UtilMensagem.getMensagem(msg, tipoMensagem);
        this.mensagens.add(mensagem);
        return mensagens;
    }

    public List<Mensagem> add(String msg) {

        return add(msg,null);
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public void addMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public boolean hasMensagens() {
        return mensagens!=null && !mensagens.isEmpty();
    }
}
