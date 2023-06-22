package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Study;

public class StudyDAO {
//一覧表示
	public List<Study> StudyAllList(){
		Connection conn = null;
		List<Study> cardList = new ArrayList<Study>();
		try {
			//JDBCドライバ読み込む
			Class.forName("org.h2.Driver");
			
			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");
			
			//DBからデータを取得
			String sql = "select * from WORD";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Study card = new Study(
				rs.getInt("WORD_ID"),
				rs.getString("WORD_ITEM"),
				rs.getString("WORD_EX")
				);
			//可変長配列に格納		
				cardList.add(card);
			}
			rs.close();
			pStmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally {
			//DBを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		
		//結果を返す
		return cardList;
	}
	
//検索
	public List<Study> select(Study param){
		Connection conn = null;
		List<Study> cardList = new ArrayList<Study>();
		try {
			//JDBCドライバ読み込む
			Class.forName("org.h2.Driver");
			
			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB\", \"sa\", \"password");
			
			//DBからデータを取得
			String sql = "select * from WORD WHERE WORD_ITEM LIKE ? ORDER BY WORD_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			//あいまい検索に対応
			if (param.getWord_item() != null) {
				pStmt.setString(1, "%" + param.getWord_item() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			
			// SQL文を実行し結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Study card = new Study(
				rs.getInt("WORD_ID"),
				rs.getString("WORD_ITEM"),
				rs.getString("WORD_EX")
				);
			//可変長配列に格納		
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally {
			//DBを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		
		//結果を返す
		return cardList;
	}
//ソート(昇順)
	public List<Study> StudyUpSort(){
		Connection conn = null;
		List<Study> cardList = new ArrayList<Study>();
		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");
			
			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");
			
			//DBからデータを取得
			String sql = "select * from WORD ORDER BY WORD_ITEM";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Study card = new Study(
				rs.getInt("WORD_ID"),
				rs.getString("WORD_ITEM"),
				rs.getString("WORD_EX")
				);
			//可変長配列に格納		
				cardList.add(card);
			}
			rs.close();
			pStmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally {
			//DBを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		
		//結果を返す
		return cardList;
	}
//ソート(降順)
	public List<Study> StudyDownSort(){
		Connection conn = null;
		List<Study> cardList = new ArrayList<Study>();
		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");
			
			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");
			
			//DBからデータを取得
			String sql = "select * from WORD ORDER BY WORD_ITEM DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Study card = new Study(
				rs.getInt("WORD_ID"),
				rs.getString("WORD_ITEM"),
				rs.getString("WORD_EX")
				);
			//可変長配列に格納		
				cardList.add(card);
			}
			rs.close();
			pStmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally {
			//DBを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		
		//結果を返す
		return cardList;
	}
	
//ソート(新着順)
	public List<Study> StudyNewSort(){
		Connection conn = null;
		List<Study> cardList = new ArrayList<Study>();
		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");
			
			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/db/GardenDB", "sa", "password");
			
			//DBからデータを取得
			String sql = "select * from WORD ORDER BY WORD_ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				Study card = new Study(
				rs.getInt("WORD_ID"),
				rs.getString("WORD_ITEM"),
				rs.getString("WORD_EX")
				);
			//可変長配列に格納		
				cardList.add(card);
			}
			rs.close();
			pStmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally {
			//DBを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		
		//結果を返す
		return cardList;
	}
}
