package dao;

import java.sql.Connection;

import model.Users;

public class MypageDAO {
	// ログインできるならtrueを返す
		public boolean isLoginOK(Users mypage) {
			Connection conn = null;
			boolean loginResult = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SELECT文を準備する

		}
	}
}