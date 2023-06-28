package model;
import java.io.Serializable;
import java.util.Date;

public class Working implements Serializable {
	private int work_id;
	private String work_start;
	private String work_end;
	private String work_style;
	private int staff_id;
	private Date work_date;

	public Working(int work_id, String work_start, String work_end, String work_style, int staff_id, Date work_date) {
		super();
		this.work_id = work_id;
		this.work_start = work_start;
		this.work_end = work_end;
		this.work_style = work_style;
		this.staff_id = staff_id;
		this.work_date = work_date;
	}

	public int getWork_id() {
		return work_id;
	}

	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}

	public String getWork_start() {
		return work_start;
	}

	public void setWork_start(String work_start) {
		this.work_start = work_start;
	}

	public String getWork_end() {
		return work_end;
	}

	public void setWork_end(String work_end) {
		this.work_end = work_end;
	}

	public String getWork_style() {
		return work_style;
	}

	public void setWork_style(String work_style) {
		this.work_style = work_style;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public Date getWork_date() {
		return work_date;
	}

	public void setWork_date(Date work_date) {
		this.work_date = work_date;
	}

}
