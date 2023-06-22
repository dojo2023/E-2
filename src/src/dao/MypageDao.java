package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mypage;

public class MypageDAO{
	//チケットをすべて取得し、リストを表示する
			public List<Mypage> mypageselect(String staffid) {
				Connection conn = null;
				List<Mypage> mypageList = new ArrayList<Mypage>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

					// SQL文を準備する
					String sql = "SELECT  USER .STAFF_ID ,NAME ,ROLE ,QUIZ ,GATYA_ID ,TASK_THREAD ,Q_POINT FROM USER  INNER JOIN QPOINT   ON USER .STAFF_ID = QPOINT  .STAFF_ID INNER JOIN TASK    ON USER .STAFF_ID = TASK   .STAFF_ID WHERE USER .STAFF_ID = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を実行し、結果表を取得する
					pStmt.setString(1, staffid);
					ResultSet rs = pStmt.executeQuery();
					// 結果表をコレクションにコピーする

					while (rs.next()) {
						Mypage card = new Mypage(
								rs.getString("STAFF_ID"),
								rs.getString("NAME"),
								rs.getString("ROLE"),
								rs.getString("QUIZ"),
								rs.getString("Q_POINT"),
								rs.getString("GATYA_ID"),
								rs.getString("TASK_THREAD")
						);
						mypageList.add(card);
					}

				}
				catch (SQLException e) {
					e.printStackTrace();
					mypageList = null;

				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					mypageList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							mypageList = null;
						}
					}
				}

				// 結果を返す
				return mypageList;
			}
}