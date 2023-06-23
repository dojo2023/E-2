package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gatya_getDAO;
import dao.MypageDAO;
import model.Gatya_get;
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
		Gatya_getDAO gachadao = new Gatya_getDAO();
		List<Gatya_get> markList = gachadao.gachapull("6","Mk");
		List<Gatya_get> bgList = gachadao.gachapull("6","Bg");
		List<Mypage> commList = dao.mypageselect("6");

		Mypage banana = commList.get(0);
    	String id = banana.getStaff_id();
    	String name = banana.getName();
    	String point = banana.getQ_point();
    	String role = banana.getRole();
    	String task = banana.getTask_thread();

		request.setAttribute("staff_id", id);
		request.setAttribute("name", name);
		request.setAttribute("q_point", point);
		request.setAttribute("role", role);
		request.setAttribute("task", task);
		// 検索結果をリクエストスコープに格納す�?
				request.setAttribute("markList", markList);
				request.setAttribute("bgList", bgList);
		// マイペ�?�ジにフォワードす�?
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得す�?
//		String staff_id = request.getParameter("STAFF_ID");
//		String name = request.getParameter("NAME");
//		String role = request.getParameter("ROLE");
//		String mark_id = request.getParameter("MARK_ID");
		request.setCharacterEncoding("UTF-8");
		String on = request.getParameter("ON");
	MypageDAO dao = new MypageDAO();
		if(on == null) {
			dao.onoffupdate(false, "6");
			}else {
				dao.onoffupdate(true, "6");
			}

			// マイペ�?�ジにフォワードす�?
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		}
    }