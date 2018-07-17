package com.desafio.conductor.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.desafio.conductor.api.model.Transacoes;
import com.desafio.conductor.api.rest.resource.TransacoesResource;
import com.desafio.conductor.api.service.impl.TransacoesService;
import com.desafio.conductor.api.service.impl.TransacoesServiceImpl;

public class TransacoesResourceTest {

	@Mock
	private TransacoesService service;

	@Mock
	private TransacoesServiceImpl serviceImpl;

	@InjectMocks
	private TransacoesResource resource;

	@Mock
	List<Transacoes> listapesquisa;

	private static final LocalDate DATA_INI = LocalDate.parse("2018-06-01");
	private static final LocalDate DATA_FIM = LocalDate.parse("2018-09-18");
	private static final LocalDate DATE_INI = LocalDate.parse("2018-01-01");
	private static final LocalDate DATE_FIM = LocalDate.parse("2018-03-18");

	LocalDate dataInicio;
	LocalDate dataFim;

	LocalDate dateInicio;
	LocalDate dateFim;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		dataInicio = DATA_INI;
		dataFim = DATA_FIM;
		dateInicio = DATE_INI;
		dateFim = DATE_FIM;
	}

	@Test
	public void testListaTransacoesPorPeriodoComConteudo() {
		when(service.listaTransacoesPorPeriodo(dataInicio, dataFim)).thenReturn(listapesquisa);
		ResponseEntity<List<Transacoes>> retorno = resource.buscaTransacoesPorPeriodo(dataInicio, dataFim);
		assertThat(retorno.getStatusCode(), is(HttpStatus.OK));
		assertNotNull(retorno);
	}
}
