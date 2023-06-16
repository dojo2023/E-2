package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
