package Test;

import dao.Gatya_getDAO;
import model.Gatya_get;

public class Gacha_getDAOTest {
	public static void main(String[] args) {
		testInsert();
}
	public static void testInsert() {
	//idinsert()のテスト
	Gatya_getDAO dao = new Gatya_getDAO();
	if (dao.idinsert(new Gatya_get("Mk03", "1"))) {
		System.out.println("testInsert()：テストが成功しました");			}
	else {
		System.out.println("testInsert()：テストが失敗しました");
	}
	}
}
