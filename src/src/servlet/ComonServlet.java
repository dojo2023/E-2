package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Login_timeDAO;
import dao.StudyDAO;
import model.Login_time;
import model.Study;

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
		Login_timeDAO timeDAO = new Login_timeDAO();
		StudyDAO studyDAO = new StudyDAO();
		//ANSWER_TIMEを取得
		List<Login_time> timeList = timeDAO.login_timeget("6");

		//指定のタイムゾーンで現在時刻を取得
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newlogintime = sdf.format(cal.getTime());

		for (Login_time str : timeList) {
			System.out.println(str.getAnswer_time());
		}


		//ランダムで用語と解説を取得する
		Random random = new Random();
		List<Study> wordList = studyDAO.StudyAllList();
		Study todayword = wordList.get(random.nextInt(wordList.size()));
		String word = todayword.getWord_item();
		String wordex = todayword.getWord_ex();
		//用語をスコープに格納
		request.setAttribute("word", word);

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
