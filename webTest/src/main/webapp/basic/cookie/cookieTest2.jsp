<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--<a href="/webTest/cookieAdd.do">Cookie정보 저장하기</a><br><br>  -->
	<a href="<%=request.getContextPath() %>/cookieCount.do">Cookie Count 증가하기</a><br><br> <!-- 위와 같은 방식 -->
	<a href="<%=request.getContextPath() %>/cookieReset.do">Cookie Count 초기화하기</a><br><br>
</body>
</html>