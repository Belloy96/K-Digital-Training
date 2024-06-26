function check() {
	let a_locationBox = document.arForm.a_location;
	let a_colorBox = document.arForm.a_color;
	let a_flavorBox = document.arForm.a_flavor;
	let a_priceBox = document.arForm.a_price;
	let a_introduceBox = document.arForm.a_introduce;
	
	if (isEmpty(a_locationBox)
		|| isEmpty(a_colorBox) || isEmpty(a_flavorBox)
		|| isEmpty(a_priceBox) || isEmpty(a_introduceBox)){
		alert('누락된 정보가 있습니다. 다시 입력하세요');
		return false;
	} else if (isNotNumber(a_priceBox)){
		alert('숫자만 입력하세요');
		a_priceBox.value = "";
		a_priceBox.focus();
		return false;
	}	
	return true;
}








