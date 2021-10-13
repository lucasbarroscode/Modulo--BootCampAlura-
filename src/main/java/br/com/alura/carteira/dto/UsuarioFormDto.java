package br.com.alura.carteira.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormDto {

	@NotBlank(message = "Deve ser informado!")
	private String nome;
	@NotBlank
	private String login;
	
	
}
