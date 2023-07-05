package br.com.fiap.teste;

import java.sql.SQLException;

import br.com.fiap.jdbc.controller.CandidatoController;
import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;

public class Teste {

	public static void main(String[] args) throws SQLException {

		CandidatoController dao = new CandidatoController();
		
		Candidato matheus = new Candidato(1,"Matheus", "Masculino", 12,"tecnico","1199854","math@gmail","bom jesus",2);
	
	
		
		dao.insert(matheus);
		
		dao.insert(matheus);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		dao.insert(adriane);
		

//		List<Candidato> candidatos = dao.findAll();
//		for (Candidato candidatos1 : candidatos) {
//			System.out.println(candidatos1.getIdCandidato());
//			System.out.println(candidatos1.getNome());
//			System.out.println(candidatos1.getEmail());
//			System.out.println(candidatos1.getDataNasc());
//		}
	
//		Usuario usuario = dao.selectById(1);
//
//			System.out.println(usuario.getId());
//			System.out.println(usuario.getNome());
//			System.out.println(usuario.getEmail());
//			System.out.println(usuario.getDataCadastro());
	}
}