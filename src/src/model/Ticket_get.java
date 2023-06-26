package model;

import java.util.List;

import dao.GachaTicketDAO;

public class Ticket_get {


	public void addticket(int staffid,int qpoint) {
		GachaTicketDAO  dao = new GachaTicketDAO();
		String id = String.valueOf(staffid);
		//チケットの枚数を取得
		List<GachaTicket> gachaList = dao.ticketselect(id);
		GachaTicket ticketlist = gachaList.get(0);
    	int asitc = ticketlist.getAsgrticket();
    	int smritc = ticketlist.getSmriticket();
    	int sdstc = ticketlist.getSdsticket();

    	//足軽ランクの場合
    	if(qpoint <= 500) {
    		asitc = asitc + 1;
    	}else if(qpoint >= 501 && qpoint <= 9999) {//侍ランクの場合
    		asitc = asitc + 2;
        	smritc = smritc + 1;
    	}else {//総大将ランクの場合
    		asitc = asitc + 3;
        	smritc = smritc + 2;
        	sdstc = sdstc + 1;
    	}

		//チケットの枚数を更新
    	dao.asgrupdate(asitc, id);
    	dao.smriupdate(smritc, id);
    	dao.sdsupdate(sdstc,id);
	}

}

