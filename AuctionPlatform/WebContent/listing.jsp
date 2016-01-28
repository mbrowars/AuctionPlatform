<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>My inheritance</title>
</head>
<body>
	<ul id="nav">
		<a class="navlink" href="index.jsp"><li id="logo"><img src="${pageContext.request.contextPath}/img/logo2.png"></li></a>
		<a class="navlink" href="index.jsp"><li id="slog">Buy my gramp's stuff</li></a>
		<li id="login">Neue Auktion erstellen</li>
	</ul>
	
	<!-- 
		picture -> Bild
		title -> Titel
		bid -> Stargebot
		end -> Auktionsende
		desc -> Beschreibung
		id -> AuktionsID (leer wenn neue Auktion, enthält ID wenn 
							vorhandene Auktion bearbeitet wird)
	 -->
	
	<div class="container">
		<form action="/">
			<input type="file" name="picture" />
			<input placeholder="Titel" name="title" />
			<input placeholder="Startgebot" name="bid" />
			<input placeholder="Auktionsende" name="end" />
			<textare placeholder="Beschreibung" name="desc" />
			<input placeholder="AuktionsID" name="id" />
			<button type="submit">Bestätigen</button>
		</form>
	</div>
	
	<script src="${pageContext.request.contextPath}/js/custom-file-input.js"></script>
	
</body>
</html>