package com.desafio.conductor.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.conductor.api.model.Transacoes;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long>{

	List<Transacoes> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);
}
