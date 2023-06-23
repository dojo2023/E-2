package Test;

import java.util.List;

import dao.Login_timeDAO;
import model.Login_time;

public class Login_timeTest {
	public static void main(String[] args) {
	Login_timeDAO dao = new Login_timeDAO();
	List<Login_time> timeList = dao.login_timeget("6");

	for (Login_time str : timeList) {
		System.out.println(str.getAnswer_time());
	}
}
}
