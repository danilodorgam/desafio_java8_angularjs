package br.com.danilodorgam.desafio.exception;

import br.com.danilodorgam.desafio.util.Mensagem;
import br.com.danilodorgam.desafio.util.Resposta;
import br.com.danilodorgam.desafio.util.UtilMensagem;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */



@ControllerAdvice
public class ExceptionsHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Resposta<?>> exceptionHandler(Exception e) {
        String mensagemRaiz = ExceptionUtils.getRootCauseMessage(e);
        LOGGER.error("Exceção lançada: ".concat(mensagemRaiz), e);
        Resposta<?> mensagem = new Resposta<>("Ocorreu um erro inesperado.", Mensagem.TipoMensagem.ERRO);
        return new ResponseEntity(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(DesafioException.class)
    public ResponseEntity<Resposta<?>> exceptionHandler(DesafioException e) {

        Resposta<?> mensagem = new Resposta<>();
        if(e.getMensagens()!=null) {
            for (Mensagem msg: e.getMensagens()) {
                mensagem.addMensagem(UtilMensagem.getMensagem(msg.getMensagem(), msg.getTipoMensagem()));
            }
        }else {
            if (e.getArgs() != null && e.getArgs().length > 0) {
                mensagem.addMensagem(UtilMensagem.getMensagem(e.getArgs(), e.getMessage(), Mensagem.TipoMensagem.ERRO));
            }
            mensagem.addMensagem(UtilMensagem.getMensagem(e.getMessage() , Mensagem.TipoMensagem.ERRO));
        }
        return new ResponseEntity(mensagem, HttpStatus.BAD_REQUEST);
    }


}
