package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
//esse construtor foi construido para a classe testandoLombok.. para exibir sem os elementos abaixo
@ToString (exclude = {"data", "quantidade", "tipo"})
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

	
	private String ticker;
	private BigDecimal preco;
	private int quantidade;
	private LocalDate data;
	private TipoTransacao tipo;

}
