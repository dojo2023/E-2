package model;

import java.util.List;

import dao.GachaTicketDAO;

public class Ticket_get {


	public void addticket(int staffid,int asgr,int smri,int sds) {
		GachaTicketDAO  dao = new GachaTicketDAO();
		String id = String.valueOf(staffid);
		//チケットの枚数を取得
		List<GachaTicket> gachaList = dao.ticketselect(id);
		GachaTicket ticketlist = gachaList.get(0);
    	int asitc = ticketlist.getAsgrticket();
    	int smritc = ticketlist.getSmriticket();
    	int sdstc = ticketlist.getSdsticket();

		//チケットの枚数を計算
    	asitc = asitc + asgr;
    	smritc = smritc + smri;
    	sdstc = sdstc + sds;

		//チケットの枚数を更新
    	dao.asgrupdate(asitc, id);
    	dao.smriupdate(smritc, id);
    	dao.sdsupdate(sdstc,id);
	}

}

