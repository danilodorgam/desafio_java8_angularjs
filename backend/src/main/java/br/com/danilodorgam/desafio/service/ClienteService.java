package br.com.danilodorgam.desafio.service;

import br.com.danilodorgam.desafio.dto.ClienteDTO;
import br.com.danilodorgam.desafio.exception.DesafioException;
import br.com.danilodorgam.desafio.model.Cliente;
import br.com.danilodorgam.desafio.parser.ClienteParser;
import br.com.danilodorgam.desafio.repository.ClienteRepository;
import br.com.danilodorgam.desafio.util.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional()
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = converterValido(clienteDTO);

        cliente = this.repository.save(cliente);

        return ClienteParser.get().paraDTO((cliente)).getDados();
    }

    private Cliente converterValido(ClienteDTO clienteDTO){
        ClienteParser parser = (ClienteParser) ClienteParser.get().validar();

        Resposta<Cliente> cliente =  parser.paraEntidade(clienteDTO);

        if(cliente.hasMensagens()){
            throw new DesafioException("",cliente.getMensagens());
        }
        return cliente.getDados();
    }

    public Resposta<ClienteDTO> detalhar(Integer id) {
        Cliente cliente = getCliente(id);
        return ClienteParser.get().comEmail().comTelefone().paraDTO(cliente);
    }


    public List<ClienteDTO> listar() {
        List<Cliente> clientes = this.repository.findAll();
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        clientes.forEach(cliente -> clienteDTOS.add(ClienteParser.get().paraDTO(cliente).getDados()));

        return clienteDTOS;
    }


    private Cliente getCliente(Integer id) {
        Optional<Cliente> cliente = this.repository.findById(id);

        if(!cliente.isPresent()){
            throw new DesafioException("MN2");
        }
        return cliente.get();
    }

    /**
     * remove fisicamente do banco
     * @param id
     */
    public void deletar(Integer id) {
        Cliente cliente = this.getCliente(id);
        this.repository.delete(cliente);
    }
}
