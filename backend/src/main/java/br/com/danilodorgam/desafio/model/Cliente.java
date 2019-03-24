package br.com.danilodorgam.desafio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", precision = 3)
    private Integer id;

    @Column(name = "nome", length = 100 , nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "bairro", length = 20, nullable = false)
    private String bairro;

    @Column(name = "logradouro", length = 20, nullable = false)
    private String logradouro;

    @Column(name = "cidade", length = 20, nullable = false)
    private String cidade;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;


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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) &&
                nome.equals(cliente.nome) &&
                cpf.equals(cliente.cpf) &&
                cep.equals(cliente.cep) &&
                bairro.equals(cliente.bairro) &&
                cidade.equals(cliente.cidade) &&
                uf.equals(cliente.uf) &&
                Objects.equals(complemento, cliente.complemento) &&
                telefones.equals(cliente.telefones) &&
                emails.equals(cliente.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, cep, bairro, cidade, uf, complemento, telefones, emails);
    }
}
