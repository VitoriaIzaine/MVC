<% /**
  Feito por:
  Ana Beatriz ---------- Ht191054x
  Priscila Alves ------- Ht1910299
  Vitória Santos ------- Ht191085x
  
  Última modificação:
  05/08/2020
**/ %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Filme"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
	<title>Filmes</title>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta description="Página principal de cadastro e listagem de filme e series">
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='shortcut icon' href='../webapp/css/imagens/logo.svg'>
    <link rel='stylesheet' href='main.css'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
</head>
<body class="viewEstil">
<center>

	<jsp:include page="Cabecalho.html" />
	
<%
	List<Filme> cinemateca = new ArrayList<>();
	cinemateca = (ArrayList) request.getAttribute ("lista_filmes");
%>

	<table>
	  <tr>
	    <th>Nome</th>
	    <th>Genero</th>
	    <th>Plataforma</th>
	    <th>Status</th>
	    <th>Avaliação</th>
	  </tr>
	  
	  <% for(Filme filme : cinemateca){
		  out.print("<tr>");
		  out.println("<td>" + filme.getNome() +"</td>");
		  out.println("<td>" + filme.getGenero() +"</td>");
		  out.println("<td>" + filme.getPlataforma() +"</td>");
		  out.println("<td>" + filme.getStatus() +"</td>");
		  out.println("<td>" + filme.getAvaliacao() +"</td>");
		  out.print("</tr>");
	  	}
	  %>
	</table>
</center>
<br><br><br>
        <div class="rodape">
        
        </div>
</body>
</html>