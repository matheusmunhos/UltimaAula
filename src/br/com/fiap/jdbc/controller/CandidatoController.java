package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.jdbc.dao.CandidatoDAO;
import br.com.fiap.jdbc.factory.ConnectionFactory;
import br.com.fiap.jdbc.model.Candidato;

public class CandidatoController {

	private CandidatoDAO candidatoDAO;

	public CandidatoController() {
		Connection connection = new ConnectionFactory().conectarOracle();
		this.candidatoDAO = new CandidatoDAO(connection);
	}

	public void delete(Integer IdCandidato) {
		this.candidatoDAO.delete(IdCandidato);
	}

	public void insert(Candidato candidato) {
		this.candidatoDAO.insert(candidato);
	}

	public List<Candidato> findAll() {
		return this.candidatoDAO.findAll();
	}

	public void update(Candidato candidato) {
		this.candidatoDAO.update(candidato);
	}

}
