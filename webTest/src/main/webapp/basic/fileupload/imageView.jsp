<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>IMG태그의 src속성에 Servlet으로 이미지 처리하기</h3>
	<img src="<%=request.getContextPath() %>/images/아이유.jpg"><br><br>
	
	<img src="<%=request.getContextPath() %>/images/imageSrcView.do?fileno=16" width="1280" height="780">
</body>
</html>