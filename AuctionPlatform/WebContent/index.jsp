<!-- Hier brauche ich:
Session -> Als Admin eingeloggt?
Arraylist mit den Auktionen
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="auctionApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.js"></script>
<script src="js/controller.js" ></script>
<script src="js/index.js"></script>
<title>My inheritance</title>
</head>
<body ng-controller="auctionCtrl">
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
			
			<input placeholder="Suche" ng-model="query">
			<input type="number" name="price" id="price" placeholder="Maximalpreis">
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
	<div id="listings">
		<div class="listing" ng-repeat="auction in auctions | filter: query">
			<p class="title">{{auction.name}}</p>
			<a class="listlink"
				href="${pageContext.request.contextPath}/auction.jsp"><div
					id="placeholder"></div></a>
			<p class="price">
				Currently at <span>{{auction.price}}€</span>
			<p>
				<button class="ourButton">Ändern</button>
				<button class="ourButton">Löschen</button>
		</div>
	</div>

</body>
</html>