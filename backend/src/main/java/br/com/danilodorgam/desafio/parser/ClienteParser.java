package br.com.danilodorgam.desafio.parser;

import br.com.danilodorgam.desafio.dto.ClienteDTO;
import br.com.danilodorgam.desafio.dto.EmailDTO;
import br.com.danilodorgam.desafio.dto.TelefoneDTO;
import br.com.danilodorgam.desafio.model.Cliente;
import br.com.danilodorgam.desafio.model.Email;
import br.com.danilodorgam.desafio.model.Telefone;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class ClienteParser extends Parser<ClienteDTO, Cliente> {

    private Boolean telefone = Boolean.FALSE;
    private Boolean email = Boolean.FALSE;

    public static ClienteParser get(){
        return new ClienteParser();
    }

    public ClienteParser comEmail(){
        email = Boolean.TRUE;
        return this;
    }

    public ClienteParser comTelefone(){
        telefone = Boolean.TRUE;
        return this;
    }
    @Override
    protected ClienteDTO parserDTO(Cliente entidade) {
        ClienteDTO dto = new ClienteDTO();

        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setCpf(entidade.getCpf());
        dto.setCep(entidade.getCep());
        dto.setBairro(entidade.getBairro());
        dto.setCidade(entidade.getCidade());
        dto.setUf(entidade.getUf());
        dto.setComplemento(entidade.getComplemento());
        dto.setLogradouro(entidade.getLogradouro());

        if(telefone){
            List<TelefoneDTO> telefones;
            telefones = entidade.getTelefones().stream().map(telefone -> TelefoneParser.get().parserDTO(telefone)).collect(Collectors.toList());
            dto.setTelefones(telefones);
        }

        if(email){
            List<EmailDTO> emails;
            emails = entidade.getEmails().stream().map(email -> EmailParser.get().parserDTO(email)).collect(Collectors.toList());
            dto.setEmails(emails);
        }

        return dto;
    }

    @Override
    protected Cliente parserEntidade(ClienteDTO dto) {
        Cliente entidade = new Cliente();

        entidade.setId(dto.getId());
        entidade.setNome(dto.getNome());
        entidade.setCep(dto.getCep());
        entidade.setBairro(dto.getBairro());
        entidade.setCpf(dto.getCpf());

        entidade.setCidade(dto.getCidade());
        entidade.setUf(dto.getUf());
        entidade.setLogradouro(dto.getLogradouro());
        entidade.setComplemento(dto.getComplemento());

        if(dto.getTelefones() != null){
            List<Telefone> telefones;
            telefones = dto.getTelefones().stream().map(telefone -> {
                Telefone telefoneEntidade = TelefoneParser.get().parserEntidade(telefone);
                telefoneEntidade.setCliente(entidade);
                return telefoneEntidade;
            }).collect(Collectors.toList());
            entidade.setTelefones(telefones);
        }

        if(dto.getEmails() != null){
            List<Email> emails;
            emails = dto.getEmails().stream().map(email -> {
                Email emailEntidade = EmailParser.get().parserEntidade(email);
                emailEntidade.setCliente(entidade);
                return emailEntidade;
            }).collect(Collectors.toList());
            entidade.setEmails(emails);
        }
        return entidade;
    }
}
