
function delAuction(elem) {
	$.ajax({
	  type: "POST",
	  url: "/AuctionPlatform/auction/delete",
	  data: { 'id': $(elem).prop("id").substr(3) },
	  success: function() {
		  $(elem).parent().animate({opacity: 0}, 500, function() {
			  $(elem).parent().hide();
		  });
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
			  $(elem).parent().remove();
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
  
  function updateClock() {
	  items = document.getElementsByClassName('timer');
	  
	  for( var i = 0; i < items.length; i++) {
		  var t = getTimeRemaining(items.item(i).dataset.time, offset);
		  items.item(i).innerHTML = t.vorzeichen * t.days + "d " + t.hours + "h " + t.minutes + "min " + t.seconds + "s";
		  
		  if (t.total < 0) {
			  endAuction(items.item(i));
		  }
	  }
  }
  
  setInterval(updateClock, 1000);
}

setTimeout(function(){
	var off = parseInt(document.getElementById('sep').dataset.servertime) - Date.parse(new Date())
	initializeClock(off);
}, 100);