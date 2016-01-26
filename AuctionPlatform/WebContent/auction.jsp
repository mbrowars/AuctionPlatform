<!-- Hier brauche ich:
Name, Gebot und Ende der ausgewählten Auktion
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>My inheritance</title>
</head>
<body>
	<ul id="nav">
		<a class="navlink" href="index.jsp"><li id="logo"><img src="${pageContext.request.contextPath}/img/logo2.png"></li></a>
		<a class="navlink" href="index.jsp"><li id="slog">Buy my gramp's stuff</li></a>
		<li id="login">+Neue Auktion</li>
	</ul>

	<div id="auctiontop">
		<div id="auctionpic">
			<div id="placeholder"></div>
		</div>
		<div id="auctionbid">
			<p>Name</p>
			<p>Gebot</p>
			<p>Restdauer</p>
			<div>
				<input name="bid" id="bid" placeholder="Gebot">
				<button type="button" id="showModal" class="ourButton">Bieten</button>
			</div>
		</div>
	</div>
	
	<div id="sep"></div>
	
	<p id="desc">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
		Maecenas vel semper massa. Ut at interdum tortor. Etiam 
		sit amet convallis odio. Sed fermentum velit lorem, non 
		viverra sapien aliquet et. Nunc at mattis mi. Etiam erat 
		purus, mattis in cursus a, tincidunt porta nisl. Class 
		aptent taciti sociosqu ad litora torquent per conubia 
		nostra, per inceptos himenaeos. Integer lacinia pretium 
		eros quis elementum.
		<br/>
		Vestibulum sed augue in turpis dignissim tincidunt ut quis 
		diam. Phasellus venenatis vel augue quis laoreet. Cras nulla 
		lectus, faucibus sed tortor in, finibus convallis metus. 
		Class aptent taciti sociosqu ad litora torquent per conubia 
		nostra, per inceptos himenaeos. Nunc eu libero eget justo 
		aliquam mattis non eget dui. Morbi ac feugiat lorem, eu 
		tincidunt erat. Sed fermentum ex a pellentesque lacinia. 
		Fusce quis tincidunt velit.
	</p>
	
	
	
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
		        <input placeholder="E-Mail Adresse" id="mail">
		        <button id="sendCode" class="ourButton">Senden</button>
	        </p>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="${pageContext.request.contextPath}/js/auction.js"></script>
	
</body>
</html>