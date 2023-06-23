package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PointDAO;

/**
 * Servlet implementation class QuizpointServlet
 */
@WebServlet("/QuizpointServlet")
public class QuizpointServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//jspから値を取得

				int point_pram = Integer.parseInt(request.getParameter("quiz_point")); // JSPのvalue属性を設定した入力値を取得する。

				PointDAO pdao = new PointDAO();
				//ポイントを更新
				pdao.connect();
				int point = pdao.update_point(point_pram,6);//セッションに格納されているスタッフIDを引数に入れる
				pdao.disconnect();
				System.out.println(point);

				//更新結果をリクエストスコープに格納
				request.setAttribute("point_z", point);

				//JSPにフォワード
			    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp");
			    rd.forward(request, response);
	}

}
