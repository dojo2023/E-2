package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChoiceDAO;
import dao.QuizDAO;
import model.Choice;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	      throws IOException, ServletException {
		  Random random = new Random();
		  int rd = random.nextInt(2)+1;
	    QuizDAO qdao = new QuizDAO();
	    qdao.connect();
	    String quiz = qdao.select(rd);
	    qdao.disconnect();
	    //検索結果をリクエストスコープに格納
	    req.setAttribute("quiz", quiz);

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
	    RequestDispatcher rd_choice = req.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp");
	    rd_choice.forward(req, res);
	  }


	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	      throws IOException, ServletException {
	    doPost(req, res);

	  }
	}
