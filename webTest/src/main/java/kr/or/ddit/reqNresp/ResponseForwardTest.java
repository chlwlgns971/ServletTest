package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * forward방식으로 호출되는 서블릿
 */
@WebServlet("/responseForwardTest.do")
public class ResponseForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//파라미터값 받기
		String userName=request.getParameter("username");
		
		//setAttribute()메서드로 세팅한 데이터 받기 => getAttribute()메서드 이용
		//형식) Request객체변수.getAttribute.getAttribute("키값");
		String tel=(String)request.getAttribute("tel");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	  
		PrintWriter out = response.getWriter();
	  
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Forward방식 연습</title></head>");
		out.println("<body>");
		out.println("<h3>Forward 처리 결과</h3>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름</td><td>" + userName + "</td></tr>");
		out.println("<tr><td>전화</td><td>"+ tel +"</td></tr>");
		out.println("</table></body></html>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
