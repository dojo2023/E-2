package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gatya_getDAO;

/**
 * Servlet implementation class BackgroundServlet
 */
@WebServlet("/BackgroundServlet")
public class BackgroundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gatya_getDAO dao = new Gatya_getDAO();
		String chenge_bg = request.getParameter("chenge_bg");
			if (dao.backupdate(chenge_bg, "6")) {
				System.out.println("更新成功！");}
			else {
				System.out.println("更新失敗！");
			}

	}

}
