package model;
import java.io.Serializable;

public class Task implements Serializable {
	private String TASK_ID;
	private String TASK_THREAD;
	private String CALENDAR;
	private int STAFF_ID;

	public Task(String TASK_ID, String TASK_THREAD,String CALENDAR, int STAFF_ID){
		super();
		this.TASK_ID = TASK_ID;
		this.TASK_THREAD = TASK_THREAD;
		this.CALENDAR = CALENDAR;
		this.STAFF_ID = STAFF_ID;
	}

	public Task() {
		super();
		this.TASK_ID = "";
		this.TASK_THREAD = "";
		this.CALENDAR = "";
		this.STAFF_ID = 0;
	}

	public String getTASK_ID() {
		return TASK_ID;
	}

	public void setTASK_ID(String TASK_ID) {
		this.TASK_ID = TASK_ID;
	}

	public String getTASK_THREAD() {
		return TASK_THREAD;
	}

	public void setTASK_THREAD(String TASK_THREAD) {
		this.TASK_THREAD = TASK_THREAD;
	}

	public String getCALENDAR() {
		return CALENDAR;
	}

	public void setCALENDAR(String CALENDAR) {
		this.CALENDAR = CALENDAR;
	}

	public int getSTAFF_ID() {
		return STAFF_ID;
	}

	public void setSTAFF_ID(int STAFF_ID) {
		this.STAFF_ID = STAFF_ID;
	}
}