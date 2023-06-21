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
 * Servlet implementation class CommunityGoodServlet
 */
@WebServlet("/CommunityGoodServlet")
public class CommunityGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Ajaxで渡されたテキストボックスの値を変数に格納
		response.setContentType("text/html;charset=UTF-8");
        String good = request.getParameter("GOOD");
        String id = request.getParameter("WRITING_ID");
        good = String.valueOf(Integer.parseInt(good)+1);
        CommunityDAO dao = new CommunityDAO();
        dao.goodupdate(good ,id);

		// 全件表示処理を行う
		List<Communityjoin> commList = dao.allselect();

		// 結果をリクエストスコープに格納する
		request.setAttribute("commList", commList);
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
		dispatcher.forward(request, response);
	}

}
