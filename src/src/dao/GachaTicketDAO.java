package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GachaTicket;

public class GachaTicketDAO {


		  //チケットをすべて取得し、リストを表示する
		public List<GachaTicket> ticketselect(String staffid) {
			Connection conn = null;
			List<GachaTicket> ticketList = new ArrayList<GachaTicket>();
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "SELECT ASGR_TICKET ,SMRI_TICKET ,SDS_TICKET FROM TICKET  INNER JOIN USER ON TICKET.STAFF_ID =USER.STAFF_ID WHERE USER.STAFF_ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				pStmt.setString(1, staffid);
				ResultSet rs = pStmt.executeQuery();
				// 結果表をコレクションにコピーする

				while (rs.next()) {
					GachaTicket card = new GachaTicket(
							rs.getInt("ASGR_TICKET"),
							rs.getInt("SMRI_TICKET"),
							rs.getInt("SDS_TICKET")
					);
					ticketList.add(card);
				}

			}
			catch (SQLException e) {
				e.printStackTrace();
				ticketList = null;

			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				ticketList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						ticketList = null;
					}
				}
			}

			// 結果を返す
			return ticketList;
		}

		//足軽チケットを更新する
				public boolean asgrupdate(int number,String id) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

						// SQL文を準備する
						String sql = "UPDATE TICKET  SET ASGR_TICKET  = ? where STAFF_ID  = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setInt(1, number);
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
				//侍チケットを更新する
				public boolean smriupdate(int number,String id) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

						// SQL文を準備する
						String sql = "UPDATE TICKET  SET SMRI_TICKET  = ? where STAFF_ID  = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setInt(1, number);
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
				//総大将チケットを更新する
				public boolean sdsupdate(int number,String id) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

						// SQL文を準備する
						String sql = "UPDATE TICKET  SET SDS_TICKET  = ? where STAFF_ID  = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setInt(1, number);
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
