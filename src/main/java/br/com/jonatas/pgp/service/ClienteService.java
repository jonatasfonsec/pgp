package br.com.jonatas.pgp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jonatas.pgp.dto.ClienteRequest;
import br.com.jonatas.pgp.entity.Cliente;
import br.com.jonatas.pgp.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository=repository;
	}
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);		
	}
	
	public List<Cliente> listarTodos(){
		return repository.findAll();
	}
	
	   public Cliente buscarPorId(Long id) {
	        return repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	    }
	   
	    public Cliente atualizar(Long id, ClienteRequest request) {

	        Cliente cliente = buscarPorId(id);

	        cliente.setNome(request.nome());
	        cliente.setEmail(request.email());
	        cliente.setTelefone(request.telefone());

	        return repository.save(cliente);
	    }
	    
	    public void deletar(Long id) {

	        Cliente cliente = buscarPorId(id);

	        repository.delete(cliente);
	    }

}
