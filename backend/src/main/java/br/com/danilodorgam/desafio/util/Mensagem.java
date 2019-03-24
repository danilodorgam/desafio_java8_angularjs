package br.com.danilodorgam.desafio.util;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class Mensagem {

    private String mensagem;
    private TipoMensagem tipoMensagem;

    public Mensagem(TipoMensagem tipo, String message) {
        mensagem = message;
        tipoMensagem = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public enum TipoMensagem {INFO, AVISO, ERRO}
}
