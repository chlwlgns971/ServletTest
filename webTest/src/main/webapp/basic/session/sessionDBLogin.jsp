<%@page import="kr.or.ddit.session.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO memVo=(MemberVO)session.getAttribute("loginMember");
   		if(memVo  == null){ // 로그인 안되었을 떄..
	%>
   <form action="<%=request.getContextPath()%>/sessionDBLogin.do">
      <table>
         <tr>
            <td><label>ID: </label></td>
            <td><input type="text" name="userid" value ="" placeholder="ID를 입력하세요."></td>
         </tr>
         <tr>
            <td><label>PASS:</label></td>
            <td><input type="password" name="pass" value ="" placeholder="PASSWORD를 입력하세요."></td>
         </tr>
         <tr>
            <td><input type="submit" value="Login"></td>
         </tr>
      </table>
   </form>
	<%
	   }else{ //로그인 성공했을 때
	%>
   <h3><%=memVo.getMem_name()%>님 반갑습니다.</h3>
   <a href="<%=request.getContextPath() %>/sessionDelete.do">로그아웃</a>
	<%
	   }
	%>
</body>
</html>