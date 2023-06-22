package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String staff_id = request.getParameter("STAFF_ID");
		String password = request.getParameter("PASSWORD");
		String name = request.getParameter("NAME");
		String role = request.getParameter("ROLE");
		String quiz = request.getParameter("QUIZ");
		String answer_time = request.getParameter("ANSWER_TIME");
		String gatya_id = request.getParameter("GATYA_ID");

		// ログイン処理を行う
		UsersDAO iDao = new UsersDAO();
		if (iDao.isLoginOK(new Users(staff_id,password,name,role,quiz,answer_time,gatya_id))) {	// ログイン成功
			String banana = iDao.adceak(staff_id);
			// セッションスコープにID,password等を格納する
			HttpSession session = request.getSession();
			session.setAttribute("staff_id",staff_id);
			session.setAttribute("banana",banana);
			// トップサーブレットにリダイレクトする
			response.sendRedirect("/kumano_onigiri/TopServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result","※社員IDとPASSWORDを入力して下さい。");

			// ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
    }
}
