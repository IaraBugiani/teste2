package com.desafio.conductor.api.rest.resource;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.conductor.api.model.Transacoes;
import com.desafio.conductor.api.service.impl.TransacoesServiceImpl;

@RestController
@RequestMapping("/transacoes")
public class TransacoesResource {
	
	@Autowired
	private TransacoesServiceImpl serviceImpl;
	
	private final Logger log = LoggerFactory.getLogger(TransacoesResource.class);
	
	@GetMapping ("/porperido/")
	public  ResponseEntity<List<Transacoes>> buscaTransacoesPorPeriodo (@RequestParam("dataInicio") @DateTimeFormat(iso=ISO.DATE) LocalDate dataInicio, @RequestParam("dataFim") @DateTimeFormat(iso=ISO.DATE) LocalDate dataFim) {
		List<Transacoes> listaTransacoes = null;
		try{
			listaTransacoes = serviceImpl.listaTransacoesPorPeriodo(dataInicio, dataFim);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<List<Transacoes>>(listaTransacoes, HttpStatus.OK);
	}
}
