package model;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
	private int task_id;
	private String task_thread;
	private Date calendar;
	private int staff_id;

	public Task(int task_id, String task_thread, Date calendar, int staff_if) {
		super();
		this.task_id = task_id;
		this.task_thread = task_thread;
		this.calendar = calendar;
		this.staff_id = staff_if;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_thread() {
		return task_thread;
	}

	public void setTask_thread(String task_thread) {
		this.task_thread = task_thread;
	}

	public Date getCalendar() {
		return calendar;
	}

	public void setCalendar(Date calendar) {
		this.calendar = calendar;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_if) {
		this.staff_id = staff_if;
	}
}