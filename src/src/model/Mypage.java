package model;
import java.io.Serializable;

public class Mypage implements Serializable {
		private String staff_id;
		private String name;
		private String role;
		private String quiz;
		private String q_point;
		private String task_thread;
		private String mark_id;

		public Mypage(String staff_id, String name, String role, String quiz, String q_point, String task_thread,
				String mark_id) {
			this.staff_id = staff_id;
			this.name = name;
			this.role = role;
			this.quiz = quiz;
			this.q_point = q_point;
			this.task_thread = task_thread;
			this.mark_id = mark_id;
		}

		public Mypage() {
			this.staff_id = "";
			this.name = "";
			this.role = "";
			this.quiz = "";
			this.q_point = "";
			this.task_thread = "";
			this.mark_id = "";
		}

		public String getStaff_id() {
			return staff_id;
		}

		public void setStaff_id(String staff_id) {
			this.staff_id = staff_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getQuiz() {
			return quiz;
		}

		public void setQuiz(String quiz) {
			this.quiz = quiz;
		}

		public String getQ_point() {
			return q_point;
		}

		public void setQ_point(String q_point) {
			this.q_point = q_point;
		}

		public String getTask_thread() {
			return task_thread;
		}

		public void setTask_thread(String task_thread) {
			this.task_thread = task_thread;
		}

		public String getMark_id() {
			return mark_id;
		}

		public void setMark_id(String mark_id) {
			this.mark_id = mark_id;
		}





}