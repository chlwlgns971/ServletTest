<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request객체 연습</title>
</head>
<body>
	<h3>Request객체 연습용 Form(숫자입력은 정수형으로 입력하세요)</h3><hr>
	<form method="GET" action="/webTest/requestTest02.do">
		<h3>requestTest02.jsp</h3><hr>
		<h1>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h1><hr>
		<input type="text" name="num1" size="10">
		<select name="calc">
			<option value="+">+</option>
           	<option value="-">-</option>
           	<option value="*">*</option>
           	<option value="/">/</option>
           	<option value="%">%</option>
   		</select>
   		<input type="text" name="num2" size="10">
   		<input type="submit" value="계산">
	</form>
</body>
</html>