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