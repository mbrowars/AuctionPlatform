<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>My inheritance</title>
</head>
<body>
	<ul>
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
			<form action="/">
				<input name="bid" placeholder="Gebot">
			</form>
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
</body>
</html>