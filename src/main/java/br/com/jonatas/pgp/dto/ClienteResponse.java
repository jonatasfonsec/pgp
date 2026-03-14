package br.com.jonatas.pgp.dto;

public record ClienteResponse(
	    Long id,
	    String nome,
	    String email,
	    String telefone				
) {}
