package br.com.fiap.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jdbc.model.Candidato;

public class CandidatoDAO {

	Connection connection;

	public CandidatoDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Candidato candidato) {
		String sql = "INSERT INTO Candidato (idcandidato, nome, data_Nasc, genero, tempo_experiencia, "
				+ "formacao, telefone, email, endereco, idArea) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, candidato.getIdCandidato());
			stmt.setString(2, candidato.getNome());
			stmt.setDate(3, candidato.getDataNasc());
			stmt.setString(4, candidato.getGenero());
			stmt.setFloat(5, candidato.getTempoExperiencia());
			stmt.setString(6, candidato.getFormacao());
			stmt.setString(7, candidato.getTelefone());
			stmt.setString(8, candidato.getEmail());
			stmt.setString(9, candidato.getEndereco());
			stmt.setInt(10, candidato.getIdArea());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Candidato candidato) {
		String sql = "UPDATE Candidato SET nome = ?, data_Nasc = ?, genero = ?, tempo_experiencia = ?, "
				+ "formacao = ?, telefone = ?, email = ?, endereco = ?, idArea = ? Where idCandidato = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setDate(2, candidato.getDataNasc());
			stmt.setString(3, candidato.getGenero());
			stmt.setFloat(4, candidato.getTempoExperiencia());
			stmt.setString(5, candidato.getFormacao());
			stmt.setString(6, candidato.getTelefone());
			stmt.setString(7, candidato.getEmail());
			stmt.setString(8, candidato.getEndereco());
			stmt.setInt(9, candidato.getIdArea());
			stmt.setInt(10, candidato.getIdCandidato());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM Candidato WHERE idCandidato = ?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Candidato> findAll() {
		List<Candidato> candidatos = new ArrayList<Candidato>();
		String sql = "Select idCandidato, nome, data_Nasc, genero, tempo_experiencia, "
				+ "formacao, telefone, email, endereco, idArea from Candidato";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Candidato candidato = new Candidato();
				candidato.setIdCandidato(rs.getInt(1));
				candidato.setNome(rs.getString(2));
				candidato.setDataNasc(rs.getDate(3));
				candidato.setGenero(rs.getString(4));
				candidato.setTempoExperiencia(rs.getFloat(5));
				candidato.setFormacao(rs.getString(6));
				candidato.setTelefone(rs.getString(7));
				candidato.setEmail(rs.getString(8));
				candidato.setEndereco(rs.getString(9));
				candidato.setIdArea(rs.getInt(10));
				candidatos.add(candidato);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidatos;
	}

	public Candidato findById(int id) {
		String sql = "Select idCandidato, nome, data_Nasc, genero, tempo_experiencia, "
				+ "formacao, telefone, email, endereco, idArea from Candidato";
		PreparedStatement stmt;
		Candidato candidato = new Candidato();
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				candidato.setIdCandidato(rs.getInt(1));
				candidato.setNome(rs.getString(2));
				candidato.setDataNasc(rs.getDate(3));
				candidato.setGenero(rs.getString(4));
				candidato.setTempoExperiencia(rs.getFloat(5));
				candidato.setFormacao(rs.getString(6));
				candidato.setTelefone(rs.getString(7));
				candidato.setEmail(rs.getString(8));
				candidato.setEndereco(rs.getString(9));
				candidato.setIdArea(rs.getInt(10));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return candidato;
	}
}
