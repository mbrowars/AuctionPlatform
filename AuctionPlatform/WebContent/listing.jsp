<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/fileinput.js"></script>
<title>My inheritance</title>
</head>
<body>
	<ul id="nav">
		<a class="navlink" href="/AuctionPlatform/index"><li id="logo"><img
				src="${pageContext.request.contextPath}/img/logo2.png"></li></a>
		<a class="navlink" href="/AuctionPlatform/index"><li id="slog">Buy
				my gramp's stuff</li></a>
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
	<%
		if (session.getAttribute("admin") != null) {
	%>

	<br />
	<div class="login-block">
		<h1>Neue Auktion</h1>
		<form action="createAuction" method="post" enctype="multipart/form-data">
			<input type="file" id="file" name="picture"	onchange="updateFName(this);" />
			<div id="filereplace" onclick="simulFile();">Datei auswählen ...</div>
			<input placeholder="Titel" name="title" type="text" oninput="check(this, true);" autocomplete="off" autocapitalize="off" autocorrect="off" /> 
			<input id="bidinput" placeholder="Startgebot" name="bid" type="text" oninput="check(this, true);" autocomplete="off" autocapitalize="off" autocorrect="off" /> 
			<input placeholder="Auktionsende z.B. 02.04.2016 21:00" name="end" type="text" oninput="check(this, true);" autocomplete="off" autocapitalize="off" autocorrect="off" /> 
			<textarea placeholder="Beschreibung" name="desc" oninput="check(this, true);" autocomplete="off" autocapitalize="off" autocorrect="off" ></textarea>
			<button disabled onhover="checkall(false);" >Submit</button>
			
		</form>
	</div>

	<%
		} else {
	%>
	<p
		style="margin-top: 30px; text-align: center; color: red; font: 28px 'Arial-Black';">Sie
		sind nicht berechtigt diese Seite anzuzeigen!</p>
	<%
		}
	%>
</body>
</html>