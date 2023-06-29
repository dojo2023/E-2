package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.WorkingDAO;

/**
 * Servlet implementation class work_listSearchServlet
 */
@WebServlet("/work_listSearchServlet")
public class work_listSearchServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/work_listSearch.jsp");
		dispatcher.forward(request, response);

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/kumano_onigiri/LoginServlet");
//			return;
//		}

        //ログインIDを取得
        HttpSession session = request.getSession();
        //int staff_id = Integer.parseInt((String)session.getAttribute("STAFF_ID"));

        // リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int staff_id = Integer.parseInt(request.getParameter("STAFF_ID"));
		// 検索処理を行う
		WorkingDAO bDao = new WorkingDAO();
//     	List<Working> cardList = bDao.select(new Working(null, null, null, null, staff_id, null));
		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("cardList", cardList);

		//ログインIDを取得
		//HttpSession session = request.getSession();
//		String staff_id = (String)session.getAttribute("staff_id");
//
//		Back_groundDAO bgdao = new Back_groundDAO();
//		bgdao.connect();
//		String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
//		bgdao.disconnect();
//		request.setAttribute("bgid", bgid);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/work_listSearch.jsp");
		dispatcher.forward(request, response);
	}
}
