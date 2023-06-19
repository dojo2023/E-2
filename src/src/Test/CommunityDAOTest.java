package Test;

import java.util.List;

import dao.CommunityDAO;
import model.Community;

public class CommunityDAOTest {
	public static void main(String[] args) {
		CommunityDAO dao = new CommunityDAO();

	//select()のテスト
			List<Community> commList = dao.allselect();
			for (Community card : commList) {
				System.out.println("WRITING_ID：" + card.getWritingid());
				System.out.println("WRITING_FROM：" + card.getWritingform());
				System.out.println("WRITING_TIME：" + card.getWritingtime());
				System.out.println("GOOD：" + card.getGood());
				System.out.println("STAFF_ID：" + card.getStaffid());
				System.out.println();
			}

}
}
