package com.desafio.conductor.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_TRANS")
public class Transacoes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TRANSACAO",nullable=false)
	private Long idTransacao;
	
	@Column(name="NM_CARTAO", length=16, nullable=false)
	private Long cartao;
	
	@Column(name="VR_VALOR",precision=2, nullable=false)
	private BigDecimal valorTransacao;
	
	@Column(name="DT_DATA",nullable=false)
	private LocalDate data;

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Long getCartao() {
		return cartao;
	}

	public void setCartao(Long cartao) {
		this.cartao = cartao;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
