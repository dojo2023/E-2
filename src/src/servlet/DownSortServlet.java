package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudyDAO;
import model.Study;

/**
 * Servlet implementation class DownSortServlet
 */
@WebServlet("/DownSortServlet")
public class DownSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		
		// メニューページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ward.jsp");
				dispatcher.forward(request, response);
						
				doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		StudyDAO sd = new StudyDAO();
		
		//一覧表示
		List<Study> cardList = sd.StudyDownSort();
		session.setAttribute("cardList", cardList);
		
		
		// 用語ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ward.jsp");
		dispatcher.forward(request, response);
	}

}
