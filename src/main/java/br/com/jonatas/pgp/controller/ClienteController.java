package br.com.jonatas.pgp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonatas.pgp.dto.ClienteRequest;
import br.com.jonatas.pgp.dto.ClienteResponse;
import br.com.jonatas.pgp.entity.Cliente;
import br.com.jonatas.pgp.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteResponse salvar(@RequestBody ClienteRequest request) {
        
    	Cliente cliente = new Cliente();        
        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        
        Cliente salvo = service.salvar(cliente);
        
        return new ClienteResponse(
        		salvo.getId(),
        		salvo.getNome(),
        		salvo.getEmail(),
        		salvo.getTelefone()
        		);
    	
        
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }
    
    
    @PutMapping("/{id}")
    public ClienteResponse atualizar(@PathVariable Long id,
                                     @RequestBody ClienteRequest request) {

        Cliente cliente = service.atualizar(id, request);

        return new ClienteResponse(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getTelefone()
        );
    }
}