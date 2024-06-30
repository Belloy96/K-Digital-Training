function check(){
	let idBox = document.regForm.m_id;
	let pwBox = document.regForm.m_pw;
	let pwchkBox = document.regForm.pwchk;
	let nameBox = document.regForm.m_name;
	let numberBox = document.regForm.m_number;
	let birthBox = document.regForm.m_birth;
	let photoBox = document.regForm.m_photo;
	
	if(isEmpty(idBox) || isEmpty(pwBox) || isEmpty(nameBox)
		|| isEmpty(numberBox) || isEmpty(birthBox)){
		alert('비어있는 값이 없도록 다시 입력해주세요');
		return false;
	} else if (isEmpty(photoBox)) {
		alert('사진을 등록해주세요');
		return false;
	} else if (isNotNumber(birthBox)) {
		alert('숫자만 입력해주세요');
		birthBox.value = "";
		birthBox.focus();
		return false;
	} else if (notEqualPw(pwBox, pwchkBox)) {
		alert('값이 다릅니다. 다시 입력하세요');
		pwBox.value = "";
		pwchkBox.value = "";
		pwBox.focus();
		return false;
	}
	return true;
}


