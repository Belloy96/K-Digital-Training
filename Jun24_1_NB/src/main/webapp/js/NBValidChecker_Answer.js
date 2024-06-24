function check() {
	let numBox = document.nbForm.userAns;
	
	if (isEmpty(numBox)
		|| isNotNumber(numBox)
		|| atLeastLetter(numBox, 3)
		|| numBox.value[0] == numBox.value[1]
		|| numBox.value[0] == numBox.value[2]
		|| numBox.value[1] == numBox.value[2]){
		alert("Please Fill in Number Properly.")
		numBox.value = "";
		numBox.focus();
		return false;	
	}
	return true;
}

























