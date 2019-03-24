package br.com.danilodorgam.desafio.parser;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

import br.com.danilodorgam.desafio.util.Mensagem;
import br.com.danilodorgam.desafio.util.Mensagem.TipoMensagem;
import br.com.danilodorgam.desafio.util.Resposta;
/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */

public abstract class Parser<DTO, ENTIDADE> {


    private ValidatorFactory factory = null;
    private Validator validator = null;
    private Boolean validar = Boolean.FALSE;

    private Boolean erros = Boolean.FALSE;

    private Set<ConstraintViolation<Object>> constraintViolations;

    protected Parser() {
        factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(
                        new ResourceBundleMessageInterpolator(
                                new PlatformResourceBundleLocator( "ValidationMessages" )
                        )
                )
                .buildValidatorFactory();
        validator = factory.getValidator();
    }

    private void validaObjeto(Object objecto) {
        if(this.validar) {
            constraintViolations = validator.validate( objecto );
            if(constraintViolations!=null && !constraintViolations.isEmpty()) {
                this.erros = Boolean.TRUE;
            }
        }
    }

    private <T> Resposta<T> montaResultado(T objeto) {
        Resposta<T> resposta = new Resposta<>();
        if(erros) {
            for (ConstraintViolation<Object> erro : constraintViolations) {
                resposta.addMensagem(new Mensagem(TipoMensagem.ERRO, erro.getPropertyPath()+":"+erro.getMessage()));
            }
        }
        resposta.setDados(objeto);
        return resposta;
    }

    public Parser<DTO, ENTIDADE> validar() {
        this.validar = Boolean.TRUE;
        return this;
    }


    public Resposta<ENTIDADE> paraEntidade(DTO dto) {

        validaObjeto(dto);
        ENTIDADE entidade =  parserEntidade( dto );
        Resposta<ENTIDADE> resposta = montaResultado(entidade);
        return resposta;
    }



    public Resposta<DTO> paraDTO(ENTIDADE entidade) {

        validaObjeto(entidade);
        DTO dto =  parserDTO( entidade );
        Resposta<DTO> resposta = montaResultado( dto );
        return resposta;
    }


    protected abstract DTO   parserDTO(ENTIDADE dto);
    protected abstract ENTIDADE parserEntidade(DTO dto);

}
