<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sessionLoginServlet.do" method="POST">
		<table border="1" style="text-align: center">
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId" placeholder="id를 입력해주세요."></td>
			</tr>
			<tr>
				<td>PASS</td>
				<td><input type="password" name="pass" placeholder="passWord를 입력해주세요."></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>	
	</form>
</body>
</html>