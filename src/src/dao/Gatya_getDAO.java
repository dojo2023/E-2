package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gatya_get;

public class Gatya_getDAO {
	// 引数ididで指定されたGATYA_IDとSTAFF_IDを登録し、成功したらtrueを返す
			public boolean idinsert(Gatya_get idid) {
				Connection conn = null;
				boolean gachaResult = false;


				try {// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

					// SQL文を準備する
					String sql = "INSERT INTO GATYAGET (GATYA_ID,STAFF_ID) VALUES (?,?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (idid.getGachaid() != null && !idid.getGachaid().equals("")) {
						pStmt.setString(1, idid.getGachaid());
					}
					else {
						pStmt.setString(1, null);
					}
					if (idid.getStuffid() != null && !idid.getStuffid().equals("")) {
						pStmt.setString(2, idid.getStuffid());
					}
					else {
						pStmt.setString(2, null);
					}

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						gachaResult = true;
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
				return gachaResult;
			}

			//ガチャIDをプルダウンで表示する機能
			public List<Gatya_get> gachapull(String staffid,String gachaid) {
				Connection conn = null;
				List<Gatya_get> pullList = new ArrayList<Gatya_get>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

					// SQL文を準備する
					String sql = "SELECT GATYA_NAME,STAFF_ID FROM GATYAGET INNER JOIN GATYA  ON GATYAGET .GATYA_ID  = GATYA .GATYA_ID WHERE STAFF_ID = ? AND GATYA .GATYA_ID LIKE ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を実行し、結果表を取得する
					pStmt.setString(1, staffid);
					pStmt.setString(2, "%" + gachaid + "%");
					ResultSet rs = pStmt.executeQuery();
					// 結果表をコレクションにコピーする

					while (rs.next()) {
						Gatya_get card = new Gatya_get(
								rs.getString("GATYA_NAME"),
								rs.getString("STAFF_ID")
						);
						pullList.add(card);
					}

				}
				catch (SQLException e) {
					e.printStackTrace();
					pullList = null;

				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					pullList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							pullList = null;
						}
					}
				}

				// 結果を返す
				return pullList;
			}

			//背景を更新する処理
			public boolean backupdate(String gatya_id ,String id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

					// SQL文を準備する
					String sql = "UPDATE USER   SET BACKGROUND_ID  = ? where STAFF_ID  = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, gatya_id);
					pStmt.setString(2, id);

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
			//マークを更新する処理
			public boolean markupdate(String gatya_id ,String id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

					// SQL文を準備する
					String sql = "UPDATE USER   SET MARK_ID  = ? where STAFF_ID  = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, gatya_id);
					pStmt.setString(2, id);

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
