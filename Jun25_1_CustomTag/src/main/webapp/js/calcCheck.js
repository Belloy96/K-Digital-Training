function calcCheck(){
	let xBox = document.calcForm.x;
	let yBox = document.calcForm.y;
	
	if(isNotNumber(xBox) || isNotNumber(yBox)
		|| isEmpty(xBox) || isEmpty(yBox)){
		alert('값을 다시 입력하세요');
		xBox.value = "";
		yBox.value = "";
		xBox.focus();
		return false;
	}
	return true;
}

