package br.com.danilodorgam.desafio.model;

import br.com.danilodorgam.desafio.model.domain.TipoTelefoneEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
@Entity
@Table(name = "cliente_telefone")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone", precision = 3)
    private Integer id;

    @Column(name = "tipo", length = 1)
    @Enumerated(EnumType.STRING)
    private TipoTelefoneEnum tipoTelefone;

    @Column(name = "numero", length = 11, nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoTelefoneEnum getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id) &&
                tipoTelefone == telefone.tipoTelefone &&
                numero.equals(telefone.numero) &&
                cliente.equals(telefone.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoTelefone, numero, cliente);
    }
}
