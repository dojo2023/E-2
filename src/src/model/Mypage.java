package model;
import java.io.Serializable;

public class Mypage implements Serializable {
		private String staff_id;
		private String name;
		private String role;
		private String quiz;
		private String q_point;
		private String gatya_id;
		private String task_thread;
		public Mypage(String staff_id, String name, String role, String quiz, String q_point, String gatya_id,
				String task_thread) {

			this.staff_id = staff_id;
			this.name = name;
			this.role = role;
			this.quiz = quiz;
			this.q_point = q_point;
			this.gatya_id = gatya_id;
			this.task_thread = task_thread;
		}
		public Mypage() {

			this.staff_id = "";
			this.name = "";
			this.role = "";
			this.quiz = "";
			this.q_point = "";
			this.gatya_id = "";
			this.task_thread = "";
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
		public String getGatya_id() {
			return gatya_id;
		}
		public void setGatya_id(String gatya_id) {
			this.gatya_id = gatya_id;
		}
		public String getTask_thread() {
			return task_thread;
		}
		public void setTask_thread(String task_thread) {
			this.task_thread = task_thread;
		}

}