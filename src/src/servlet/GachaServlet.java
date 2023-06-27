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

import dao.Back_groundDAO;
import dao.GachaDAO;
import dao.GachaTicketDAO;
import dao.Gatya_getDAO;
import model.Gacha;
import model.GachaTicket;
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
		//ログインIDを取得
		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");

		//背景を取得する処理
				Back_groundDAO bgdao = new Back_groundDAO();
				bgdao.connect();
				String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
				bgdao.disconnect();
				request.setAttribute("bgid", bgid);

		//DBからチケットの枚数を取得
		GachaTicketDAO dao = new GachaTicketDAO();
		List<GachaTicket> gachaList = dao.ticketselect(staff_id);
		GachaTicket ticketlist = gachaList.get(0);
    	int asi = ticketlist.getAsgrticket();
    	int smri = ticketlist.getSmriticket();
    	int sds = ticketlist.getSdsticket();
    	System.out.println(asi);
    	System.out.println(smri);
    	System.out.println(sds);


		request.setAttribute("asi_tkt", asi);
		request.setAttribute("samu_tkt", smri);
		request.setAttribute("tai_tkt", sds);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインIDを取得
		HttpSession session = request.getSession();
		String staff_id = (String)session.getAttribute("staff_id");
		GachaDAO dao = new GachaDAO();
		Gatya_getDAO daoget = new Gatya_getDAO();
		GachaTicketDAO daoticket = new GachaTicketDAO();
		Random random = new Random();

		//DBからチケットの枚数を取得
				List<GachaTicket> gachaList = daoticket.ticketselect(staff_id);
				GachaTicket ticketlist = gachaList.get(0);
		    	int asi = ticketlist.getAsgrticket();
		    	int smri = ticketlist.getSmriticket();
		    	int sds = ticketlist.getSdsticket();

		    	//背景を取得する処理
				Back_groundDAO bgdao = new Back_groundDAO();
				bgdao.connect();
				String bgid = bgdao.select(staff_id);//numのところにstaff_idを入れる
				bgdao.disconnect();
				request.setAttribute("bgid", bgid);

		// ガチャ処理
		request.setCharacterEncoding("UTF-8");
		String asi_btn = request.getParameter("asigaru");
        String samu_btn = request.getParameter("samurai");
        String tai_btn = request.getParameter("taisyou");


        //足軽ボタンが押されたとき
        if(asi_btn == null) {
        	System.out.println("足軽ボタンは押されていない");
        }else if(asi_btn.equals("はい")){
        	List<Gacha> gachaList1 = dao.asigaruselect();
        	Gacha gacha = gachaList1.get(random.nextInt(10));
        	String asiname = gacha.getGachaname();
			String asiimg = gacha.getGachapath();
			String asiid = gacha.getGachaid();
			//GATYAGETテーブルに格納
			if (daoget.idinsert(new Gatya_get(asiid, staff_id))) {
				System.out.println("新たなアイテムを手に入れました");			}
			else {
				System.out.println("すでに持っているアイテムです");
			}
			//チケットを1枚消費
			asi = asi - 1;
			daoticket.asgrupdate(asi,staff_id);
			// ガチャ結果をリクエストスコープに格納する
			request.setAttribute("gachaname", asiname);
			request.setAttribute("gachapath", asiimg);
			request.setAttribute("btnname", asi_btn);
        }

        if(samu_btn == null) {
        	System.out.println("侍ボタンは押されていない");
        }else if(samu_btn.equals("はい")) {
            //侍ボタンが押されたとき
        	List<Gacha> gachaList1 = dao.samuraiselect();
        	Gacha gacha = gachaList1.get(random.nextInt(10));
        	String samuname = gacha.getGachaname();
			String samuimg = gacha.getGachapath();
			String samuid = gacha.getGachaid();
			//GATYAGETテーブルに格納
			if (daoget.idinsert(new Gatya_get(samuid, staff_id))) {
				System.out.println("新たなアイテムを手に入れました");			}
			else {
				System.out.println("すでに持っているアイテムです");
			}
			//チケットを1枚消費
			smri = smri - 1;
			daoticket.smriupdate(smri,staff_id);
			// ガチャ結果をリクエストスコープに格納する
			request.setAttribute("gachaname", samuname);
			request.setAttribute("gachapath", samuimg);
			request.setAttribute("btnname", samu_btn);
        }

        if(tai_btn == null) {
        	System.out.println("総大将ボタンは押されていない");
        }else if(tai_btn.equals("はい")) {
        	//総大将ボタンが押されたとき
        	List<Gacha> gachaList1 = dao.taisyouselect();
        	Gacha gacha = gachaList1.get(random.nextInt(10));
        	String tainame = gacha.getGachaname();
			String taiimg = gacha.getGachapath();
			String sdsid = gacha.getGachaid();
			//GATYAGETテーブルに格納
			if (daoget.idinsert(new Gatya_get(sdsid, staff_id))) {
				System.out.println("新たなアイテムを手に入れました");			}
			else {
				System.out.println("すでに持っているアイテムです");
			}
			//チケットを1枚消費
			sds = sds - 1;
			daoticket.sdsupdate(sds,staff_id);
			// ガチャ結果をリクエストスコープに格納する
			request.setAttribute("gachaname",tainame);
			request.setAttribute("gachapath", taiimg);
        request.setAttribute("btnname", tai_btn);
        }

        //ガチャチケットの枚数をスコープに格納(枚数更新)
        request.setAttribute("asi_tkt", asi);
    	request.setAttribute("samu_tkt", smri);
        request.setAttribute("tai_tkt", sds);

		//ガチャ結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gatyaresult.jsp");
		dispatcher.forward(request, response);
	}
}

