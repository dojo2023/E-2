package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GachaDAO;
import model.Gacha;

/**
 * Servlet implementation class GachaServlet
 */
@WebServlet("/GachaServlet")
public class GachaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
				dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GachaDAO dao = new GachaDAO();

		// asigaruselect()のテスト
		Random random = new Random();
				List<Gacha> gachaList = dao.samuraiselect();

					Gacha asigaru = gachaList.get(random.nextInt(5));
					String asi = asigaru.getGachaname();
					String asiimg = asigaru.getGachapath();

						System.out.println("足軽ガチャ"+asigaru.getGachaname());

						// ガチャ結果をリクエストスコープに格納する
						request.setAttribute("asigaru", asi);
						request.setAttribute("asiimg", asiimg);
						//ガチャ結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gatyaresult.jsp");
						dispatcher.forward(request, response);

	}

}
