package model;

public class Gacha {
	private String gachaid;	// Gacha_ID
	private String gachapath;	// Gacha_PATH
	private String gachaname;	// Gacha_NEME
	private String ticketclass;	// TICKET_CLASS

public Gacha(String gachaid, String gachapath, String gachaname, String ticketclass) {
	super();
	this.gachaid = gachaid;
	this.gachapath = gachapath;
	this.gachaname = gachaname;
	this.ticketclass = ticketclass;
}

public Gacha() {
	super();
	this.gachaid = "";
	this.gachapath = "";
	this.gachaname = "";
	this.ticketclass = "";
}

public String getGachaid() {
	return gachaid;
}

public void setGachaid(String gachaid) {
	this.gachaid = gachaid;
}

public String getGachapath() {
	return gachapath;
}

public void setGachapath(String gachapath) {
	this.gachapath = gachapath;
}

public String getGachaname() {
	return gachaname;
}

public void setGachaname(String gachaname) {
	this.gachaname = gachaname;
}

public String getTicketclass() {
	return ticketclass;
}

public void setTicketclass(String ticketclass) {
	this.ticketclass = ticketclass;
}


}

