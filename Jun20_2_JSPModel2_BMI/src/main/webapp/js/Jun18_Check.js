function bmiCheck(){
	let nameBox = document.bmiForm.name;
	let heightBox = document.bmiForm.height;
	let weightBox = document.bmiForm.weight;
	let photoBox = document.bmiForm.photo;
	
	if (isEmpty(nameBox) || atLeastLetter(nameBox, 2)){
		alert("Please Fill in Your Name Properly.");
		nameBox.value = "";
		nameBox.focus();
		return false;
	} else if (isEmpty(heightBox) || isNotNumber(heightBox)
		|| atLeastLetter(heightBox, 3)) {
		alert("Please Fill in Your Height Properly.");
		heightBox.value = "";
		heightBox.focus();
		return false;
	} else if (isEmpty(weightBox) || isNotNumber(weightBox)
		|| atLeastLetter(weightBox, 3)) {
		alert("Please Fill in Your Weight Properly.");
		weightBox.value = "";
		weightBox.focus();
		return false;
	} else if (isEmpty(photoBox) || 
		(isNotType(photoBox, "png") && isNotType(photoBox, "gif")
		&& isNotType(photoBox, "jpg") && isNotType(photoBox, "bmp"))){
		alert("Please Fill in Photo Properly.");
		photoBox.value = "";
		photoBox.focus();
		return false;
	}
	return true;	
}


























