package servlet;

	import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Back_groundDAO;


/**
 * Servlet implementation class StudyServlet
 */
@WebServlet("/StudyServlet")
public class StudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインIDを取得
		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");

		Back_groundDAO bgdao = new Back_groundDAO();
		bgdao.connect();
		String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
		bgdao.disconnect();
		request.setAttribute("bgid", bgid);

		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/study.jsp");
				dispatcher.forward(request,response);
}
}
