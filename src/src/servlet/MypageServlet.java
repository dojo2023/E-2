package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MypageDao;
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
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("staff_id") == null) {
//			response.sendRedirect("/kumano_onigiri/LoginServlet");
//			return;
//		}

		MypageDao dao = new MypageDao();
		List<Mypage> mypagelist = dao.mypageselect("6");
		for(Mypage i : mypagelist) {
			System.out.println(i.getStaff_id());
			System.out.println(i.getName());
			System.out.println(i.getRole());
			System.out.println(i.getQuiz());
			System.out.println(i.getQ_point());
			System.out.println(i.getGatya_id());
			System.out.println(i.getTask_thread());
		}
		// 検索結果をリクエストスコープに格納する
				request.setAttribute("mypagelist", mypagelist);
		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String staff_id = request.getParameter("STAFF_ID");
		String name = request.getParameter("NAME");
		String role = request.getParameter("ROLE");
		String mark_id = request.getParameter("MARK_ID");
		String gatya_id = request.getParameter("GATYA_ID");
		String task_thread = request.getParameter("TASK_THREAD");



			// マイページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		}
    }