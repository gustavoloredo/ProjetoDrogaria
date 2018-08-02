package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factury.ConexaoFactury;;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactury.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());

		comando.executeUpdate();
	}
	
	public void excluir (Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ?");
		
		Connection conexao = ConexaoFactury.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setLong(1, f.getCodigo());
				comando.executeUpdate();
	}
		public void editar(Fabricante f) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE fabricante ");
			sql.append("SET descricao = ? ");
			sql.append("WHERE codigo = ?");
			
			Connection conexao = ConexaoFactury.conectar();
			
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, f.getDescricao());
			comando.setLong(2, f.getCodigo());
			
			comando.executeUpdate();
		}
	
	
	public static void main(String[] args) {
	/*	Fabricante f1 = new Fabricante();
		f1.setDescricao("Descrição 1");
		Fabricante f2 = new Fabricante ();
		f2.setDescricao("Descrição 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.salvar(f1);	
			fdao.salvar(f2);
			System.out.println("Fabricantes salvos com sucessos");
		} catch (SQLException e) {
			System.out.println("Ocorreu erro ao salvar fabricante");
			e.printStackTrace();
		}*/
	/*
		Fabricante f1 = new Fabricante();
		Fabricante f2 = new Fabricante();
		f1.setCodigo(2L);
		f2.setCodigo(4L);
		FabricanteDAO fdao = new FabricanteDAO ();
		try {
			fdao.excluir(f1);
			fdao.excluir(f2);
			System.out.println("Fabricantes excluidos com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar fabricante");
			e.printStackTrace();
		}*/
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(3L);
		f1.setDescricao("Descrição 3");
		
		FabricanteDAO fdao = new FabricanteDAO ();
		try {
			fdao.editar(f1);
			System.out.println("Fabricante editado com sucesso");
		} catch (SQLException e) {
			System.out.println("Problema ao editar fabricante");
			e.printStackTrace();
		}
	}
}
