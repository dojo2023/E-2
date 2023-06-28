package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Login_time;

public class Login_timeDAO {


		  //ログイン時の時間を取得するメソッド
		public List<Login_time> login_timeget(int staffid) {
			Connection conn = null;
			List<Login_time> timeList = new ArrayList<Login_time>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "SELECT STAFF_ID ,ANSWER_TIME  FROM USER WHERE STAFF_ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				pStmt.setInt(1,staffid);
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				if (rs.next()) {
					Login_time time = new Login_time(
					rs.getString("STAFF_ID"),
					rs.getDate("ANSWER_TIME")
					);
					timeList.add(time);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				timeList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				timeList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						timeList = null;
					}
				}
			}

			// 結果を返す
			return timeList;
		}

		//時間を更新するメソッド
		public boolean timeupdate(String nowtime,int id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "UPDATE USER SET ANSWER_TIME = ? WHERE STAFF_ID  = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, nowtime);
				pStmt.setInt(2, id);

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
}
