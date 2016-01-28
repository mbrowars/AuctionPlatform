<!-- Hier brauche ich:
Session -> Als Admin eingeloggt?
Arraylist mit den Auktionen
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>My inheritance</title>
</head>
<body>
	<ul id="nav">
		<a class="navlink" href="index.jsp"><li id="logo"><img
				src="${pageContext.request.contextPath}/img/logo2.png"></li></a>
		<a class="navlink" href="index.jsp"><li id="slog">Buy my
				gramp's stuff</li></a>
		<a class="navlink" href="listing.jsp"><li id="login">+Neue
				Auktion</li></a>
	</ul>


	<form action="/">
		<div id="actionbar">
			<!-- title -> Suchstring für Name
				 price -> Maximalgebot
				 sort  -> Sortierung für die ResultList
			 -->
			
			<input name="title" id="title" placeholder="Name"> <input
				type="number" name="price" id="price" placeholder="Maximalpreis">
			<select id="sort" name="sort">
				<option value="none">Sortierung</option>
				<option value="price">Preis</option>
				<option value="age">Datum</option>
				<option value="name">Name</option>
			</select>
			<button type="submit">Suchen</button>
			
		</div>
	</form>
	<div id="sep"></div>

	<div class="listing">
		<p class="title">Super awesome shit</p>
		<a class="listlink"
			href="${pageContext.request.contextPath}/auction.jsp"><div
				id="placeholder"></div></a>
		<p class="price">
			Currently at <span>$32.00</span>
		<p>
			<button class="ourButton">Ändern</button>
			<button class="ourButton">Löschen</button>
	</div>

</body>
</html>