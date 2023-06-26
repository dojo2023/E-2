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

import dao.WorkingDAO;
import model.Working;




/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/Work_listServlet")
public class Work_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		
		
//		HttpSession session = request.getSession();
//		WorkingDAO bDao = new WorkingDAO();
//		List<Study> cardList = bDao.WorkingAllList();
//		session.setAttribute("cardList", cardList);
		
		// 勤怠一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/work_list.jsp");
		dispatcher.forward(request, response);
				
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		
		HttpSession session = request.getSession();
		int staff_id = (int)session.getAttribute("staff_id");
		
		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String work_date = request.getParameter("WORK_DATE");
		
		WorkingDAO bDao = new WorkingDAO();
		List<Working> cardList = bDao.select(new Working());
		
		// 勤怠一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/work_list.jsp");
		dispatcher.forward(request, response);
	}


}
