package br.com.drogaria.factury;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactury {
	private static final String USUARIO = "root";
	private static final String SENHA = "Kiko1998";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useSSL=false&useTimezone=true&serverTimezone=UTC";

	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
		Connection conexao = ConexaoFactury.conectar();
		System.out.println("Conex�o realizada com sucesso");
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Conex�o n�o realizada");
			
		}
	}
}
