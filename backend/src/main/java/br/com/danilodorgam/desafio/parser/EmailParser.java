package br.com.danilodorgam.desafio.parser;

import br.com.danilodorgam.desafio.dto.EmailDTO;
import br.com.danilodorgam.desafio.model.Email;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class EmailParser extends Parser<EmailDTO, Email> {

    public static EmailParser get(){
        return new EmailParser();
    }

    @Override
    protected EmailDTO parserDTO(Email entidade) {
        EmailDTO dto = new EmailDTO();
        dto.setId(entidade.getId());
        dto.setEndereco(entidade.getEndereco());
        return dto;
    }

    @Override
    protected Email parserEntidade(EmailDTO dto) {
        Email entidade = new Email();

        entidade.setId(dto.getId());
        entidade.setEndereco(dto.getEndereco());

        return entidade;
    }
}
