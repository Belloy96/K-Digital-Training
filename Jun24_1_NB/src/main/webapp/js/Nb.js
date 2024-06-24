function nbCheck() {
	let userNumBox = document.nbform.userNum;
	if (isNotNumber(userNumBox)){
		alert("숫자만 입력하세요")
		return false;
	}
	return true;
}





















