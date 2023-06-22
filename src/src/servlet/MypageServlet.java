package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MypageDAO;
import model.Mypage;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインして�?なかったらログインサーブレ�?トにリダイレクトす�?
//		HttpSession session = request.getSession();
//		if (session.getAttribute("staff_id") == null) {
//			response.sendRedirect("/kumano_onigiri/LoginServlet");
//			return;
//		}

		MypageDAO dao = new MypageDAO();
		List<Mypage> commList = dao.mypageselect("6");
		for (Mypage card : commList) {
			System.out.println(card.getStaff_id());
			System.out.println(card.getName());
			System.out.println(card.getRole());
			System.out.println(card.getQuiz());
			System.out.println(card.getQ_point());
			System.out.println(card.getGatya_id());
			System.out.println(card.getTask_thread());
		}
		Mypage banana = commList.get(0);
    	String id = banana.getStaff_id();
    	String name = banana.getName();
    	String point = banana.getQ_point();

		request.setAttribute("staff_id", id);
		request.setAttribute("name", name);
		request.setAttribute("q_point", point);
		// 検索結果をリクエストスコープに格納す�?
				request.setAttribute("mypagelist", commList);
		// マイペ�?�ジにフォワードす�?
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得す�?
//		request.setCharacterEncoding("UTF-8");
//		String staff_id = request.getParameter("STAFF_ID");
//		String name = request.getParameter("NAME");
//		String role = request.getParameter("ROLE");
//		String mark_id = request.getParameter("MARK_ID");
//		String gatya_id = request.getParameter("GATYA_ID");
//		String task_thread = request.getParameter("TASK_THREAD");



			// マイペ�?�ジにフォワードす�?
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
//			dispatcher.forward(request, response);
		}
    }