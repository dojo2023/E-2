package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskDAO {
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Task card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

			// SQL文を準備する
			String sql = "UPDATE TASK SET TASK_THREAD  = ?, CALENDAR   = ? where STAFF_ID  = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getTask_thread() != null) {
				pStmt.setString(1, card.getTask_thread());
			} else {
				pStmt.setString(1, null);
			}

			if (card.getCalendar() != null) {
				long timeInMilliSeconds = card.getCalendar().getTime();
				pStmt.setDate(2, new java.sql.Date(timeInMilliSeconds));
			}

			if (card.getStaff_id() > 0) {
				pStmt.setInt(3, card.getStaff_id());
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
	public List<Task> select(Task param) {
		Connection conn = null;
		List<Task> cardList = new ArrayList<Task>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

			// SQL文を準備する
			String sql = "select * from TASK WHERE STAFF_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
//			if (param.getTask_id() > 0) {
//				pStmt.setInt(1, param.getTask_id());
//			}
//
//			if (param.getTask_thread() != null && !param.getTask_thread().equals("")) {
//				pStmt.setString(2, param.getTask_thread());
//			} else {
//				pStmt.setString(2, null);
//			}
//
//			if (param.getCalendar() != null && !param.getCalendar().equals("")) {
//				pStmt.setDate(3, (java.sql.Date) param.getCalendar());
//			} else {
//				pStmt.setString(3, null);
//			}

			if (param.getStaff_id() > 0) {
				pStmt.setInt(1, param.getStaff_id());
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Task card = new Task(
						rs.getInt("TASK_ID"),
						rs.getString("TASK_THREAD"),
						rs.getDate("CALENDAR"),
						rs.getInt("STAFF_ID"));
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
}
