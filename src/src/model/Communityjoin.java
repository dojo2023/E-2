package model;

public class Communityjoin {
	private String writingid;	// WRITING_ID
	private String writingform;	// WRITING_FROM
	private String writingtime;	// WRITING_TIME
	private String good;	// GOOD
	private String name;	// NAME
	private String qpoint;	// Q_POINT
	private String gatyaid;	// GATYA_ID
	private String staffid;	// STAFF_ID


	public Communityjoin(String writingid, String writingform, String writingtime, String good, String name,
			String qpoint, String gatyaid, String staffid) {
		this.writingid = writingid;
		this.writingform = writingform;
		this.writingtime = writingtime;
		this.good = good;
		this.name = name;
		this.qpoint = qpoint;
		this.gatyaid = gatyaid;
		this.staffid = staffid;
	}
	public Communityjoin() {
		this.writingid = "";
		this.writingform = "";
		this.writingtime = "";
		this.good = "";
		this.name = "";
		this.qpoint = "";
		this.gatyaid = "";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQpoint() {
		return qpoint;
	}
	public void setQpoint(String qpoint) {
		this.qpoint = qpoint;
	}
	public String getGatyaid() {
		return gatyaid;
	}
	public void setGatyaid(String gatyaid) {
		this.gatyaid = gatyaid;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}



}
