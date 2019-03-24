package br.com.danilodorgam.desafio.controller;

import br.com.danilodorgam.desafio.model.domain.TipoTelefoneEnum;
import br.com.danilodorgam.desafio.util.Resposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
@RestController
@RequestMapping(path = "enum")
public class EnumController {

    @GetMapping()
    public ResponseEntity<Resposta<List<TipoTelefoneEnum>>> listar(){

        Resposta resposta = new Resposta(TipoTelefoneEnum.listar());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
}
