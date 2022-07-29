package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String str=request.getParameter("calc");
		int res=0;
		switch (str) {
		case "+":
			res=num1+num2;
			break;
		case "-":
			res=num1-num2;
			break;
		case "*":
			res=num1*num2;
			break;
		case "/":
			res=num1/num2;
			break;
		case "%":
			res=num1%num2;
			break;

		default:
			break;
		}
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>계산결과</title></head>");
		out.println("<body>");
		out.println("<h1>계산 결과</h1><hr>");
		out.println(num1+str+num2+"="+res);
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
