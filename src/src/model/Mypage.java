package model;
import java.io.Serializable;

public class Mypage implements Serializable {
		private String staff_id;
		private String password;
		private String name;
		private String role;
		private String mark_id;
		private String gatya_id;
		private String task_thread;

		public Mypage(String staff_id, String password, String name, String role,
				String mark_id, String gatya_id, String task_thread) {
			super();
			this.staff_id = staff_id;
			this.password = password;
			this.name = name;
			this.role = role;
			this.mark_id = mark_id;
			this.gatya_id = gatya_id;
			this.task_thread = task_thread;

		}

		public Mypage() {
			this.staff_id = "";
			this.password = "";
			this.name = "";
			this.role = "";
			this.mark_id = "";
			this.gatya_id = "";
			this.task_thread= "";
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
		public String getMark_id() {
			return mark_id;
		}

		public void setMark_id(String mark_id) {
			this.mark_id = mark_id;
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


