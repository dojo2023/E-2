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
 * Servlet implementation class CommuntiydeleteServlet
 */
@WebServlet("/CommuntiydeleteServlet")
public class CommuntiydeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する

		request.setCharacterEncoding("UTF-8");
		String writingid = request.getParameter("WRITING_ID");

		CommunityDAO cDao = new CommunityDAO();
		//投稿を削除する処理
			cDao.delete(writingid);
// 結果ページにフォワードする
RequestDispatcher dispatcher = request.getRequestDispatcher("/CommunityServlet");
dispatcher.forward(request, response);
	}
}
