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
			String sql = "insert into TASK values (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getTASK_ID() != null) {
				pStmt.setString(1, "%" + card.getTASK_ID() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (card.getTASK_THREAD() != null) {
				pStmt.setString(2, "%" + card.getTASK_THREAD() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (card.getCALENDAR() != null) {
				pStmt.setString(3, "%" + card.getCALENDAR() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (card.getSTAFF_ID() != null) {
				pStmt.setString(4, "%" + card.getSTAFF_ID() + "%");
			}
			else {
				pStmt.setString(4, "%");
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
			public List<Task> select(Task param) {
				Connection conn = null;
				List<Task> cardList = new ArrayList<Task>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

					// SQL文を準備する
					String sql = "select * from TASK WHERE STAFF_ID = \" + STAFF_ID";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (param.getTASK_ID() != null) {
						pStmt.setString(1, "%" + param.getTASK_ID() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (param.getTASK_THREAD() != null && !param.getTASK_THREAD().equals("")) {
						pStmt.setString(2, param.getTASK_THREAD());
					}
					else {
						pStmt.setString(2, null);
					}
					if (param.getCALENDAR() != null && !param.getCALENDAR().equals("")) {
						pStmt.setString(3, param.getCALENDAR());
					}
					else {
						pStmt.setString(3, null);
					}
					if (param.getSTAFF_ID() != null && !param.getSTAFF_ID().equals("")) {
						pStmt.setString(4, param.getSTAFF_ID());
					}
					else {
						pStmt.setString(4, null);
					}

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
						while (rs.next()) {
							Task card = new Task(
							rs.getString("TASK_ID"),
							rs.getString("TASK_THREAD"),
							rs.getString("CALENDAR"),
							rs.getString("STAFF_ID")
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
