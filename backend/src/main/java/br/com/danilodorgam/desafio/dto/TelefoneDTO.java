package br.com.danilodorgam.desafio.dto;

import br.com.danilodorgam.desafio.model.domain.TipoTelefoneEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class TelefoneDTO  implements Serializable {

    private Integer id;

    @NotNull
    @Length(max = 1)
    private TipoTelefoneEnum tipoTelefone;

    @NotNull
    @Length(min = 10, max = 11)
    private String numero;

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
}
