function delAuction(elem) {
	alert($(elem).prop("id").substr(3));
	$.ajax({
	  type: "POST",
	  url: "/AuctionPlatform/auction",
	  data: { 'id': $(elem).prop("id").substr(3) },
	  success: function() {
		  $(elem).parent().parent().animate({opacity: 0}, 250);
		  $(elem).parent().parent().hide();
	  }
	});

}