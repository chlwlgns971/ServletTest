package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session정보 읽기
		 
		//1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session=request.getSession();
		
		//2. Session정보 삭제하기
		//2-1. 세션 자체는 삭제하지 않고 개별적인 세션값만 삭제하기 => removeAtrribute()메서드 이용
		//형식) session객체변수.removeAttribute("삭제할key값");
		//session.removeAttribute("testSession"); //특정 키값 삭제
		
		//2-2. 세션 자체를 삭제하기 => 세션의 모든 정보가 삭제된다. =>invalidate()메서드 이용
		session.invalidate();
		
		//----------------------------------------------------------------------------
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out=response.getWriter();
//		
//		out.println("<html><head><meta charset='utf-8'>");
//		out.println("<title>세션삭제</title></head>");
//		out.println("<body>");
//		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
//		out.println("</body></html>");
		
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionDBLogin.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
