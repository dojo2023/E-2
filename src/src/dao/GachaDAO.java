package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gacha;

public class GachaDAO {

	  //足軽ガチャの中身をすべて取得し、リストを表示する
	public List<Gacha> asigaruselect() {
		Connection conn = null;
		List<Gacha> gachaList = new ArrayList<Gacha>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

			// SQL文を準備する
			String sql = "select * from GATYA where TICKET_CLASS = 0";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Gacha gacha = new Gacha(
				rs.getString("GATYA_ID"),
				rs.getString("GATYA_PATH"),
				rs.getString("GATYA_NAME"),
				rs.getString("TICKET_CLASS")
				);
				gachaList.add(gacha);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			gachaList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			gachaList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					gachaList = null;
				}
			}
		}

		// 結果を返す
		return gachaList;
	}


	  //侍ガチャの中身をすべて取得し、リストを表示する
		public List<Gacha> samuraiselect() {
			Connection conn = null;
			List<Gacha> gachaList = new ArrayList<Gacha>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "select * from GATYA where TICKET_CLASS = 1";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Gacha gacha = new Gacha(
					rs.getString("GATYA_ID"),
					rs.getString("GATYA_PATH"),
					rs.getString("GATYA_NAME"),
					rs.getString("TICKET_CLASS")
					);
					gachaList.add(gacha);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				gachaList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				gachaList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						gachaList = null;
					}
				}
			}

			// 結果を返す
			return gachaList;
		}

		  //総大将ガチャの中身をすべて取得し、リストを表示する
		public List<Gacha> taisyouselect() {
			Connection conn = null;
			List<Gacha> gachaList = new ArrayList<Gacha>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "select * from GATYA where TICKET_CLASS = 2";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Gacha gacha = new Gacha(
					rs.getString("GATYA_ID"),
					rs.getString("GATYA_PATH"),
					rs.getString("GATYA_NAME"),
					rs.getString("TICKET_CLASS")
					);
					gachaList.add(gacha);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				gachaList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				gachaList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						gachaList = null;
					}
				}
			}

			// 結果を返す
			return gachaList;
		}
}
