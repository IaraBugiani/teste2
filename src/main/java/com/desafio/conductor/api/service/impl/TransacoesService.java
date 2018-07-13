package com.desafio.conductor.api.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.desafio.conductor.api.model.Transacoes;

public interface TransacoesService {
	
	List<Transacoes> listaTransacoesPorPeriodo(LocalDate dataInicio, LocalDate dataFim);
	
}
