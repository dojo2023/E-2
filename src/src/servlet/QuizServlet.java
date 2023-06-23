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
import dao.PointDAO;
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
		  int rd = random.nextInt(4)+1;

		//問題取得
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


	    //ポイント取得
	    /*HttpSession session = req.getSession();
	    int staff_id = (int)session.getAttribute("staff_id");*/

		PointDAO pdao = new PointDAO();
		pdao.connect();
		int quiz_point = pdao.select_point(6);//セッションに格納されているスタッフIDを引数に入れる
		pdao.disconnect();

		//検索結果をリクエストスコープに格納
		req.setAttribute("quiz_point", quiz_point);

/*
		//jspから値を取得

		int point_pram = Integer.parseInt(req.getParameter("quiz_point")); // JSPのvalue属性を設定した入力値を取得する。

		//ポイントを更新
		pdao.connect();
		int point = pdao.update_point(point_pram,6);//セッションに格納されているスタッフIDを引数に入れる
		pdao.disconnect();

		//更新結果をリクエストスコープに格納
		req.setAttribute("point_z", point);
*/

	    //JSPにフォワード
	    RequestDispatcher rd_choice = req.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp");
	    rd_choice.forward(req, res);
	  }


	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	      throws IOException, ServletException {
	    doPost(req, res);

	  }
	}
