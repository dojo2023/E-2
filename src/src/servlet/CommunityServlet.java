package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommunityDAO;
import model.Community;
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインIDを取得
		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String writingform = request.getParameter("WRITING_FORM");
				String good ="0";
				//指定のタイムゾーンで現在時刻を取得
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String writingtime = sdf.format(cal.getTime());

				// 登録処理を行う
				CommunityDAO cDao = new CommunityDAO();
				if(cDao.insert(new Community(null,writingform,writingtime,good,staff_id))) {
					System.out.println("投稿DB登録完了");
				}else {
					System.out.println("投稿DB登録失敗");
				}

				// 全件表示処理を行う
				List<Communityjoin> commList = cDao.allselect();

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("commList", commList);
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
				dispatcher.forward(request, response);
	}
}
