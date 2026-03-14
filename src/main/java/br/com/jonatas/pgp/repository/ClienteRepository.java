package br.com.jonatas.pgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jonatas.pgp.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}