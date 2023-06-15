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
			System.out.println("全取得");
			for (Gacha list : gachaList) {
				System.out.println("GATYA_ID：" + list.getGachaid());
				System.out.println("GATYA_PATH：" + list.getGachapath());
				System.out.println("GATYA_NAME：" + list.getGachaname());
				System.out.println("TICKET_CLASS：" + list.getTicketclass());
				System.out.println();
			}

				Gacha asigaru = gachaList.get(random.nextInt(5));
					System.out.println("足軽ガチャ"+asigaru.getGachaid());
}
	// samuraiselect()のテスト
				List<Gacha> gachaList1 = dao.samuraiselect();
					Gacha language = gachaList1.get(random.nextInt(5));
						System.out.println("侍ガチャ"+language.getGachaid());
	}
//taisyouselect()のテスト
			List<Gacha> gachaList2 = dao.asigaruselect();

				Gacha language = gachaList.get(random.nextInt(5));
					System.out.println("大将軍ガチャ"+language.getGachaid());
}
}
