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
 * Servlet implementation class CommunityGoodServlet
 */
@WebServlet("/CommunityGoodServlet")
public class CommunityGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String good = request.getParameter("GOOD");
        String id = request.getParameter("WRITING_ID");
        good = String.valueOf(Integer.parseInt(good)+1);
        CommunityDAO dao = new CommunityDAO();
        dao.goodupdate(good ,id);
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CommunityServlet");
		dispatcher.forward(request, response);
	}
}
