package br.com.danilodorgam.desafio.exception;

import br.com.danilodorgam.desafio.util.Mensagem;

import java.util.List;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class DesafioException extends RuntimeException {
    private static final long serialVersionUID = 4871650247130218088L;
    private String[] args;
    private List<Mensagem> mensagens;

    public DesafioException() {
        super();
    }

    public DesafioException(Throwable excecao) {
        super(excecao.getMessage());
        super.initCause(excecao.getCause());
    }

    public DesafioException(String msg, Throwable excecao) {
        super(msg, excecao);
        super.initCause(excecao.getCause());
    }

    public DesafioException(String key) {
        super(key);
    }

    public DesafioException(String key, String... args) {
        super(key);
        setArgs(args);
    }

    public DesafioException(String key, List<Mensagem> lista) {
        super(key);
        this.mensagens = lista;
    }

    public String[] getArgs() {
        return args;
    }
    public void setArgs(String[] args) {
        this.args = args;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }
}
