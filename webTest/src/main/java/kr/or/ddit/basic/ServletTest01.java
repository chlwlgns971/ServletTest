package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest01
 */
public class ServletTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서블릿이란? 컨테이너(서블릿 엔진)에 의해 관리되는 자바 기반 웹 컴포넌트로서 동적인 웹 컨텐츠 생성을 가능하게 해준다.

	//이 예제는 배포 서술자(DD, Deployment Descriptor => web.xml문서)를 이용해서 실행할 Servlet을 설정해서 처리하는 예제이다.
	
	/*
	 요청 URL 구성 요소
	 요청 URL예시) http://localhost:8080/webTest/servletTest01.do
	 	- http => 프로토콜 이름
	 	- localhost=> 컴퓨터이름(도메인명) 또는 IP주소 
	 	- 8080 => 포트번호(80번일 경우에는 생략가능하다.)
	 	- /webTest=> ContextPath(보통 '웹프로젝트의 이름'으로 지정한다.)
	 	- /servletTest01.do => 서블릿 요청 URL패턴
	 */
	
	//--------------------------------------------------------------------
	//이 곳에서는 service()메서드 또는 doGet()메서드나 doPost()메서드를 재정의 해서 실행할 코드를 작성한다.
	// HttpServletRequest객체 => 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	// HttpServletRequest객체 => 서비스 응답에 관련된 정보 및 세서드를 관리하는 객체
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //응답문서의 인코딩방식 지정
		response.setContentType("text/html; charset=utf-8"); //응답문서의 ContentType지정
		
		//처리한 내용을 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		PrintWriter out=response.getWriter();
		
		//처리한 내용을 출력한다.(응답문서 작성하기)
		//방법1) append()메서드 이용하기
		out.append("<html>")
			.append("<head>")
			.append("<meta chatset='utf-8'>")
			.append("<title>첫번째 Servlet 연습</title>")
			.append("</head>")
			.append("<body>")
			.append("<h1 style='text-align:center'>")
			.append("안녕하세요. 첫번째 Servlet의 결과입니다.<br>")
			.append("실행 서블릿: "+request.getContextPath())
			.append("</h1>")
			.append("</body>")
			.append("</html>");		
	}
	
	//doPost()메서드 => POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
