package br.com.danilodorgam.desafio.repository;

import br.com.danilodorgam.desafio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
