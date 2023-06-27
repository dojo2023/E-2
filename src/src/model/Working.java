package model;
import java.io.Serializable;

public class Working implements Serializable {
	private String WORK_ID;
	private String WORK_START;
	private String WORK_END;
	private String WORK_STYLE;
	private int STAFF_ID;
	private String WORK_DATE;

	public Working(String WORK_ID, String WORK_START, String WORK_END, String WORK_STYLE
			,int STAFF_ID,String WORK_DATE){
		super();
		this.WORK_ID = WORK_ID;
		this.WORK_START = WORK_START;
		this.WORK_END = WORK_END;
		this.WORK_STYLE = WORK_STYLE;
		this.STAFF_ID = STAFF_ID;
		this.WORK_DATE = WORK_DATE;
	}

	public Working() {
		super();
		this.WORK_ID = "";
		this.WORK_START = "";
		this.WORK_END = "";
		this.WORK_STYLE = "";
		this.STAFF_ID = 0;
		this.WORK_DATE = "";
	}

	public String getWORK_ID() {
		return WORK_ID;
	}

	public void setWORK_ID(String WORK_ID) {
		this.WORK_ID = WORK_ID;
	}

	public String getWORK_START() {
		return WORK_START;
	}

	public void setCompany(String WORK_START) {
		this.WORK_START = WORK_START;
	}

	public String getWORK_END() {
		return WORK_END;
	}

	public void setDepartment(String WORK_END) {
		this.WORK_END = WORK_END;
	}

	public String getWORK_STYLE() {
		return WORK_STYLE;
	}

	public void setWORK_STYLE(String WORK_STYLE) {
		this.WORK_STYLE = WORK_STYLE;
	}

	public int getSTAFF_ID() {
		return STAFF_ID;
	}

	public void setSTAFF_ID(int STAFF_ID) {
		this.STAFF_ID = STAFF_ID;
	}

	public String getWORK_DATE() {
		return WORK_DATE;
	}

	public void setWORK_DATE(String WORK_DATE) {
		this.WORK_DATE = WORK_DATE;
	}
}
