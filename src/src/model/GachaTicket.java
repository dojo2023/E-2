package model;

public class GachaTicket {
	private int asgrticket;//ASGR_TICKET
	private int smriticket;//SMRI_TICKET
	private int sdsticket;//SDS_TICKET

	public GachaTicket(int asgrticket, int smriticket, int sdsticket) {
		this.asgrticket = asgrticket;
		this.smriticket = smriticket;
		this.sdsticket = sdsticket;
	}

	public GachaTicket() {
		this.asgrticket = 0;
		this.smriticket = 0;
		this.sdsticket = 0;
	}

	public int getAsgrticket() {
		return asgrticket;
	}

	public void setAsgrticket(int asgrticket) {
		this.asgrticket = asgrticket;
	}

	public int getSmriticket() {
		return smriticket;
	}

	public void setSmriticket(int smriticket) {
		this.smriticket = smriticket;
	}

	public int getSdsticket() {
		return sdsticket;
	}

	public void setSdsticket(int sdsticket) {
		this.sdsticket = sdsticket;
	}


}

