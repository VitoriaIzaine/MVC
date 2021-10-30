/**
 * Feito por:
 * Ana Beatriz ---------- Ht191054x
 * Priscila Alves ------- Ht1910299
 * Vitória Santos ------- Ht191085x
 * 
 * Última modificação:
 * 05/08/2020
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Filme;
import model.FilmeDAO;

/**
 * Servlet implementation class FilmeController
 */
@WebServlet("/FilmeController")
public class FilmeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FilmeDAO filmesDAO;

	@Resource(name="jdbc/filmes")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		filmesDAO = new FilmeDAO(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar": {
			listarFilmes(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + acao);
		}
	}

	private void listarFilmes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Controller: listarTarefas");
		
		List<Filme> cinemateca = new ArrayList<>();
		cinemateca = filmesDAO.consultaFilmes();
		
		// Adiciona lista de filmes no objeto "request"
		request.setAttribute("lista_filmes", cinemateca);
		
		// Cria o objeto de dispatcher e indica a página que receberá a requisição
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viewFilmes.jsp");

		// Enviar a resposta para o JSP
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost");
		
		String acao = request.getParameter("acao");
		acao = acao.toLowerCase();
		
		System.out.println(acao);
		
		switch (acao) {
		case "cadastrar": {
			cadastrarFilmes(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + acao);
		}
	}

	private void cadastrarFilmes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("Controller: cadastrarFilmes");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD><title>FILME</title></HEAD>");
		out.println("<body>");
		out.println("<h1>CADASTRO EM IMPLEMENTAÇÃO!</h1>");
		out.println("</body>");
		out.println("</HTML>");
		
	}

}
