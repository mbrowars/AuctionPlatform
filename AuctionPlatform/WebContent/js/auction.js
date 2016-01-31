$(function() {
	$("#sendCode").click(function(){

		$.ajax({
			  type: "POST",
			  url: "/AuctionPlatform/auction",
			  data: { 'mail': $("#mail").val(),
				  	  'bid' : $("#bid").val()},

			  beforeSend: function(){
				$(".modal-body span").html('<img src="img/spinner.gif">');  
			  },
			  success: function() {
				$(".modal-body span").html("<span style='color: green;'> E-Mail wurde erfolgreich versendet!</span>");
				$(".modal-body p").html('<label>Code</label><input placeholder="Bestätigungscode" id="code"><button id="testCode" class="ourButton">Senden</button>');
			},
			  error: function() {
				$(".modal-body span").html("<span style='color: red;'> E-Mail konnte nicht versendet werden!</span>");
			}
		});
		
		
		$("#bid").val("");
	});
	
	$("#showModal").click(function(){
		$("span#bidtext").html($("#bid").val() + "€");
		$("#BidModal").modal("show");
	});
});

$('body').on('click','#testCode',function(){
	$.ajax({
		  method: "POST",
		  url: "/AuctionPlatform/auction",
		  data: { code: $("#code").val() },
		
		  beforeSend: function(){
			$(".modal-body p").html('<img src="img/spinner.gif">');  
		  },
		  success: function() {
		    $(".modal-body p").html("<span style='color: green;'>Gebot wurde erfolgreich bestätigt!</span>");
		  },
		  error:  function() {
		    $(".modal-body p").html("<span style='color: red;'>Fehler: Gebot wurde nicht bestätigt.</span>");
		  }
	});
	
	$("#bid").val("");
});