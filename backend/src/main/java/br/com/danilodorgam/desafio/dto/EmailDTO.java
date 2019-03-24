package br.com.danilodorgam.desafio.dto;

import br.com.danilodorgam.desafio.model.domain.TipoTelefoneEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
public class EmailDTO implements Serializable {
    private Integer id;

    @NotNull
    @Length(max = 200)
    @Email
    private String endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
