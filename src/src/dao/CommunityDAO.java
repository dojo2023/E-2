package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;
import model.Communityjoin;

public class CommunityDAO {
	//投稿情報をすべて取得し、リストを表示する
		public List<Communityjoin> allselect() {
			Connection conn = null;
			List<Communityjoin> commList = new ArrayList<Communityjoin>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "SELECT WRITING_ID ,WRITING_FORM ,WRITING_TIME ,GOOD ,NAME ,MARK_ID ,COMMUNITY .STAFF_ID ,Q_POINT FROM COMMUNITY INNER JOIN USER ON COMMUNITY.STAFF_ID =USER.STAFF_ID INNER JOIN QPOINT  ON COMMUNITY.STAFF_ID =QPOINT .STAFF_ID";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Communityjoin comm = new Communityjoin(
					rs.getString("WRITING_ID"),
					rs.getString("WRITING_FORM"),
					rs.getString("WRITING_TIME"),
					rs.getString("GOOD"),
					rs.getString("NAME"),
					rs.getString("Q_POINT"),
					rs.getString("MARK_ID"),
					rs.getString("STAFF_ID")
					);
					commList.add(comm);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				commList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				commList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						commList = null;
					}
				}
			}

			// 結果を返す
			return commList;
		}

		//書き込みを登録する
		public boolean insert(Community card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "INSERT INTO COMMUNITY (WRITING_FORM,WRITING_TIME,GOOD,STAFF_ID) VALUES (?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getWritingform() != null && !card.getWritingform().equals("")) {
					pStmt.setString(1, card.getWritingform());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getWritingtime() != null && !card.getWritingtime().equals("")) {
					pStmt.setString(2, card.getWritingtime());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getGood() != null && !card.getGood().equals("")) {
					pStmt.setString(3, card.getGood());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getStaffid() != null && !card.getStaffid().equals("")) {
					pStmt.setString(4, card.getStaffid());
				}
				else {
					pStmt.setString(4, null);
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
		//検索する
		public List<Communityjoin> select(String text) {
			Connection conn = null;
			List<Communityjoin> cardList = new ArrayList<Communityjoin>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "SELECT WRITING_ID ,WRITING_FORM ,WRITING_TIME ,GOOD ,NAME ,MARK_ID ,COMMUNITY .STAFF_ID ,Q_POINT FROM COMMUNITY INNER JOIN USER ON COMMUNITY.STAFF_ID =USER.STAFF_ID INNER JOIN QPOINT  ON COMMUNITY.STAFF_ID =QPOINT .STAFF_ID WHERE WRITING_FORM LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setString(1, "%" + text + "%");
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Communityjoin card = new Communityjoin(
							rs.getString("WRITING_ID"),
							rs.getString("WRITING_FORM"),
							rs.getString("WRITING_TIME"),
							rs.getString("GOOD"),
							rs.getString("NAME"),
							rs.getString("Q_POINT"),
							rs.getString("MARK_ID"),
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
		//書き込みを編集する
		public boolean update(String text , String id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "UPDATE COMMUNITY  SET WRITING_FORM  =? where WRITING_ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, text);
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

		//いいねを追加する
		public boolean goodupdate(String good ,String id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "update COMMUNITY set GOOD=? where WRITING_ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, good);
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
		//削除する
		public boolean delete(String writingid) {

			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");

				// SQL文を準備する
				String sql = "delete from COMMUNITY where WRITING_ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, writingid);

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
