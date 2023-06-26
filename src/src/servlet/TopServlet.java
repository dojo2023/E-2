package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChoiceDAO;
import dao.QuizDAO;
import dao.TaskDAO;
import model.Choice;

	@WebServlet("/TopServlet")
	public class TopServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req ,HttpServletResponse res)
			throws ServletException, IOException {

			Random random = new Random();
			int rd = random.nextInt(2)+1;
		    QuizDAO qdao = new QuizDAO();
		    qdao.connect();
		    String quiz = qdao.select(rd);
		    qdao.disconnect();
		    //検索結果をリクエストスコープに格納
		    req.setAttribute("quiz", quiz);

		    System.out.println(quiz);

		    //解説
		    qdao.connect();
		    String quiz_ex = qdao.select_3(rd);
		    qdao.disconnect();
		    //検索結果をリクエストスコープに格納
		    req.setAttribute("quiz_ex", quiz_ex);

		    //解答群
		    ChoiceDAO cdao = new ChoiceDAO();
		    cdao.connect();
		    ArrayList<Choice> ChoiceList = cdao.select_2(rd);
		    cdao.disconnect();
		    System.out.println();
		 // 検索結果をリクエストスコープに格納する
		    req.setAttribute("ChoiceList", ChoiceList);

		    //JSPにフォワード
		    RequestDispatcher rd_choice = req.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		    rd_choice.forward(req, res );

		}

		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

			//ログインIDを取得
			HttpSession session = request.getSession();
			int staff_id = (int)session.getAttribute("staff_id");

		    // リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String task_id = request.getParameter("TASK_ID");
			String task_thread = request.getParameter("TASK_THREAD");
		    String calendar = request.getParameter("CALENDAR");Calendar CALENDAR = Calendar.getInstance();


			// 登録処理を行う
	        TaskDAO bDao = new TaskDAO();
		    if (bDao.insert(task_id,task_thread,calendar,staff_id)) {
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
			dispatcher.forward(request, response);
			}
		}





