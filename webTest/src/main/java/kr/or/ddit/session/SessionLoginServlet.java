package kr.or.ddit.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionLoginServlet.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String pass=request.getParameter("pass");
		
		if("admin".equals(userId)) {
			if("1234".equals(pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("id", userId);
				session.setAttribute("passWord", pass);
				response.sendRedirect(request.getContextPath()+"/basic/session/sessionMain.jsp");
				return;
			}
		}
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionLogin.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
