package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TesteBD
 */
@WebServlet("/ConexaoBD")
public class ConexaoBD extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConexaoBD() {
        // TODO Auto-generated constructor stub
    }

    @Resource(name ="jdbc/meu_banco")
    private DataSource datasource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plan");
		
		//Conexão com o banco
		Connection myConn = null;
		Statement statement = null;
		ResultSet myResult = null;
		
		
		try {
			out.println("Antes de mais nada...");
			
			myConn = datasource.getConnection();
			
			String sql = "select * from exemplo;";
			
			out.println("Cria conexão...");
			
			statement = myConn.createStatement();
			
			out.println("Cria statemente...");
			
			myResult = statement.executeQuery(sql);
			out.println("executa query...");
			
			while(myResult.next()) {
				
				int id = myResult.getInt("id_filme");
				String nome = myResult.getString("nome");
				String genero = myResult.getString("genero");			
				String plataforma = myResult.getString("plataforma");
				String status = myResult.getString("status_film");
				int avaliacao = myResult.getInt("avaliacao");
				
				out.print("<tr>");
				out.println("<td>" + id +"</td>");
				out.println("<td>" + nome +"</td>");
				out.println("<td>" + genero +"</td>");
				out.println("<td>" + plataforma +"</td>");
			    out.println("<td>" + status +"</td>");
				out.println("<td>" + avaliacao +"</td>");
				out.print("</tr>");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			out.println("Não consegui conectar com o banco.");
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
