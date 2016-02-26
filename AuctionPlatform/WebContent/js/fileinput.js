$(function() {
	$('form button').disabled = !checkall(false);
});

function simulFile() {
	$('input[type="file"]').click();
}

function updateFName(elem) {
	$('#filereplace').html($(elem).val().replace(/C:\\fakepath\\/i, '') + ' ausgewählt');
}

function check(elem, bool) {
	var match = '';
	if(bool) {
		$(elem).siblings('button').disabled = checkall(false);		
	}

	switch(elem.name) {
		case 'title':
			if(match = /[^\<\>]+/.exec($(elem).val())) {
				$(elem).val(match);
				$(elem).css("border-color", "black");
				return true;
			} else {
				$(elem).css("border-color", "red");
				return false;
			}
			break;
		case 'bid':
			if(match = /[^\-]?[0-9]+(\.[0-9]{2})?/.exec($(elem).val())) {
				if(($('#bidinput').val().substr(-1) != '.') && ($('#bidinput').val().substr(-2, 1) != '.')) {
					$(elem).val(match[0]);
				} else {
					$(elem).css("border-color", "red");
					return false;
				}
				$(elem).css("border-color", "black");
				return true;
			} else {
				$(elem).css("border-color", "red");
				return false;
			}
			break;
		case 'end': 
			if(match = /[0-3][0-9]\.[0-1][0-9]\.201[6-7]\s[0-2][0-9]\:[0-5][0-9]/.exec($(elem).val())) {
				$(elem).val(match);
				$(elem).css("border-color", "black");
				return true;
			} else {
				$(elem).css("border-color", "red");
				return false;
			}
			break;
		case 'desc':
			if(match = /[^\<\>]+/.exec($(elem).val())) {
				$(elem).val(match);
				$(elem).css("border-color", "black");
				return true;
			} else {
				$(elem).css("border-color", "red");
				return false;
			}
			break;
	}
}

function checkall(bool) {
	var failed = false;
	
	$('form').children('input[type="text"]').each(function(){
		if(!check(this, bool)) {
			failed = true;
		}
	});
	
	console.log($('form button').prop('disabled'));
	$('form button').prop('disabled', failed);
	return !failed;
}