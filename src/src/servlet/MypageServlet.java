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

import dao.Gatya_getDAO;
import dao.MypageDAO;
import model.Gatya_get;
import model.Mypage;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインして�?なかったらログインサーブレ�?トにリダイレクトす�?
//		HttpSession session = request.getSession();
//		if (session.getAttribute("staff_id") == null) {
//			response.sendRedirect("/kumano_onigiri/LoginServlet");
//			return;
//		}

		//ログインIDを取得
				HttpSession session = request.getSession();
				String staff_id = (String)session.getAttribute("staff_id");

		MypageDAO dao = new MypageDAO();
		Gatya_getDAO gachadao = new Gatya_getDAO();
		List<Gatya_get> markList = gachadao.gachapull(staff_id,"Mk");
		List<Gatya_get> bgList = gachadao.gachapull(staff_id,"Bg");
		List<Mypage> commList = dao.mypageselect(staff_id);

		Mypage banana = commList.get(0);
    	String id = banana.getStaff_id();
    	String name = banana.getName();
    	String point = banana.getQ_point();
    	String role = banana.getRole();
    	String task = banana.getTask_thread();
    	String mark_id = banana.getMark_id();
    	String quiz = banana.getQuiz();

    	//表示する名前を変更する処理
    	if(quiz == "TRUE") {
    		quiz = "ON";
    	}else {
    		quiz = "OFF";
    	}
    	if(role.equals("1")) {
    		role = "一般";
    	}else {
    		role = "管理者";
    	}

		request.setAttribute("staff_id", id);
		request.setAttribute("name", name);
		request.setAttribute("q_point", point);
		request.setAttribute("role", role);
		request.setAttribute("task", task);
		request.setAttribute("mark_id", mark_id);
		request.setAttribute("quiz", quiz);
		// 検索結果をリクエストスコープに格納す�?
				request.setAttribute("markList", markList);
				request.setAttribute("bgList", bgList);
		// マイペ�?�ジにフォワードす�?
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得す�?
//		String staff_id = request.getParameter("STAFF_ID");
//		String name = request.getParameter("NAME");
//		String role = request.getParameter("ROLE");
//		String mark_id = request.getParameter("MARK_ID");


		//ログインIDを取得
		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");
		request.setCharacterEncoding("UTF-8");
		String on = request.getParameter("ON");
	MypageDAO dao = new MypageDAO();
		if(on == null) {
			dao.onoffupdate(false, staff_id);
			}else {
				dao.onoffupdate(true, staff_id);
			}


		Gatya_getDAO gachadao = new Gatya_getDAO();
		List<Gatya_get> markList = gachadao.gachapull(staff_id,"Mk");
		List<Gatya_get> bgList = gachadao.gachapull(staff_id,"Bg");
		List<Mypage> commList = dao.mypageselect(staff_id);

		Mypage banana = commList.get(0);
    	String id = banana.getStaff_id();
    	String name = banana.getName();
    	String point = banana.getQ_point();
    	String role = banana.getRole();
    	String task = banana.getTask_thread();
    	String mark_id = banana.getMark_id();
    	String quiz = banana.getQuiz();

    	if(quiz == "TRUE") {
    		quiz = "ON";
    	}else {
    		quiz = "OFF";
    	}
    	if(role.equals("1")) {
    		role = "一般";
    	}else {
    		role = "管理者";
    	}

		request.setAttribute("staff_id", id);
		request.setAttribute("name", name);
		request.setAttribute("q_point", point);
		request.setAttribute("role", role);
		request.setAttribute("task", task);
		request.setAttribute("mark_id", mark_id);
		request.setAttribute("quiz", quiz);
		// 検索結果をリクエストスコープに格納す�?
				request.setAttribute("markList", markList);
				request.setAttribute("bgList", bgList);

			// マイペ�?�ジにフォワードす�?
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		}
    }