package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie를 추가하는 서블릿
 */
@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Cookie를 저장하는 방법
		//1. Cookie객체를 생성한다. =>쿠키의 name값과 '데이터값'은 문자열로 지정한다.
		//	형식) Cookie cookie변수=new Cookie("쿠키이름","쿠키값"); =>'쿠키값'에 한글을 사용할 경우 URLEncoder.encode()메서드로 인코딩한 후 사용
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동"));
		Cookie ageCookie = new Cookie("age", "25");
		Cookie genderCookie = new Cookie("gender", "Male");
		
		//2. 쿠기 속성 설정
		//쿠기변수.setPath("적용경로"); => 지정한 경로와 그 하위 경로에서 사용가능 (생략하면 쿠키를 설정할 당시의 경로가 저장된다.)
		//쿠키변수.setMaxAge(유지시간); =>단위(초) (-1: 브라우저가 종료될 때까지만 유지된다. 0: 즉시 쿠기가 삭제된다.)
		//쿠키변수.setDomain("적응도메인명");
		//예) ".ddit.or.kr" =>www.ddit.or.kr, mail.ddit.or.kr
		//쿠키변소.setSecure(보안여부); => true(보안적용), false(보안 미정용)
		
		//3. response객체를 이용하여 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		//형식) response.addCookie(1번에서 만든 쿠키변수)
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta chatset='utf-8'>");
		out.println("<title>Cookie연습</title></head>");
		out.println("<body>");
		out.println("<h3>Cookie 데이터가 저장되었습니다.</h3><br><br>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
