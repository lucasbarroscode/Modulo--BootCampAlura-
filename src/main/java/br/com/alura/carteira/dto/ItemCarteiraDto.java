package br.com.alura.carteira.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ItemCarteiraDto {

	private String ticker;
	private Long quantidade;
	private BigDecimal percentual;
	
	public ItemCarteiraDto(String ticker, Long quantidade, Long quantidadeTotal) {
		super();
		this.ticker = ticker;
		this.quantidade = quantidade;
		this.percentual = new BigDecimal(quantidade)
				.divide(new BigDecimal(quantidadeTotal), 4, RoundingMode.HALF_UP)
				.multiply(new BigDecimal("100"))
				.setScale(2);
	}
	
	
}
