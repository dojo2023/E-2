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

import dao.Back_groundDAO;
import dao.WorkingDAO;
import model.Working;

/**
 * Servlet implementation class work_listSearchServlet
 */
@WebServlet("/work_listSearchServlet")
public class work_listSearchServlet extends HttpServlet {
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
		// 検索結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/work_list.jsp");
		dispatcher.forward(request, response);
				
		doPost(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		
		HttpSession session = request.getSession();
		int staff_id = (int)session.getAttribute("staff_id");
		request.setCharacterEncoding("UTF-8");
		String work_date = request.getParameter("WORK_DATE");
		WorkingDAO bDao = new WorkingDAO();
		List<Working> cardList = bDao.select(new Working());
		
		//ログインIDを取得
		//HttpSession session = request.getSession();
		//String staff_id = (String)session.getAttribute("staff_id");
		
		Back_groundDAO bgdao = new Back_groundDAO();
		bgdao.connect();
		String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
		bgdao.disconnect();
		request.setAttribute("bgid", bgid);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/work_list.jsp");
		dispatcher.forward(request, response);
	}

}
