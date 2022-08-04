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
		$("#strBtn").on("click",function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/jsonServlet.do", //요청할 URL주소
				type: "POST", //전송방식
				data: "choice=str", //전송할 데이터 지정
				success: function(resData){ //응답 성공시 처리하는 함수(resData는 변수명으로 자유롭게 변경가능)
					//응답 데이터는 'resData'변수에 자동으로 저장된다.
					$("#result").html(resData);
				},
				error:function(xhr){ //오류 발생시 처리하는 함수
					alert("오류발생");
				},
				dataType:"json" //응답 데이터의 종류 지정(text,html,xml 등을 지정할 수 있다.)
			})
		})
		//-------------------------------------------------------------------------
		$("#arrayBtn").on("click",function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/jsonServlet.do", //요청할 URL주소
				type: "POST", //전송방식
				data: "choice=array", //전송할 데이터 지정
				success: function(resData){ //응답 성공시 처리하는 함수(resData는 변수명으로 자유롭게 변경가능)
					let htmlCode="";
					$.each(resData, function(i,v){
						//변수 i는 index값, 변수 v는 데이터값이 저장된다.
						htmlCode+=i+"번째 데이터: "+v+"<br>";
					});
					$("#result").html(htmlCode);
				},
				error:function(xhr){ //오류 발생시 처리하는 함수
					alert("오류발생");
				},
				dataType:"json" //응답 데이터의 종류 지정(text,html,xml 등을 지정할 수 있다.)
			});
		});
		//-------------------------------------------------------------------------
		$("#objBtn").on("click",function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/jsonServlet.do", //요청할 URL주소
				type: "POST", //전송방식
				data: "choice=obj", //전송할 데이터 지정
				success: function(resData){ //응답 성공시 처리하는 함수(resData는 변수명으로 자유롭게 변경가능)
					let htmlCode="";
					htmlCode +="ID: "+resData.id+"<br>";
					htmlCode +="NAME: "+resData.name+"<br>";
					
					$("#result").html(htmlCode);
				},
				error:function(xhr){ //오류 발생시 처리하는 함수
					alert("오류발생");
				},
				dataType:"json" //응답 데이터의 종류 지정(text,html,xml 등을 지정할 수 있다.)
			});
		});
		//-------------------------------------------------------------------------
		$("#listBtn").on("click",function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/jsonServlet.do", //요청할 URL주소
				type: "POST", //전송방식
				data: "choice=list", //전송할 데이터 지정
				success: function(resData){ //응답 성공시 처리하는 함수(resData는 변수명으로 자유롭게 변경가능)
					let htmlCode="";
					$.each(resData, function(i,v){
						htmlCode+=i+"번째 데이터 <br> ID: "+v.id+"<br>NAME: "+v.name+"<hr>";
					})
					$("#result").html(htmlCode);
				},
				error:function(xhr){ //오류 발생시 처리하는 함수
					alert("오류발생");
				},
				dataType:"json" //응답 데이터의 종류 지정(text,html,xml 등을 지정할 수 있다.)
			});
		});
		//-------------------------------------------------------------------------
		$("#mapBtn").on("click",function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/jsonServlet.do", //요청할 URL주소
				type: "POST", //전송방식
				data: "choice=map", //전송할 데이터 지정
				success: function(resData){ //응답 성공시 처리하는 함수(resData는 변수명으로 자유롭게 변경가능)
					let htmlCode="이름: "+resData.name+"<br>";
					htmlCode+="전화번호: "+resData.tel+"<br>";
					htmlCode+="주소: "+resData.addr+"<br>";
					$("#result").html(htmlCode);
				},
				error:function(xhr){ //오류 발생시 처리하는 함수
					alert("오류발생");
				},
				dataType:"json" //응답 데이터의 종류 지정(text,html,xml 등을 지정할 수 있다.)
			});
		});
	});
</script>
</head>
<body>
	<form>
		<input type="button" id="strBtn" value="문자열">
		<input type="button" id="arrayBtn" value="배열">
		<input type="button" id="objBtn" value="객체">
		<input type="button" id="listBtn" value="List객체">
		<input type="button" id="mapBtn" value="Map객체">
	</form>
	<hr>
	<h3>Ajax응답 결과</h3>
	<div id="result"></div>
</body>
</html>