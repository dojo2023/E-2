package Test;

import java.util.List;

import dao.CommunityDAO;
import model.Communityjoin;

public class CommunityDAOTest {
	public static void main(String[] args) {
		CommunityDAO dao = new CommunityDAO();

	//select()のテスト
			List<Communityjoin> commList = dao.allselect();
			for (Communityjoin card : commList) {
				System.out.println("WRITING_ID：" + card.getWritingid());
				System.out.println("WRITING_FROM：" + card.getWritingform());
				System.out.println("WRITING_TIME：" + card.getWritingtime());
				System.out.println("GOOD：" + card.getGood());
				System.out.println("NAME：" + card.getName());
				System.out.println("Q_POINT：" + card.getQpoint());
				System.out.println("GATYA_ID：" + card.getGatyaid());
				System.out.println("STAFF_ID：" + card.getStaffid());
				System.out.println();
			}

			// update()のテスト
			System.out.println("---------- update()のテスト ----------");
			if (dao.update("新しい文章編集","80")) {
				System.out.println("更新成功！");
				List<Communityjoin> commList2 = dao.allselect();
				for (Communityjoin card : commList2) {
					System.out.println("WRITING_ID：" + card.getWritingid());
					System.out.println("WRITING_FROM：" + card.getWritingform());
					System.out.println("WRITING_TIME：" + card.getWritingtime());
					System.out.println("GOOD：" + card.getGood());
					System.out.println("NAME：" + card.getName());
					System.out.println("Q_POINT：" + card.getQpoint());
					System.out.println("GATYA_ID：" + card.getGatyaid());
					System.out.println("STAFF_ID：" + card.getStaffid());
					System.out.println();
				}
			}
			else {
				System.out.println("更新失敗！");
			}

}
}
