package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import javax.sql.DataSource;


// Classe que irá acessar o banco de dados.
public class FilmeDAO {
	
	private DataSource datasource;
	
	public FilmeDAO(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	public List<Filme> consultaFilmes(){
		
		List<Filme> listaFilmes = new ArrayList<>();
		
		Connection myConn = null;
		Statement statement = null;
		ResultSet myResult = null;
		
		
		try {
			myConn = datasource.getConnection();
			String sql = "select * from filme;";
			statement = myConn.createStatement();
			myResult = (statement).executeQuery(sql);
			
			while( myResult.next()) {
				int id = myResult.getInt("id_filme");
				String nome = myResult.getString("nome");
				String genero = myResult.getString("genero");
				String plataforma = myResult.getString("plataforma");
				String status = myResult.getString("status_film");
				int avaliacao = myResult.getInt("avaliacao");
				
				
				Filme filme = new Filme(nome, genero, plataforma, status, avaliacao);
				listaFilmes.add(filme);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fecharConexao(myConn, statement, myResult);
			
		}
		
		return listaFilmes;
		
	}

	private void fecharConexao(Connection myConn, Statement statement, ResultSet myResult) {

		try {
			if (myConn != null)
				myConn.close();

			if (statement != null)
				statement.close();

			if (myResult != null)
				myResult.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
