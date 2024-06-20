// 여기서 해야 할일 -> 이름, 체중, 키, 사진 등에 유효성 검사를 위함

function check(){
	let name = document.form.name;
	let height = document.form.height;
	let weight = document.form.weight;
	let photo = document.form.photo;
	
	if (isEmpty(name) || isEmpty(height)
		 || isEmpty(weight)) {
		alert("한 군데도 빠짐없이 입력해주세요");
		return false;
	}
	
	if (isEmpty(photo)) {
		alert("사진을 등록해주세요")
		return false;
	}
	
	if (isNotNumber(weight) || isNotNumber(height)) {
		alert("숫자만 입력해주세요")
		return false;
	}

	return true;
}






















