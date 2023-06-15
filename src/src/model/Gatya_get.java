package model;

public class Gatya_get {
	private String gachaid;// Gacha_ID
	private String stuffid;// Stuff_Id


	public Gatya_get(String gachaid, String stuffid) {
		super();
		this.gachaid = gachaid;
		this.stuffid = stuffid;
	}

	public Gatya_get() {
		super();
		this.gachaid = "";
		this.stuffid = "";
	}

	public String getGachaid() {
		return gachaid;
	}

	public void setGachaid(String gachaid) {
		this.gachaid = gachaid;
	}

	public String getStuffid() {
		return stuffid;
	}

	public void setStuffid(String stuffid) {
		this.stuffid = stuffid;
	}



}
