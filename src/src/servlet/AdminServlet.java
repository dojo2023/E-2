package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChoiceDAO;
import dao.PointDAO;
import dao.QuizDAO;
import dao.StudyDAO;
import dao.TaskDAO;
import model.Choice;
import model.Study;
import model.Task;
import model.TodayDate;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String word = (String) session.getAttribute("word");
		int staff_id = Integer.parseInt((String) session.getAttribute("staff_id"));

		TodayDate date = new TodayDate();
		if (date.datecheck(staff_id)) {

			//ランダムで用語と解説を取得する
			StudyDAO studyDAO = new StudyDAO();
			Random random1 = new Random();
			List<Study> wordList = studyDAO.StudyAllList();
			Study todayword = wordList.get(random1.nextInt(wordList.size()));
			String word1 = todayword.getWord_item();
			String wordex = todayword.getWord_ex();

			//用語をスコープに格納
			session.setAttribute("word", word);

			Random random = new Random();
			int rd = random.nextInt(2) + 1;
			QuizDAO qdao = new QuizDAO();
			qdao.connect();
			String quiz = qdao.select(rd);
			qdao.disconnect();

			//検索結果をリクエストスコープに格納
			request.setAttribute("quiz", quiz);

			System.out.println(quiz);

			//解説
			qdao.connect();
			String quiz_ex = qdao.select_3(rd);
			qdao.disconnect();

			//検索結果をリクエストスコープに格納
			request.setAttribute("quiz_ex", quiz_ex);

			//解答群
			ChoiceDAO cdao = new ChoiceDAO();
			cdao.connect();
			ArrayList<Choice> ChoiceList = cdao.select_2(rd);
			cdao.disconnect();
			System.out.println();

			PointDAO pdao = new PointDAO();
			pdao.connect();
			int quiz_point = pdao.select_point(staff_id);//セッションに格納されているスタッフIDを引数に入れる
			pdao.disconnect();

			request.setAttribute("quiz_point", quiz_point);

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("ChoiceList", ChoiceList);
			request.setAttribute("isDateCheck", true);

		} else {
			request.setAttribute("isDateCheck", false);

		}


		//JSPにフォワード
		RequestDispatcher rd_choice = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		rd_choice.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//IDを取得
		HttpSession session = request.getSession();
		int staff_id = Integer.parseInt((String) session.getAttribute("staff_id"));

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String task_thread = request.getParameter("TASK_THREAD");

		// 登録処理を行う
		TaskDAO bDao = new TaskDAO();
		if (bDao.insert(new Task(0, task_thread, new Date(), staff_id))) {
			request.setAttribute("isTaskRegistError", true);
		} else {
			request.setAttribute("isTaskRegistError", false);
		}

		// トップページにフォワードする（再表示）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}
}
