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
					$(".modal-body p").html('<label>Code</label><input placeholder="Bestätigungscode" id="code"><button id="testCode" class="ourButton" onclick="checkMyCode();">Senden</button>');
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
}); //load ready end

function showMyModal() {
	var zahl = parseFloat($("#bid").val());
	if( !isNaN(zahl) ) {
		$('#bid').val(zahl);
		$("span#bidtext").html($("#bid").val() + "€");
		$("#BidModal").modal("show");
	} else {
		$('#bid').css('border', '1px solid red');
	}
}

function checkMyCode(){
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
}

function endAuction(elem) {
	$.ajax({
	  type: "POST",
	  url: "/AuctionPlatform/auction/end",
	  data: { 'id': $(elem).attr('data-id') },
	  success: function() {
		  $(elem).parent().animate({opacity: 0}, 500, function() {
			  $(elem).parent().hide();
		  });
	  }
	});
}

function getTimeRemaining(endtime, timeOffset) {
  var t = Math.floor((parseInt(endtime) - Date.parse(new Date()) + timeOffset)/1000);

  var seconds = Math.floor((t) % 60);
  var minutes = Math.floor((t / 60) % 60);
  var hours = Math.floor((t / (60 * 60)) % 24);
  var days = Math.floor(t / (60 * 60 * 24));
  return {
	'vorzeichen': Math.abs(t)/t,
    'total': t,
    'days': Math.abs(days),
    'hours': Math.abs(hours),
    'minutes': Math.abs(minutes),
    'seconds': Math.abs(seconds)
  };
}

function initializeClock(offset) {
  
  function updateClock(items) {
	  for( var i = 0; i < items.length; i++) {
		  var t = getTimeRemaining(items.item(i).dataset.time, offset);
		  items.item(i).innerHTML = t.vorzeichen * t.days + "d " + t.hours + "h " + t.minutes + "min " + t.seconds + "s";
		  
		  if (t.total < 0) {
			  endAuction(items.item(i));
		  }
	  }
  }
  
  setInterval(updateClock, 1000, document.getElementsByClassName('timer'));
}

setTimeout(function(){
	var off = parseInt(document.getElementsByClassName('timer').item(0).dataset.servertime) - Date.parse(new Date())
	initializeClock(off);
}, 100);