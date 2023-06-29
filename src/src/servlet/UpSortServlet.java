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
import dao.StudyDAO;
import model.Study;

/**
 * Servlet implementation class UpSortServlet
 */
@WebServlet("/UpSortServlet")
public class UpSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/kumano_onigiri/LoginServlet");
//			return;
//		}

		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");

				Back_groundDAO bgdao = new Back_groundDAO();
				bgdao.connect();
				String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
				bgdao.disconnect();
				request.setAttribute("bgid", bgid);
		// 用語ページにフォワードする
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
//			response.sendRedirect("/kumano_onigiri/LoginServlet");
//			return;
//		}
		StudyDAO sd = new StudyDAO();
		//一覧表示
		List<Study> cardList = sd.StudyUpSort();
		session.setAttribute("cardList", cardList);

		//ログインIDを取得
//		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");

		Back_groundDAO bgdao = new Back_groundDAO();
		bgdao.connect();
		String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
		bgdao.disconnect();
		request.setAttribute("bgid", bgid);


		// 用語ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ward.jsp");
		dispatcher.forward(request, response);
	}

}
