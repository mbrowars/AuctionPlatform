function simulFile() {
	$('input[type="file"]').click();
}

function updateFName(elem) {
	$('#filereplace').html($(elem).val().replace(/C:\\fakepath\\/i, '') + ' ausgewählt');
}