package Test;

import dao.Login_timeDAO;

public class Login_timeTest {
	public static void main(String[] args) {

	Login_timeDAO timeDAO = new Login_timeDAO();
	}
	}


//	if(timeDAO.timeupdate("2023-06-21", "6")) {
//		System.out.println("更新成功");
//	}else {
//		System.out.println("更新失敗");
//	}
//	//ANSWER_TIMEを取得
//	List<Login_time> timeList = timeDAO.login_timeget("6");
//	Login_time time = timeList.get(0);
//	//指定のタイムゾーンで現在時刻を取得
//	Calendar cal = Calendar.getInstance();
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	String newlogintime = sdf.format(cal.getTime());
//
//	Date logintime = time.getAnswer_time();
//	String nowtime = new SimpleDateFormat("yyyy-MM-dd").format(logintime);
//
//
//	if(newlogintime.compareTo(nowtime) == 1) {
//		System.out.println("用語を再取得");
//	}else {
//		System.out.println("用語を再取得");
//	}
//}

