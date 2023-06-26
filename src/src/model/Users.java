package model;
import java.io.Serializable;

public class Users implements Serializable {
		private String staff_id;	// STAFF_ID
		private String password;	// PASSWORD
		private String name;
		private String role;
		private String quiz;
		private String answer_time;
		private String mark_id;
		private String background_id;

		public Users(String staff_id, String password, String name, String role,
				String quiz, String answer_time,String mark_id, String background_id) {
			super();
			this.staff_id = staff_id;
			this.password = password;
			this.name = name;
			this.role = role;
			this.quiz = quiz;
			this.answer_time = answer_time;
			this.mark_id = mark_id;
			this.background_id = background_id;
		}

		public Users() {
			this.staff_id = "";
			this.password = "";
			this.name = "";
			this.role = "";
			this.quiz = "";
			this.answer_time = "";
			this.mark_id = "";
			this.background_id = "";
		}

		public String getStaff_id() {
			return staff_id;
		}

		public void setStaff_id(String staff_id) {
			this.staff_id = staff_id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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
		public String getAnswer_time() {
			return answer_time;
		}

		public void setAnswer_time(String answer_time) {
			this.answer_time = answer_time;
		}
		public String getMark_id() {
			return mark_id;
		}

		public void setMark_id(String mark_id) {
			this.mark_id = mark_id;
		}
		public String getBackground_id() {
			return background_id;
		}

		public void setBackground_id(String background_id) {
			this.background_id = background_id;
		}
	}

