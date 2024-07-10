<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function () {
		// alert('adsf');
		// 시간. 기온. 날씨
		
		$.ajax ({
			url: "k.weather.get",
			success: function (asdf) {
				let ar = [];
				let hourTh = $("<th></th>").text("시간");
				let tempTh = $("<th></th>").text("기온");
				let wfKorTh = $("<th></th>").text("날씨");
					
				let trr = $("<tr></tr>").append(hourTh, tempTh, wfKorTh);
				$("table").append(trr);
					
				$(asdf).find("data").each(function (i, w) {
					let hour = $(w).find("hour").text();
					let temp = $(w).find("temp").text();
					let wfKor = $(w).find("wfKor").text();
					
					let hourTd = $("<td></td>").text(hour);
					let tempTd = $("<td></td>").text(temp);
					let wfKorTd = $("<td></td>").text(wfKor);
					
					let tr = $("<tr></tr>").append(hourTd, tempTd, wfKorTd);
					$("table").append(tr);
				
					ar[i] = {label: hour, y: temp * 1, lineColor: "orange",
							markerColor: "#1E09FF"} // temp가 문자열형태일것이라 숫자형으로 바꿔서 표현
					
				});
				
				var chart = new CanvasJS.Chart("chartContainer", {
					animationEnabled: true,
					theme: "light2",
					title:{
						text: "Simple Line Chart"
					},
					data: [{        
						type: "line",
				      	indexLabelFontSize: 16,
						dataPoints: ar
					}]
				});
				chart.render();
				
			}
		});
		
	});
</script>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<table border="1"></table>
</body>
</html>