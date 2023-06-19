package model;

public class Community {
	private String writingid;	// WRITING_ID
	private String writingform;	// WRITING_FROM
	private String writingtime;	// WRITING_TIME
	private String good;	// GOOD
	private String staffid;	// STAFF_ID

	public Community(String writingid, String writingform, String writingtime, String good, String staffid) {
		this.writingid = writingid;
		this.writingform = writingform;
		this.writingtime = writingtime;
		this.good = good;
		this.staffid = staffid;
	}

	public Community() {
		this.writingid = "";
		this.writingform = "";
		this.writingtime = "";
		this.good = "";
		this.staffid = "";
	}

	public String getWritingid() {
		return writingid;
	}

	public void setWritingid(String writingid) {
		this.writingid = writingid;
	}

	public String getWritingform() {
		return writingform;
	}

	public void setWritingform(String writingform) {
		this.writingform = writingform;
	}

	public String getWritingtime() {
		return writingtime;
	}

	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}



}
