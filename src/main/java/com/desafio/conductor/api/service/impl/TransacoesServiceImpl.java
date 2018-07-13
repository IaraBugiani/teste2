package com.desafio.conductor.api.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.conductor.api.model.Transacoes;
import com.desafio.conductor.api.repository.TransacoesRepository;

public class TransacoesServiceImpl implements TransacoesService {
	
	@Autowired
	private TransacoesRepository repository;

	@Override
	public List<Transacoes> listaTransacoesPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
		return repository.findByDataBetween(dataInicio, dataFim);
	}
	

}
