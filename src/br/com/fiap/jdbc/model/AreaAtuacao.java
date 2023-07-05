package br.com.fiap.jdbc.model;


import java.util.ArrayList;
import java.util.List;

public class AreaAtuacao {
	
	private int idArea;
	private String nome;
	private List<Candidato> candidatos;

	public AreaAtuacao() {
		this.candidatos = new ArrayList<Candidato>();
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void addCandidatoLista(Candidato candidato) {
		this.candidatos.add(candidato);
	}
	
	

}
