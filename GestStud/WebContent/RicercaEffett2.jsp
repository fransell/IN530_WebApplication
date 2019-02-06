<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "it.uniroma3.persistence.*,it.uniroma3.studenti.*,java.util.LinkedList,java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Risultato ricerca</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script src="bootstrap.js"></script>
	</head>
	<body>
	<div class="jumbotron text-center">
		<h1>La ricerca ha prodotto i seguenti risultati:</h1>
	</div> 
	<table class="table table-striped">
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Matricola</th>
			<th>Indirizzo</th>
			<th>Telefono</th>
		</tr>	
			<% List<Studente> stud = new LinkedList<>();
				stud = (List<Studente>)request.getAttribute("studenti");
			%>
			<% for(Studente s:stud){ %>
				<tr>
					<td> <% out.print(s.getNome());%></td>				
					<td> <% out.print(s.getCognome());%></td>
					<td> <% out.print(s.getMatricola());%></td>
					<td> <% out.print(s.getIndirizzo());%></td>
					<td> <% out.print(s.getTelefono());%></td>
					<td> <form action="cancella" method="get">
								<%String matricola = s.getMatricola();%>
								<input type="hidden" name="matricola" value="<%=matricola%>"></input>
								<a href="#" onclick="parentNode.submit();">Elimina</a>
			 			</form>
					</td>
				</tr>
				<%}%>		
	</table>
	<p align="center"><a href="PaginaIniziale.html" title="Pagina Iniziale">Torna al men&ugrave; principale</a></p>
	</body>
</html>
