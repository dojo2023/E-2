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
import dao.Gatya_getDAO;
import model.Gacha;
import model.Gatya_get;

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

		//DBからチケットの枚数を取得
		int asi_tkt = 100;
		int samu_tkt = 30;
		int tai_tkt = 10;
		request.setAttribute("asi_tkt", asi_tkt);
		request.setAttribute("samu_tkt", samu_tkt);
		request.setAttribute("tai_tkt", tai_tkt);
		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
				dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GachaDAO dao = new GachaDAO();
		Gatya_getDAO daoget = new Gatya_getDAO();
		Random random = new Random();

		//DBからチケットの枚数を取得
				int asi_tkt = 100;
				int samu_tkt = 30;
				int tai_tkt = 10;

		// ガチャ処理
		request.setCharacterEncoding("UTF-8");
		String asi_btn = request.getParameter("asigaru");
        String samu_btn = request.getParameter("samurai");
        String tai_btn = request.getParameter("taisyou");


        //足軽ボタンが押されたとき
        if(asi_btn == null) {
        	System.out.println("足軽ボタンは押されていない");
        }else if(asi_btn.equals("はい")){
        	List<Gacha> gachaList = dao.asigaruselect();
        	Gacha gacha = gachaList.get(random.nextInt(5));
        	String asi = gacha.getGachaname();
			String asiimg = gacha.getGachapath();
			//チケットを1枚消費
			asi_tkt = asi_tkt - 1;
			// ガチャ結果をリクエストスコープに格納する
			request.setAttribute("gachaname", asi);
			request.setAttribute("gachapath", asiimg);
			request.setAttribute("btnname", asi_btn);
        }

        if(samu_btn == null) {
        	System.out.println("侍ボタンは押されていない");
        }else if(samu_btn.equals("はい")) {
            //侍ボタンが押されたとき
        	List<Gacha> gachaList = dao.samuraiselect();
        	Gacha gacha = gachaList.get(random.nextInt(5));
        	String samu = gacha.getGachaname();
			String samuimg = gacha.getGachapath();
			String samuid = gacha.getGachaid();
			//GATYAGETテーブルに格納
			if (daoget.idinsert(new Gatya_get(samuid, "1"))) {
				System.out.println("新たなアイテムを手に入れました");			}
			else {
				System.out.println("すでに持っているアイテムです");
			}
			//チケットを1枚消費
			samu_tkt = samu_tkt - 1;
			// ガチャ結果をリクエストスコープに格納する
			request.setAttribute("gachaname", samu);
			request.setAttribute("gachapath", samuimg);
        }
        if(tai_btn == null) {
        	System.out.println("総大将ボタンは押されていない");
        }else if(tai_btn.equals("はい")) {
        	//総大将ボタンが押されたとき
        	List<Gacha> gachaList = dao.taisyouselect();
        	Gacha gacha = gachaList.get(random.nextInt(5));
        	String tai = gacha.getGachaname();
			String taiimg = gacha.getGachapath();
			//チケットを1枚消費
			tai_tkt = tai_tkt - 1;
			// ガチャ結果をリクエストスコープに格納する
			request.setAttribute("gachaname", tai);
			request.setAttribute("gachapath", taiimg);
        }

        //ガチャチケットの枚数をスコープに格納(枚数更新)
        request.setAttribute("asi_tkt", asi_tkt);
    	request.setAttribute("samu_tkt", samu_tkt);
        request.setAttribute("tai_tkt", tai_tkt);

		//ガチャ結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gatyaresult.jsp");
		dispatcher.forward(request, response);
	}

}
