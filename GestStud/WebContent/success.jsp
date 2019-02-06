<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Risultato ricerca</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
		<div class="jumbotron text-center">
			<h1>Hai inserito i seguenti dati:</h1>
		</div>
		<div class="container">
		<table class="table table-striped">
			<tr>
				<th>Nome:</th>
				<td><% out.print(request.getParameter("nome")); %></td>
			</tr>
			<tr>
				<th>Cognome:</th>
				<td><% out.print(request.getParameter("cognome")); %></td>
			</tr>
			<tr>
				<th>Matricola:</th>
				<td><% out.print(request.getParameter("matricola")); %></td>
			</tr>
			<tr>
				<th>Indirizzo:</th>
				<td><% out.print(request.getParameter("indirizzo")); %></td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><% out.print(request.getParameter("telefono")); %></td>
			</tr>
		</table>
		</div>
	<p align="center"><a href="PaginaIniziale.html" title="Pagina Iniziale">Torna al men&ugrave; principale</a></p>
	</body>
</html>



