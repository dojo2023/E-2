package Test;

import java.util.List;

import dao.Gatya_getDAO;
import dao.MypageDAO;
import model.Gatya_get;
import model.Mypage;

public class MypageDAOTest {
	public static void main(String[] args) {
		MypageDAO dao = new MypageDAO();
		Gatya_getDAO gachadao = new Gatya_getDAO();

	//mypageselect()のテスト
			List<Mypage> commList = dao.mypageselect("6");
			for (Mypage card : commList) {
				System.out.println(card.getStaff_id());
				System.out.println(card.getName());
				System.out.println(card.getRole());
				System.out.println(card.getQuiz());
				System.out.println(card.getQ_point());
				System.out.println(card.getTask_thread());
			}

			//mypageselect()のテスト
			List<Gatya_get> commList3 = gachadao.gachapull("6","Mk");
			for (Gatya_get card : commList3) {
				System.out.println(card.getGachaid());
			}


			// update()のテスト
						System.out.println("---------- update()のテスト ----------");
						if (dao.onoffupdate(false, "6")) {
							System.out.println("更新成功！");
							List<Mypage> commList2 = dao.mypageselect("6");
							for (Mypage card : commList2) {
								System.out.println(card.getStaff_id());
								System.out.println(card.getName());
								System.out.println(card.getRole());
								System.out.println(card.getQuiz());
								System.out.println(card.getQ_point());
								System.out.println(card.getTask_thread());
							}
						}
						else {
							System.out.println("更新失敗！");
						}

}
}
