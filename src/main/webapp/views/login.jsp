<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Acesso ao sistema</title>

<!-- Bootstrap core CSS -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Login CSS -->
<link href="resources/css/login.css" rel="stylesheet">


<style type="text/css">
#userimage {
	float: left;
	margin: 0 0 10px 10px;
}
</style>

</head>
<body>

	<div class="container">
		<form class="form-signin" role="form" action="logon" method="post">
			<img id="userimage" alt="Usuário" src="resources/img/user.png">
			<h2 class="form-signin-heading">Faça seu login</h2>

			<input type="email" name="usuario" class="form-control" placeholder="Email address" required autofocus> 
			<input type="password" name="senha" class="form-control" placeholder="Password" required>

			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Lembrar
				</label>
			</div>

			<a href="#recuperar-usuario-senha">Esqueci meu usuário e/ou senha</a>			

			<button class="btn btn-lg btn-primary btn-block" type="submit">Acessar</button>
		</form>

	</div>
	<!-- /container -->

	

	<script src="resources/jquery/jquery.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>