package br.com.alura.carteira.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	
	private List<Transacao> transacoes = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping
	public List<TransacaoDto> listar() {
		
		//List<TransacaoDto> transacoesDto = new ArrayList<>();
//				for (Transacao transacao : transacoes) {
//					TransacaoDto dto = new TransacaoDto();
//					dto.setTicker(transacao.getTicker());
//					dto.setPreco(transacao.getPreco());
//					dto.setQuantidade(transacao.getQuantidade());
//					dto.setTipo(transacao.getTipo());
//					
//					transacoesDto.add(dto);
//				}
		//return transacoesDto;
		
		//Mesma coisa que o for de cima/ Jeito tradicional do java 7 ou java 8
		//return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
		
		
		 return transacoes
				 .stream()
				 .map(t -> modelMapper.map(t, TransacaoDto.class))
				 .collect(Collectors.toList());
		 
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid TransacaoFormDto dto) {
		
		Transacao transacao = modelMapper.map(dto, Transacao.class);
		
		
		//		Transacao transacao = new Transacao(dto.getTicker(),
//				dto.getPreco(),
//				dto.getQuantidade(),
//				dto.getData(),
//				dto.getTipo());
		
		transacoes.add(transacao);
	}
	
}
