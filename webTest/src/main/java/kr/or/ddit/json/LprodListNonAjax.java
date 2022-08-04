package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;


@WebServlet("/lprodListNonAjax.do")
public class LprodListNonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//service객체 생성
		ILprodService service = LprodServiceImpl.getInstance();
		//Lprod테이블의 데이터 목록 가져오기
		List<LprodVO> lprodList = service.getAllLprod();
		
		//목록 데이터를 저장한다.
		request.setAttribute("lprodList", lprodList);
		
		//view로 포워딩한다.
		request.getRequestDispatcher("/basic/json/lprodList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
