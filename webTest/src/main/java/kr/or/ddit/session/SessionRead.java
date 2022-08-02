package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Session정보 읽기
		 
		//1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session=request.getSession();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>세션연습</title></head>");
		out.println("<body>");
		out.println("<h3>저장된 Session 데이터 확인하기</h3>");
		
		//2. getAttribute()메서드로 Session값 읽어오기
		//형식) session객체변수.getAtrribute("키값");
		String SessionValue = (String) session.getAttribute("testSession");
		if(SessionValue==null) {
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		}
		else {
			out.println("<h3>testSession의 세션값: "+SessionValue+"</h3>");
		}
		out.println("<hr>");
		out.println("<h3>전체 세션값 확인하기</h3>");
		out.println("<ul>");
		
		//세션의 전체 'key값'정보 가져오기
		Enumeration<String> sessionKeys = session.getAttributeNames();
		while(sessionKeys.hasMoreElements()) {
			String key=sessionKeys.nextElement(); //키 값 구하기
			out.println("<li>"+key+" : "+session.getAttribute(key)+"</li>");
		}
		out.println("</ul>");
		out.println("<hr>");
		out.println("<h3>기타 Session관련 정보</h3>");
		
		//세션ID => 세션을 구분하기 위한 고유한 값
		out.println("세션ID: "+session.getId()+"<br><br>");
		
		//생성시간 => 1970년 1월 1일 0시 0분 0초부터 경과한 시간으로 표시한다.(단위: 밀리세컨드)
		out.println("세션 생성 시간: "+session.getCreationTime()+"<br><br>");
		
		//최근접근 시간 => 1970년 1월 1일 0시 0분 0초부터 경과한 시간으로 표시한다.(단위: 밀리세컨드)
		out.println("세션 최근 접근 시간: "+session.getLastAccessedTime()+"<br><br>");
		
		//세션유효시간 => (단위: 초) => 유효시간설정: session.setMaxInactiveInterval(초 단위 시간)
		out.println("세션 유효 시간: "+session.getMaxInactiveInterval()+"<br><br>");
		
		
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
