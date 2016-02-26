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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/range.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/select.css"
	type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<script src="js/controller.js"></script>
<script src="js/select.js"></script>
<script src="js/index.js"></script>
<title>My inheritance</title>
</head>

<body ng-controller="auctionCtrl">
	<ul id="nav">
		<%	if (session.getAttribute("admin") != null) { %>
		<a class="navlink" href="/AuctionPlatform/logout"><li id="logo"><img
				src="${pageContext.request.contextPath}/img/logout.png" class="wiggle-me"></li></a>
		<% } else { %>
		<a class="navlink" href="/AuctionPlatform/index"><li id="logo"><img
				src="${pageContext.request.contextPath}/img/logo2.png"></li></a>
		<% } %>
		
		<a class="navlink" href="/AuctionPlatform/index"><li id="slog">Buy
				my gramp's stuff</li></a>
		<%
			if (session.getAttribute("admin") != null) {
		%><a class="navlink" href="listing.jsp"><li id="login">+Neue
				Auktion</li></a>
		<%
			}
		%>
	</ul>


	<div id="actionbar">
		<!-- title -> Suchstring für Name
				 price -> Maximalgebot
				 sort  -> Sortierung für die ResultList
			 -->

		<input class="ourText" placeholder="Suche" ng-model="query"> <input
			type="range" min="1" max="{{maxPrice+1}}" value="{{maxPrice}}"
			id="price" ng-model="price" oninput="updateRangeVal(this);" />
		<div id="rangeVal">{{(price) || maxPrice+1}}€</div>
		<select id="sort" class="turnintodropdown" ng-model="sort">
			<option value="">Sortierung</option>
			<option value="price">Preis</option>
			<option value="Laufzeit">Datum</option>
			<option value="name">Name</option>
		</select>
		<section class="main">
		<div class="wrapper-demo">
			<div id="dd" class="wrapper-dropdown-3">
				<span>Sortierung</span>
				<ul class="dropdown">
					<li><a href="#">Preis</a></li>
					<li><a href="#">Restlaufzeit</a></li>
					<li><a href="#">Titel</a></li>
				</ul>
			</div>
		</div>
		</section>

	</div>

	<div id="sep" data-servertime="<%=request.getAttribute("date")%>"></div>

	<div id="listings">
		<div class="listing"
			ng-repeat="auction in auctions | filter:{name: query} | filter: lessThan('price', (price) || 1000000) | orderBy:sort">
			<p class="title">{{ auction.name |
				limitTo:16}}{{auction.name.length > 16 ? '&hellip;' : ''}}</p>
			<p class="timer" data-time="{{auction.Laufzeit}}"
				data-id="{{auction.Id}}">--</p>
			<a class="listlink"
				href="${pageContext.request.contextPath}/auction?id={{auction.Id}}">
				<img
				src="${pageContext.request.contextPath}/pictures/{{auction.Picture}}"
				style="height: 250px; width: 250px;"></img>
			</a>
			<p class="price">
				Currently at <span>{{auction.price | number:2}}€</span>
			</p>
			<%
				if (session.getAttribute("admin") != null) {
			%>
			<a
				href="${pageContext.request.contextPath}/edit.jsp?id={{auction.Id}}"><button
					class="ourButton">Ändern</button></a>
			<button id="{{'del' + auction.Id}}" class="ourButton"
				onclick="delAuction(this);">Löschen</button>
			<%
				}
			%>
		</div>
	</div>

</body>
</html>