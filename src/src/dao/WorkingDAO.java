package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Working;

public class WorkingDAO {
		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Working card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "insert into WORKING values (?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getWORK_START() != null && !card.getWORK_START().equals("")) {
					pStmt.setString(1, card.getWORK_START());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getWORK_END() != null && !card.getWORK_END().equals("")) {
					pStmt.setString(2, card.getWORK_END());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getWORK_STYLE() != null && !card.getWORK_STYLE().equals("")) {
					pStmt.setString(3, card.getWORK_STYLE());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getSTAFF_ID() != null && !card.getSTAFF_ID().equals("")) {
					pStmt.setString(4, card.getSTAFF_ID());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getWORK_DATE() != null && !card.getWORK_DATE().equals("")) {
					pStmt.setString(5, card.getWORK_DATE());
				}
				else {
					pStmt.setString(5, null);
				}


				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Working> select(Working param) {
			Connection conn = null;
			List<Working> cardList = new ArrayList<Working>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "select * from WORKING WHERE STAFF_ID = \" + STAFF_ID";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getWORK_ID() != null) {
					pStmt.setString(1, "%" + param.getWORK_ID() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getWORK_START() != null) {
					pStmt.setString(2, "%" + param.getWORK_START() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getWORK_END() != null) {
					pStmt.setString(3, "%" + param.getWORK_END() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getWORK_STYLE() != null) {
					pStmt.setString(4, "%" + param.getWORK_STYLE() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getSTAFF_ID() != null) {
					pStmt.setString(5, "%" + param.getSTAFF_ID() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				if (param.getWORK_DATE() != null) {
					pStmt.setString(6, "%" + param.getWORK_DATE() + "%");
				}
				else {
					pStmt.setString(6, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Working card = new Working(
					rs.getString("WORK_ID"),
					rs.getString("WORK_START"),
					rs.getString("WORK_END"),
					rs.getString("WORK_STYLE"),
					rs.getString("STAFF_ID"),
					rs.getString("WORK_DATE")
					);
					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}
			// 結果を返す
			return cardList;
		}
}
