package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudyDAO;
import model.Study;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		// 検索結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ward_search.jsp");
		dispatcher.forward(request, response);
				
//		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/simpleBC/LoginServlet");
//			return;
//		}
		
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
//		int word_id = Integer.parseInt(request.getParameter("WORD_ID"));
		String word_item = request.getParameter("WORD_ITEM");
//		String word_ex = request.getParameter("WORD_EX");
		
		//検索処理
		StudyDAO S_sd = new StudyDAO();
		List<Study> cardList = S_sd.select(new Study(0, word_item, null));
		
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ward_search.jsp");
		dispatcher.forward(request, response);
	}

}
