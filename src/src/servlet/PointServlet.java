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
import dao.PointDAO;
import dao.UsersDAO;

@WebServlet("/PointServlet")
public class PointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//IDを取得
		HttpSession session = request.getSession();
		int staff_id = Integer.parseInt((String) session.getAttribute("staff_id"));
		String staff_id1 = (String) session.getAttribute("staff_id");

		UsersDAO iDao = new UsersDAO();
		String banana = iDao.adceak(staff_id1);
		//背景を取得する処理
		String num = (String)session.getAttribute("staff_id");
				Back_groundDAO bgdao = new Back_groundDAO();
				bgdao.connect();
				String bgid = bgdao.select(num);//numのところにstaff_idを入れる
				bgdao.disconnect();
				request.setAttribute("bgid", bgid);

		        //jspから値を取得
				request.setCharacterEncoding("utf-8");
				int point_pram = Integer.parseInt(request.getParameter("quiz_point")); // JSPのvalue属性を設定した入力値を取得する。
				System.out.println(point_pram);

				//ポイントを更新
				PointDAO pdao = new PointDAO();
				pdao.connect();
				int point = pdao.update_point(point_pram, staff_id);//セッションに格納されているスタッフIDを引数に入れる
				pdao.disconnect();

				if(banana.equals("1")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
					dispatcher.forward(request, response);
				}else if(banana.equals("2")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
					dispatcher.forward(request, response);
				}
	}
}
