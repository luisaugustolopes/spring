<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">

<title>Página JSP</title>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />

</head>
<body>

	<nav class="navbar navbar-default navbar-static-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="index.jsp">Index</a>
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


	<h1>Página JSP</h1>
	<%-- O mesmo atributo 'data' que definimos no model --%>
	<p>Data: ${data}</p>

	<c:if test="${empty username }">
		<p>Você não está logado, <a href="login">clique aqui</a> para efetuar o login</p>
	</c:if>
	<c:if test="${not empty username }">
		<p>Bem vindo ${username }. Se não for você, <a href="logout">clique aqui</a></p>
		<p>Sua sessão irá expirar em: ${pageContext.session.maxInactiveInterval / 60 } minutos</p>
	</c:if>
	
	<div class="btn-group">
		<button type="button" class="btn btn-default">1</button>
		<button type="button" class="btn btn-default">2</button>

		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				Dropdown <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#">Dropdown link</a></li>
				<li><a href="#">Dropdown link</a></li>
			</ul>
		</div>
	</div>

	<!-- Large button group -->
	<div class="btn-group btn-group-lg">...</div>
	<div class="btn-group">...</div>
	<div class="btn-group btn-group-sm">...</div>
	<div class="btn-group btn-group-xs">...</div>

	<script src="resources/jquery/jquery.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>