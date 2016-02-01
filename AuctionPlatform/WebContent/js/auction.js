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
			  success: function(resp) {
				  if(resp=="null") {
					$(".modal-body span").html("<span style='color: green;'>E-Mail wurde erfolgreich versendet!</span>");
					$(".modal-body p").html('<label>Code</label><input placeholder="Bestätigungscode" id="code"><button id="testCode" class="ourButton">Senden</button>');
					$("#bid").val("");
				  } else {
					  $(".modal-body span").html("<span style='color: red;'>"+resp+"</span>");
				  }
			  },
			  error: function() {
				$(".modal-body span").html("<span style='color: red;'> E-Mail Service ist fehlerhaft!</span>");
			  }
			}); //ajax end
	}); //click end
	
	$("#showModal").click(function(){
		$("span#bidtext").html($("#bid").val() + "€");
		$("#BidModal").modal("show");
	});
	
}); //load ready end

$('body').on('click','#testCode',function(){
	$.ajax({
		  method: "POST",
		  url: "/AuctionPlatform/auction",
		  data: { code: $("#code").val() },
		
		  beforeSend: function(){
			$(".modal-body p").html('<img src="img/spinner.gif">');  
		  },
		  success: function(resp) {
			  if(resp=="null") {
				$(".modal-body p").html("<span style='color: green;'>Gebot wurde erfolgreich bestätigt.</span>");
			  } else {
				$(".modal-body span").html("<span style='color: red;'>"+resp+"</span>");
				$(".modal-body p").html('<label>Code</label><input placeholder="Bestätigungscode" id="code"><button id="testCode" class="ourButton">Senden</button>');
			  }
		  },
		  error:  function() {
		    $(".modal-body p").html("<span style='color: red;'>Fehler: Gebot kann derzeit nicht valididert werden.</span>");
		  }
	});
	
	$("#bid").val("");
});