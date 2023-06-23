package model;

public class Login_time {
	private String staff_id;	// STAFF_ID
	private String answer_time;	// ANSWER_TIME

	public Login_time(String staff_id, String answer_time) {
		this.staff_id = staff_id;
		this.answer_time = answer_time;
	}

	public Login_time() {
		this.staff_id = "";
		this.answer_time = "";
	}

	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(String answer_time) {
		this.answer_time = answer_time;
	}


}

