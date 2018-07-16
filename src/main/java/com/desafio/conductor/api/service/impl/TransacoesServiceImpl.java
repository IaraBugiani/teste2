package com.desafio.conductor.api.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.conductor.api.model.Transacoes;
import com.desafio.conductor.api.repository.TransacoesRepository;

@Service
@Transactional
public class TransacoesServiceImpl implements TransacoesService {
	
	@Autowired
	private TransacoesRepository repository;

	
	@Override
	@Transactional(readOnly = true)
	public List<Transacoes> listaTransacoesPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
		List<Transacoes> lista = repository.findByDataBetween(dataInicio, dataFim);
		if(!lista.isEmpty()) {
			escreveArquivo(lista);
		}
		return lista;
	}
	
	private void escreveArquivo(List<Transacoes> transacoes) {
		
		File diretorio = new File("C:\\Teste_Iara");
		diretorio.mkdirs();
		File arquivo = new File(diretorio,"Transacoes_" + LocalDate.now() + ".txt");
		try {
			arquivo.createNewFile();
			
			FileWriter file = new FileWriter(arquivo,false);
			
			PrintWriter escreve = new PrintWriter(file);
			
			for(Transacoes listaTransacoes : transacoes ) {
				escreve.println(listaTransacoes.getCartao() + ";" + listaTransacoes.getValorTransacao() + ";" + listaTransacoes.getData() + ";");
			}
			escreve.flush();
			escreve.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
