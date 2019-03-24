package br.com.danilodorgam.desafio.controller;

import br.com.danilodorgam.desafio.dto.ClienteDTO;
import br.com.danilodorgam.desafio.exception.DesafioException;
import br.com.danilodorgam.desafio.service.ClienteService;
import br.com.danilodorgam.desafio.util.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<Resposta<ClienteDTO>> salvar(@RequestBody ClienteDTO disciplinaDTO) {
        ClienteDTO dto = this.clienteService.salvar(disciplinaDTO);
        disciplinaDTO.setId(null);
        Resposta<ClienteDTO> resposta = new Resposta<>(dto);

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping(path = "detalhar/{id}")
    public ResponseEntity<Resposta<ClienteDTO>> detalhar(@PathVariable("id") Integer id){
        Resposta<ClienteDTO> resposta;
        resposta = this.clienteService.detalhar(id);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<Resposta<List<ClienteDTO>>> listar(){

        List<ClienteDTO> resultados = this.clienteService.listar();

        if(resultados.size() == 0){
            throw new DesafioException("MN3");
        }
        return new ResponseEntity<>(new Resposta<>(resultados), HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Resposta<ClienteDTO>> aterar(@PathVariable("id")  Integer id, @RequestBody ClienteDTO disciplinaDTO){
        Resposta<ClienteDTO> resposta = new Resposta<>();
        disciplinaDTO.setId(id);
        ClienteDTO dto = this.clienteService.salvar(disciplinaDTO);

        resposta.setDados(dto);

        return new ResponseEntity<>(resposta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Resposta<Void>> deletar(@PathVariable("id") Integer id){
        Resposta<Void> resposta = new Resposta<>();
        this.clienteService.deletar(id);
        return new ResponseEntity<>(resposta, HttpStatus.ACCEPTED);
    }
}
