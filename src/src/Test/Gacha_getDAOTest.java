package Test;

import dao.Gatya_getDAO;

public class Gacha_getDAOTest {
	public static void main(String[] args) {
		testInsert();
}
	public static void testInsert() {
//	//idinsert()のテスト
	Gatya_getDAO dao = new Gatya_getDAO();
//	if (dao.idinsert(new Gatya_get("Mk03", "1"))) {
//		System.out.println("testInsert()：テストが成功しました");			}
//	else {
//		System.out.println("testInsert()：テストが失敗しました");
//	}
		if (dao.backupdate("Bg12", "6")) {
			System.out.println("更新成功！");}
		else {
			System.out.println("更新失敗！");
		}
		if (dao.markupdate("Mk12", "6")) {
			System.out.println("更新成功！");

	}
	}
	}
