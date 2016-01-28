<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>My inheritance</title>
</head>
	<body>
	
		<ul id="nav">
			<a class="navlink" href="index.jsp"><li id="logo"><img src="${pageContext.request.contextPath}/img/logo2.png"></li></a>
			<a class="navlink" href="index.jsp"><li id="slog">Buy my gramp's stuff</li></a>
			<li id="login">Admin Login</li>
		</ul>
	
		<div class="logo"></div>
		<div class="login-block">
		    <h1>Login</h1>
		    <form action="goadmin">
			    <input type="text" value="" placeholder="Username" id="username" name="username" />
			    <input type="password" value="" placeholder="Password" id="password" name="password" />
			    <button>Submit</button>
		    </form>
		</div>
	
	</body>
</html>