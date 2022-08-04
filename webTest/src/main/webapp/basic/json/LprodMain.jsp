<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#LprodBtn1").on("click", function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/lprodListAjax.do", //요청할 URL주소
				type: "POST", //전송방식
				//data: "choice=ajax;", //전송할 데이터 지정
				success: function(resData){ //응답 성공시 처리하는 함수(resData는 변수명으로 자유롭게 변경가능)
					//응답 데이터는 'resData'변수에 자동으로 저장된다.
					let htmlCode="<table border='1'>";
					htmlCode += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>";
					$.each(resData, function (i, v){
						htmlCode +="<tr><td>"+v.lprod_id+"</td>";
						htmlCode +="<td>"+v.lprod_gu+"</td>";
						htmlCode +="<td>"+v.lprod_nm+"</td></tr>";
					})
					htmlCode +="</table>";
					$("#result").html(htmlCode);
				},
				error:function(xhr){ //오류 발생시 처리하는 함수
					alert("오류발생");
				},
				dataType:"json" //응답 데이터의 종류 지정(text,html,xml 등을 지정할 수 있다.)
			});
		});
		$("#LprodBtn2").on("click", function(){
			location.href="<%=request.getContextPath()%>/lprodListNonAjax.do"
		});
	});
</script>
</head>
<body>
	<form>
		<input type="button" id="LprodBtn1" value="Lprod자료 가져오기(Ajax)">
		<input type="button" id="LprodBtn2" value="Lprod자료 가져오기(Non Ajax)">
	</form>
	
	<h3>LPROD 자료 목록</h3>
	<div id="result"></div>
</body>
</html>