package com.desafio.conductor.api.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.conductor.api.service.impl.TransacoesServiceImpl;

@RestController
@RequestMapping("/transacoes")
public class TransacoesResource {
	
	@Autowired
	private TransacoesServiceImpl serviceImpl;

}
