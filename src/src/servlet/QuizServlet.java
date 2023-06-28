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
import javax.servlet.http.HttpSession;

import dao.Back_groundDAO;
import dao.ChoiceDAO;
import dao.PointDAO;
import dao.QuizDAO;
import model.Choice;
import model.Ticket_get;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {


	  public void doGet(HttpServletRequest req, HttpServletResponse res)
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

	    // 検索結果をリクエストスコープに格納する
	    req.setAttribute("ChoiceList", ChoiceList);
	    //テスト

	    //ポイント取得
	    HttpSession session = req.getSession();
	    String staff_id = (String)session.getAttribute("staff_id");
	    int st_id = Integer.parseInt(staff_id);

		PointDAO pdao = new PointDAO();
		pdao.connect();
		int quiz_point = pdao.select_point(st_id);//セッションに格納されているスタッフIDを引数に入れる
		pdao.disconnect();

		//検索結果をリクエストスコープに格納
		req.setAttribute("quiz_point", quiz_point);

		//背景を取得する処理
		Back_groundDAO bgdao = new Back_groundDAO();
		bgdao.connect();
		String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
		bgdao.disconnect();
		req.setAttribute("bgid", bgid);

		//JSPにフォワード
	    RequestDispatcher rd_choice = req.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp");
	    rd_choice.forward(req, res);

	  }





	public void doPost(HttpServletRequest req, HttpServletResponse res)
	      throws IOException, ServletException {


		//jspから値を取得
		req.setCharacterEncoding("utf-8");
		int point_pram = Integer.parseInt(req.getParameter("quiz_point")); // JSPのvalue属性を設定した入力値を取得する。
		System.out.println(point_pram);

		// クイズする前
		// 画面ロード時、画面遷移時
		  int qpoint = point_pram;//クイズポイント
		  int i = 50;//何の倍数でチケットがもらえるか
		  for( ; i <= qpoint;  i=i+50){
		    System.out.println(i);
		    //50の倍数を探すだけ
		  }
		// -----------------------------------

		 Ticket_get dao = new Ticket_get();
		//クイズの後
		qpoint = qpoint + 3;//TOPのクイズは１０点

		HttpSession session = req.getSession();
		String staff_id = (String)session.getAttribute("staff_id");
		int st_id = Integer.parseInt(staff_id);


	    if(qpoint%50 == 0 || qpoint > i){
			 dao.addticket(st_id,qpoint);
		  }else{
		    System.out.println("もらえない");
		  }
		  //qpointをDBに格納
		  // チケットをDBに格納


		//ポイントを更新
		PointDAO pdao = new PointDAO();
		pdao.connect();
		int point = pdao.update_point(point_pram,6);//セッションに格納されているスタッフIDを引数に入れる
		pdao.disconnect();

		doGet(req, res);


	  }

}


