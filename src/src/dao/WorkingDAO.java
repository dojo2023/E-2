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
			String sql = "insert into WORKING values (null, ?, ?, ?, ? ,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getWork_start() != null) {
				pStmt.setString(1, card.getWork_start());
			} else {
				pStmt.setString(1, null);
			}

			if (card.getWork_end() != null) {
				pStmt.setString(2, card.getWork_end());
			} else {
				pStmt.setString(2, null);
			}

			if (card.getWork_style() != null) {
				pStmt.setString(3, card.getWork_style());
			} else {
				pStmt.setString(3, null);
			}

			if (card.getStaff_id() > 0) {
				pStmt.setInt(4, card.getStaff_id());
			}

			if (card.getWork_date() != null) {
				long timeInMilliSeconds = card.getWork_date().getTime();
				pStmt.setDate(5, new java.sql.Date(timeInMilliSeconds));
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
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
			String sql = "select * from WORKING WHERE STAFF_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, param.getStaff_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Working card = new Working(
						rs.getInt("WORK_ID"),
						rs.getString("WORK_START"),
						rs.getString("WORK_END"),
						rs.getString("WORK_STYLE"),
						rs.getInt("STAFF_ID"),
						rs.getDate("WORK_DATE"));
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
	}

	public List<Working> WorkingAllList() {
		Connection conn = null;
		List<Working> cardList = new ArrayList<Working>();
		try {
			//JDBCドライバ読み込む
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

			//DBからデータを取得
			String sql = "select * from WORKING";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Working card = new Working(
						rs.getInt("work_id"),
						rs.getString("work_start"),
						rs.getString("work_end"),
						rs.getString("work_style"),
						rs.getInt("staff_id"),
						rs.getDate("work_date"));

				//可変長配列に格納
				cardList.add(card);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			//DBを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		//結果を返す
		return cardList;
	}

}
