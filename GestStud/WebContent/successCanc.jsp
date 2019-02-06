<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<h1>Hai cancellato l'utente con matricola <% out.print(request.getParameter("matricola")); %></h1>
		</div>
		<p align="center"><a href="PaginaIniziale.html" title="Pagina Iniziale">Torna al men&ugrave; principale</a></p>
	</body>
</html>



