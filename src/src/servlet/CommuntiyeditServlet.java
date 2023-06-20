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
 * Servlet implementation class CommuntiyeditServlet
 */
@WebServlet("/CommuntiyeditServlet")
public class CommuntiyeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String writingform = request.getParameter("WRITING_FORM");
				String writingid = request.getParameter("WRITING_ID");

		//編集を登録する処理
		CommunityDAO cDao = new CommunityDAO();
		cDao.update(writingform,writingid);

		// 全件表示処理を行う
		List<Communityjoin> commList = cDao.allselect();

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("commList", commList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
		dispatcher.forward(request, response);
	}

}
