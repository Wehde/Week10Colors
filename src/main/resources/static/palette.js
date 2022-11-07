function getColorCount() {
	let count = document.querySelectorAll('input[type="checkbox"]:checked').length;
	document.getElementById("count").setAttribute('value', count);
}

function validate() {
	if (document.paletteForm.name.value == ""){
		alert("Please provide a name for the palette");
		return false;
	}
	if (document.paletteForm.count.value == 0){
		alert("Please select at least one color");
		return false;
	}
	return true;
}

