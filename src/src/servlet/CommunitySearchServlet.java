package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;
import model.Communityjoin;

/**
 * Servlet implementation class CommunitySearchServlet
 */
@WebServlet("/CommunitySearchServlet")
public class CommunitySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("TEXT");

		// 検索処理を行う
		CommunityDAO bDao = new CommunityDAO();
		List<Communityjoin> cardList = bDao.select(text);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("commList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CommunityServlet");
		dispatcher.forward(request, response);
	}
}
