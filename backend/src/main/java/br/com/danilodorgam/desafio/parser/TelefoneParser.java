package br.com.danilodorgam.desafio.parser;

import br.com.danilodorgam.desafio.dto.TelefoneDTO;
import br.com.danilodorgam.desafio.model.Cliente;
import br.com.danilodorgam.desafio.model.Telefone;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class TelefoneParser extends Parser<TelefoneDTO, Telefone> {

    public static TelefoneParser get(){
        return new TelefoneParser();
    }

    @Override
    protected TelefoneDTO parserDTO(Telefone entidade) {
        TelefoneDTO dto = new TelefoneDTO();
        dto.setId(entidade.getId());
        dto.setTipoTelefone(entidade.getTipoTelefone());
        dto.setNumero(entidade.getNumero());

        return dto;
    }

    @Override
    protected Telefone parserEntidade(TelefoneDTO dto) {
        Telefone entidade = new Telefone();
        entidade.setId(dto.getId());

        entidade.setNumero(dto.getNumero());

        entidade.setTipoTelefone(dto.getTipoTelefone());

        return entidade;
    }
}
