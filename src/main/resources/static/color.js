function validate() {
	if (document.colorForm.hexColor.value.length != 6){
		alert("Invalid color. Colors must have 6 characters.");
		return false;
	}
	return true;
}

function hexChars(chars) {
	console.log(chars);
	chars = chars.toUpperCase();
	chars = chars.replace(/[^A-F0-9]/gi, '');
	return chars;
}