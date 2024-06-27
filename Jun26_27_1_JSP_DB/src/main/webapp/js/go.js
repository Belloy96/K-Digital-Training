function goAppleDetail(loc) {
	location.href = "AppleDetailController?a_location=" + loc;
}

function deleteApple(loc) {
	let t = confirm('${loc} 사과 정말 지우려고..? ');
	if (t){
		location.href = "AppleDeleteController?a_location=" + loc;
	}
}














