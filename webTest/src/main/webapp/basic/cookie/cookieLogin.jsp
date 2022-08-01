<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/cookieLoginServlet.do" method="POST">
		<%
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			Cookie[] cookieArr=request.getCookies();
			String idValue="";
			String isChecked=null;
			if(cookieArr!=null){
				for(Cookie cookie : cookieArr) {
					String name=cookie.getName(); //쿠키이름 구하기
					if("idValue".equals(name)) {
						idValue=cookie.getValue();
						isChecked="checked";
					}
				}
			}	
		%>
		ID:<input type="text" name="userId" value="<%=idValue %>"><br>
		PASS:<input type="password" name="pass"><br>
		<input type="checkbox" name="chb" <%=isChecked%>>
		id 기억하기<br>
		<input type="submit" value="Login">
	</form>
</body>
</html>