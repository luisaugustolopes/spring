<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<title>Página JSP</title>

<link rel="stylesheet"	href="../resources/bootstrap/css/bootstrap.min.css" />

</head>

<body>

	<nav class="navbar navbar-default navbar-static-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="../index.jsp">Index</a>
		<button class="navbar-toggle" type="button"
			data-target=".navbar-collapse" data-toggle="collapse">menu</button>
	</div>
	<ul class="nav navbar-nav collapse navbar-collapse">
		<li><a href="#">Sobre</a></li>
		<li><a href="#">Ajuda</a></li>
		<li><a href="#">Perguntas frequentes</a></li>
		<li><a href="#">Entre em contato</a></li>
	</ul>
	</nav>


	<div class="container">

		<h1>Spring 3 MVC REST web service</h1>

		<c:if test="${historia.numero ==0}">
			<p>História não localizada</p>
		</c:if>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">Dados da História</div>
			<div class="panel-body">
				<p>Informações relevantes da história selecionada</p>
			</div>

			<!-- Table -->
			<table class="table">
				<tr>
					<td>Número</td>
					<td>Descrição</td>
					<td>Resumo</td>
					<td>Data</td>
				</tr>
				<tr>
					<td>${historia.numero}</td>
					<td>${historia.descricao }</td>
					<td>${historia.resumo }</td>
					<td><fmt:formatDate value="${historia.data.time}" type="date"
							dateStyle="medium" /></td>
				</tr>
			</table>
		</div>

	<form action="/controleOS/historia/">
		<div class="btn-group">
			<button type="submit" class="btn btn-default" onclick="">Encerrar História</button>
			<button type="button" class="btn btn-default">Alterar Situação OS</button>
			<button type="button" class="btn btn-default">Right</button>
		</div>
	</form>

	</div>
	<script src="../resources/jquery/jquery.js"></script>
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>