package Test;

import java.util.List;

import dao.MypageDAO;
import model.Mypage;

public class MypageDAOTest {
	public static void main(String[] args) {
		MypageDAO dao = new MypageDAO();

	//mypageselect()のテスト
			List<Mypage> commList = dao.mypageselect("6");
			for (Mypage card : commList) {
				System.out.println(card.getStaff_id());
				System.out.println(card.getName());
				System.out.println(card.getRole());
				System.out.println(card.getQuiz());
				System.out.println(card.getQ_point());
				System.out.println(card.getGatya_id());
				System.out.println(card.getTask_thread());
			}


}
}
