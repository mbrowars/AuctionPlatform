<!-- Hier brauche ich:
Name, Gebot und Ende der ausgewählten Auktion
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="auctionApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/js/controller.js"></script>
<script src="${pageContext.request.contextPath}/js/auction.js"></script>
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
		<a class="navlink" href="/AuctionPlatform/index"><li id="slog">Buy my gramp's stuff</li></a>
		<% if( session.getAttribute("admin") != null) { %><a class="navlink" href="listing.jsp"><li id="login">+Neue Auktion</li></a><% } %>
	</ul>
	
	<span ng-repeat="auction in auctions | filter:{Id: ${auction.getAuctionid()}} | limitTo: 1">
		<div id="auctiontop">
			<div id="auctionpic">
				<img
				src="${pageContext.request.contextPath}/pictures/{{auction.Picture}}"
				style="height: 250px; width: 250px;" alt="{{auction.name}}"></img>
			</div>
			<div id="auctionbid">
				<p>{{auction.name}}</p>
				<p id="gebot">{{auction.price}}€</p>
				<p class="timer" data-time="{{auction.Laufzeit}}" data-servertime="<%= request.getAttribute("date") %>">--</p>
				<div>
					<input name="bid" id="bid" placeholder="Gebot">
					<div style="display: none;" id="id">${auction.getAuctionid()}</div>
					<%	if (session.getAttribute("admin") == null) { %>
						<button type="button" onclick="showMyModal();" id="showModal" class="ourButton">Bieten</button>
					<% } else { %>
						<button type="button" disabled onclick="showMyModal();" id="showModal" class="ourButton">Bieten</button>
					<% } %>
				</div>
			</div>
		</div>
		
		<div id="sep"></div>
		
		<p id="desc">
			{{auction.Beschreibung}}
		</p>
	</span>
	
	
	<div class="modal fade" id="BidModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">Bestätigung Ihres Gebots</h4>
	      </div>
	      <div class="modal-body">
	        <span>Zur Abgabe Ihres Gebotes über <span id="bidtext"></span> müssen sie Ihre E-Mail verifizieren.</span>
	        <br><br>
	        <p>
	        	<!-- mail -> E-Mail zu der der Code gesendet werden soll -->
		        <label>E-Mail</label>
		        <input type="email" placeholder="E-Mail Adresse" id="mail">
		        <button id="sendCode" class="ourButton">Senden</button>
	        </p>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>