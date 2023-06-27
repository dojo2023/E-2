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

import dao.CommunityDAO;
import model.Communityjoin;

/**
 * Servlet implementation class CommunityServlet
 */
@WebServlet("/CommunityServlet")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインIDを取得
				HttpSession session = request.getSession();
				String num = (String)session.getAttribute("staff_id");



		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// 全件表示処理を行う
		CommunityDAO cDao = new CommunityDAO();
		List<Communityjoin> commList = cDao.allselect();

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("commList", commList);
		request.setAttribute("num", num);
		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
				dispatcher.forward(request,response);
	}

}
