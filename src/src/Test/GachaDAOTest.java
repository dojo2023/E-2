package Test;

import java.util.List;
import java.util.Random;

import dao.GachaDAO;
import model.Gacha;

public class GachaDAOTest {
	public static void main(String[] args) {
	GachaDAO dao = new GachaDAO();

	// asigaruselect()のテスト
	Random random = new Random();
			List<Gacha> gachaList = dao.asigaruselect();

				Gacha asigaru = gachaList.get(random.nextInt(5));
					System.out.println("足軽ガチャ"+asigaru.getGachaid());

	// samuraiselect()のテスト
				List<Gacha> gachaList1 = dao.samuraiselect();
					Gacha samurai = gachaList1.get(random.nextInt(5));
						System.out.println("侍ガチャ"+samurai.getGachaid());
//taisyouselect()のテスト
			List<Gacha> gachaList2 = dao.asigaruselect();

				Gacha taisyou = gachaList2.get(random.nextInt(5));
					System.out.println("大将軍ガチャ"+taisyou.getGachaid());
}
}
