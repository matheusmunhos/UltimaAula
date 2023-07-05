package br.com.fiap.jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.model.AreaAtuacao;
import br.com.fiap.jdbc.model.Candidato;

public class AreaAtuacaoDAO {
	Connection connection;

	public AreaAtuacaoDAO(Connection connection) {
		this.connection = connection;
	}

	public List<AreaAtuacao> findAll() {
		List<AreaAtuacao> areas = new ArrayList<AreaAtuacao>();
		String sql = "select idArea, nome from area_atuacao";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AreaAtuacao area = new AreaAtuacao();
				area.setIdArea(rs.getInt(1));
				area.setNome(rs.getString(2));
				areas.add(area);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areas;
	}

	public List<AreaAtuacao> findCandidate() {
		List<AreaAtuacao> areas = new ArrayList<AreaAtuacao>();
		try {
			String sql = "select a.idArea, a.nome, c.nome, c.data_nasc, c.idCandidato from area_atuacao a inner join candidato c on a.idArea = c.idArea";
			PreparedStatement stmt;
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			AreaAtuacao areaAtuacaoAtual = null;

			while (rs.next()) {
				if (areaAtuacaoAtual == null || !areaAtuacaoAtual.getNome().equals(rs.getString(2))) {
					AreaAtuacao area = new AreaAtuacao();
					area.setIdArea(rs.getInt(1));
					area.setNome(rs.getString(2));
					areas.add(area);
					areaAtuacaoAtual = area;
				}
				Candidato candidato = new Candidato();
				candidato.setNome(rs.getString(3));
				candidato.setDataNasc(rs.getDate(4));
				candidato.setIdCandidato(rs.getInt(5));
				areaAtuacaoAtual.addCandidatoLista(candidato);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areas;
	}

}
