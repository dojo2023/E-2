package Test;
import java.util.List;

import dao.StudyDAO;
import model.Study;

public class StudyDAOTest {
	public static void main(String[] args) {
		StudyDAO dao = new StudyDAO();
		
		//検索テスト
		System.out.println("---------- select()のテスト ----------");
		List<Study> cardList2 = dao.select(new Study());
		for (Study card : cardList2) {
			System.out.println("WORD_ID：" + card.getWord_id());
			System.out.println("WORD_ITEM：" + card.getWord_item());
			System.out.println("WORD_EX：" + card.getWord_ex());
			System.out.println();
		}
	}
}