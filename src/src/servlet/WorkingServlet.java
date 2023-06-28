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

@WebServlet("/WorkingServlet")
public class WorkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインIDを取得
		HttpSession session = request.getSession();
		int staff_id = Integer.parseInt((String) session.getAttribute("staff_id"));

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String work_id = request.getParameter("WORK_ID");
		String work_start = request.getParameter("WORK_START");
		String work_end = request.getParameter("WORK_END");
		String work_style = request.getParameter("WORK_STYLE");
		String work_date = request.getParameter("WORK_DATE");

		// 検索処理を行う
		WorkingDAO bDao = new WorkingDAO();
		List<Working> cardList = bDao
				.select(new Working(work_date, work_start, work_end, work_style, staff_id, work_date));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 勤怠ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/working.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインIDを取得
		HttpSession session = request.getSession();
		int staff_id = Integer.parseInt((String) session.getAttribute("staff_id"));

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String work_id = request.getParameter("WORK_ID");
		String work_start = request.getParameter("WORK_START");
		String work_end = request.getParameter("WORK_END");
		String work_style = request.getParameter("WORK_STYLE");
		String work_date = request.getParameter("WORK_DATE");

		// 登録処理を行う
		WorkingDAO iDao = new WorkingDAO();
		if (iDao.insert(new Working(work_id, work_start, work_end, work_style, staff_id, work_date))) {

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/working.jsp");
			dispatcher.forward(request, response);
		}
	}
}
