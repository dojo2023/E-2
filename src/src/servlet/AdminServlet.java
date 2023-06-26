package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/AdminServlet")
	public class AdminServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/**		HttpSession session = request.getSession();
			if (session.getAttribute("staff_id") == null) {
				response.sendRedirect("/kumano_onigiri/LoginServlet");
				return;
			} **/
			// トップページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
			dispatcher.forward(request, response);
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String task_id = request.getParameter("TASK_ID");
			String task_thread = request.getParameter("TASK_THREAD");
			String calendar = request.getParameter("CALENDAR");

/**			// 登録処理を行う
			TaskDAO bDao = new TaskDAO();
			if (bDao.insert(task_id,task_thread,calendar,staff_id)) **/{
			}
	}
}

