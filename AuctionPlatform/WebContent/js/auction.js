$(function() {
	$("#sendCode").click(function(){
		
		if (/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test($("#mail").val())) {

		$.ajax({
			  type: "POST",
			  url: "/AuctionPlatform/auction/bid",
			  data: { 'mail': $("#mail").val(),
				  	  'bid' : $("#bid").val(),
				  	  'id'  : $('#id').html()},

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
		} else {
			$(".modal-body span").html("<span style='color: red;'>Bitte eine valide E-Mail Adresse eingeben!</span>");
		}
	}); //click end
	
	$("#showModal").click(function(){
		var zahl = parseFloat($("#bid").val());
		if( !isNaN(zahl) ) {
			$('#bid').val(zahl);
			$("span#bidtext").html($("#bid").val() + "€");
			$("#BidModal").modal("show");
		} else {
			$('#bid').css('border', '1px solid red');
		}
	});
	
}); //load ready end

$('body').on('click','#testCode',function(){
	$.ajax({
		  method: "POST",
		  url: "/AuctionPlatform/auction/bid",
		  data: { 'code': $("#code").val(),
			  	  'bid' : $("#bid").val(),
			  	  'id'  : $('#id').html()},		
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
});