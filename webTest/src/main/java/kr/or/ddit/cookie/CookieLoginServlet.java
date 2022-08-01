package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//값 받아오기
		String id=request.getParameter("userId");
		String pass=request.getParameter("pass");
		String isChecked=request.getParameter("chb"); //체크하면 "on" 아니면 null
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie연습</title></head>");
		out.println("<body>");
		
		if("on".equals(isChecked)) {
			Cookie idCookie=new Cookie("idValue",id);
			response.addCookie(idCookie);
		}
		else{
			Cookie[] cookieArr=request.getCookies();
			for(Cookie cookie : cookieArr) {
				String name=cookie.getName(); //쿠키이름 구하기
				
				//삭제하려는 쿠키인지 여부를 확인하여 삭제한다.
				if("idValue".equals(name)) {
					cookie.setMaxAge(0); //삭제하려는 쿠키의 유지시간을 0으로 설정한다.
					response.addCookie(cookie); //설정한 후 쿠키 정보를 저장한다.
				}
			}
		}
		if("test".equals(id) && "1234".equals(pass)) {
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieMain.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieLogin.jsp");
		}
		out.println("</body></html>");
	}

}
