package Test;

import java.util.List;

import dao.GachaTicketDAO;
import model.GachaTicket;

public class GachaTicketDAOTest {
	public static void main(String[] args) {
		GachaTicketDAO dao = new GachaTicketDAO();



	// ticketselect()のテスト
			List<GachaTicket> gachaList = dao.ticketselect("1");
			GachaTicket ticketlist = gachaList.get(0);
        	int asi = ticketlist.getAsgrticket();
        	int smri = ticketlist.getSmriticket();
        	int sds = ticketlist.getSdsticket();

        	System.out.println(asi-1);
        	System.out.println(smri-1);
        	System.out.println(sds-1);


	// ticketupdate()のテスト
				if (dao.sdsupdate(300,"2")) {
					System.out.println("更新成功！");
					List<GachaTicket> gachaList2 = dao.ticketselect("2");
					for (GachaTicket card : gachaList2) {
						System.out.println("足軽：" + card.getAsgrticket());
						System.out.println("侍：" + card.getSmriticket());
						System.out.println("総大将：" + card.getSdsticket());
					}
				}
				else {
					System.out.println("更新失敗！");
				}
	}
}
