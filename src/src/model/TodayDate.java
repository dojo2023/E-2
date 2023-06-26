package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.Login_timeDAO;

public class TodayDate {

	public boolean datecheck(String staffid) {
		boolean result = false;
		Login_timeDAO timeDAO = new Login_timeDAO();
		//ANSWER_TIMEを取得
		List<Login_time> timeList = timeDAO.login_timeget(staffid);
		Login_time time = timeList.get(0);
		//指定のタイムゾーンで現在時刻を取得
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newlogintime = sdf.format(cal.getTime());

		Date logintime = time.getAnswer_time();
		String nowtime = new SimpleDateFormat("yyyy-MM-dd").format(logintime);


		if(newlogintime.compareTo(nowtime) == 1) {
			result = true;
		}else {
			result = false;
		}


		return result;
	}
}

