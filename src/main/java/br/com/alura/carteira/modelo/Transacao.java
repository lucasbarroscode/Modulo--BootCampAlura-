package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
//esse construtor foi construido para a classe testandoLombok.. para exibir sem os elementos abaixo
@ToString(exclude = { "data", "quantidade", "tipo" })
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "transacoes")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ticker;
	private BigDecimal preco;
	private Integer quantidade;
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	private TipoTransacao tipo;

	@ManyToOne
	private Usuario usuario;
	
	private BigDecimal imposto;

	public Transacao(String ticker, BigDecimal preco, Integer quantidade, LocalDate data, TipoTransacao tipo,
			Usuario usuario) {
		this.ticker = ticker;
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public void atualizarInformacoes(String ticker, LocalDate data, BigDecimal preco, int quantidade,
			TipoTransacao tipo) {
		this.ticker = ticker;
		this.data = data;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tipo = tipo;

	}

	public boolean pertenceAoUsuario(Usuario usuario) {
		return this.usuario.equals(usuario);
	}

}
