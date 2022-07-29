<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	<form>태그의 속성
	1) action => 폼에서 만들어진 데이터를 받아서 처리할 문서명 또는 서플릿 URL을 기술한다.
	2) method => 전송방식(Get 또는 Post) => (기본값: Get)
	3) tatget => 응답 결과가 나타날 프레임명을 지정한다.
	4) enctype => 서버로 파일을 전송할 때 이 속성에 'multipart/form-data'값을 지정해야 한다.
 -->
 <%--
 	이것은 JSP주석 영역입니다.
  --%>
  
  <%
  	//이 영역은 JSP문서에서 JAVA명령을 사용할 수 있는 영역
  	//이 영역은 '스크립트릿'이라고 한다.
  	String name="홍길동";
  %>
  <%--
 	<%=변수명 또는 수식 %> => JSP에서 변수나 수식의 결과를 출력할 떄 사용한다. => 이것은 '식'영역이라 한다.
  --%>
  <h2>Request객체 연습용 Form 구성하기</h2>
  <h3>123+20/4=<%= 123+20/4%></h3>
  	
  <form method="GET" action="/webTest/requestTest01.do">
  	<table>
	    <tr>
	       <td>이름</td>
	       <td><input type="text" name="username" size="10"></td>
	    </tr>
	    <tr>
	       <td>직업</td>
	       <td>
	          <select name="job">
	             <option value="무직">**무직**</option>
	             <option value="회사원">**회사원**</option>
	             <option value="전문직">**전문직**</option>
	             <option value="학생">**학생**</option>
	          </select>
	       </td>
	    </tr>
	    
	    <tr>
	       <td>취미</td>
	          <td>
	             <input type="checkbox" name="hobby" value="여행">여행
	             <input type="checkbox" name="hobby" value="독서">독서
	             <input type="checkbox" name="hobby" value="게임">게임
	             <input type="checkbox" name="hobby" value="테니스">테니스
	             <input type="checkbox" name="hobby" value="배드민턴">배드민턴
	          </td>
	    </tr>
	    <tr>
	       <td colspan="2" style="'text-alignL:center;'">
	          <input type="submit" value="전송">
	          <input type="reset" value="데이터초기화">    
	       </td>
	    </tr>
 	</table>
  </form>
</body>
</html>