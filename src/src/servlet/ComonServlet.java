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
import javax.servlet.http.HttpSession;

import dao.StudyDAO;
import model.Study;
import model.Ticket_get;
import model.TodayDate;

/**
 * Servlet implementation class Comon
 */
@WebServlet("/Comon")
public class ComonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


/*------------------今日の用語の処理-----------------------*/
		StudyDAO studyDAO = new StudyDAO();
		TodayDate todaydate = new TodayDate();


		Ticket_get get = new Ticket_get();
		get.addticket(6,800);


		if(todaydate.datecheck("6")) {
			System.out.println("日付が変わったときの処理");

			//ランダムで用語と解説を取得する
			Random random = new Random();
			List<Study> wordList = studyDAO.StudyAllList();
			Study todayword = wordList.get(random.nextInt(wordList.size()));
			String word = todayword.getWord_item();
			String wordex = todayword.getWord_ex();

			//用語をスコープに格納
			HttpSession session = request.getSession();
			session.setAttribute("word", word);

		}else {
			System.out.println("日付が変わらないときの処理");
		}
/*------------------------------------------------------------*/

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
