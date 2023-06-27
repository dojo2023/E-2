package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;

/**
 * Servlet implementation class CommuntiyeditServlet
 */
@WebServlet("/CommuntiyeditServlet")
public class CommuntiyeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String writingform = request.getParameter("WRITING_FORM");
		String writingid = request.getParameter("WRITING_ID");

		CommunityDAO cDao = new CommunityDAO();
		//編集を登録する処理
			cDao.update(writingform,writingid);

// 結果ページにフォワードする
RequestDispatcher dispatcher = request.getRequestDispatcher("/CommunityServlet");
dispatcher.forward(request, response);
	}
}
