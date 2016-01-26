$(function() {
	$("#sendCode").click(function(){
		
		$.ajax({
			  method: "POST",
			  url: "Controller",
			  data: { mail: $("#mail").val() }
			})
			  .success(function() {
			    $(".modal-body p").html("<span style='color: green;' E-Mail wurde erfolgreich versendet!</span>")
			  });
		
		$("#bid").val("");
	});
	
	$("#showModal").click(function(){
		$("span#bidtext").html($("#bid").val() + "€");
		$("#BidModal").modal("show");
	});
});