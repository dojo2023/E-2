package model;

import java.io.Serializable;

public class Qpoint implements Serializable{
	private int staff_id;
	private int q_point;

	public Qpoint(int staff_id,int q_point) {
		super();
		this.staff_id = staff_id;
		this.q_point = q_point;
	}

	public Qpoint() {
		super();
		this.staff_id = 1;
		this.q_point = 1;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public int getQ_point() {
		return q_point;
	}

	public void setQ_point(int q_point) {
		this.q_point = q_point;
	}


}
