package br.com.danilodorgam.desafio.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class ClienteDTO implements Serializable {

    private Integer id;

    @NotNull
    @Length(min = 3, max = 100)
//    @Pattern(regexp = "[A-Za-z0-9 _]")
    private String nome;

    @CPF
    @NotNull
    private String cpf;

    @NotNull
    @Length(max = 8)
    private String cep;

    @NotNull
    @Length(max = 20)
    private String bairro;

    @NotNull
    @Length(max = 20)
    private String logradouro;

    @NotNull
    @Length(max = 20)
    private String cidade;

    @NotNull
    @Length(max = 2)
    private String uf;

    @Length(max = 100)
    private String complemento;

    @NotEmpty
    private List<TelefoneDTO> telefones;

    @NotEmpty
    private List<EmailDTO> emails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
