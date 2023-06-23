package Test;

import java.util.List;
import java.util.Random;

import dao.StudyDAO;
import model.Study;

public class TodayWordTest {
	public static void main(String[] args) {
	StudyDAO dao = new StudyDAO();

	//ランダムで用語と解説を取得するメソッドのテスト
	Random random = new Random();
	List<Study> wordList = dao.StudyAllList();
	Study todayword = wordList.get(random.nextInt(wordList.size()));
	System.out.println("今日の用語："+ todayword.getWord_item());
	System.out.println("解説："+ todayword.getWord_ex());
}
}
