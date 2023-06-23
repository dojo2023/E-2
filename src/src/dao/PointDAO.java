package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class PointDAO  {
	private final String URL = "jdbc:h2:file:C:\\dojo6\\db\\GardenDB";
	  private final String USER = "sa";
	  private final String PASS = "password";
	  private Connection con = null;

	  public void connect(){
		    try{
		      //①DBに接続
		    	// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");
		      con = DriverManager.getConnection(URL, USER, PASS);
		    } catch(Exception e){
		      e.printStackTrace();
		    }
		  }

	  //ポイント取得
	  public int select_point(int id) {//このIDはセッションの中にあるスタッフID
		    Statement stmt = null;
		    ResultSet rs = null;
		    int result = 0;
		    String sql = "SELECT Q_POINT FROM QPOINT where Staff_id = " + id;
		    try{
		      //②ステートメントを生成
		      stmt = con.createStatement();
		      //③SQLを実行
		      rs = stmt.executeQuery(sql);
		      //④検索結果の処理
		      rs.next();
		      result = rs.getInt("q_point");
		    } catch(Exception e){
		      e.printStackTrace();
		    } finally {
		      try{
		        if(rs != null) rs.close();
		        if(stmt != null) stmt.close();
		      } catch(Exception e){
		        e.printStackTrace();
		      }
		    }
		    return result;
		  }

	//ポイント更新
	  public int update_point(int q_point , int id) {//このIDはセッションの中にあるスタッフID
		    Statement stmt = null;
		    ResultSet rs = null;
		    int result = 0;
		    String sql = "UPDATE QPOINT set q_point = "+ q_point + "where staff_id = " + id;
		    try{
		      //②ステートメントを生成
		      stmt = con.createStatement();
		      //③SQLを実行
		      rs = stmt.executeQuery(sql);
		      //④検索結果の処理
		      rs.next();
		      result = rs.getInt("q_point");
		    } catch(Exception e){
		      e.printStackTrace();
		    } finally {
		      try{
		        if(rs != null) rs.close();
		        if(stmt != null) stmt.close();
		      } catch(Exception e){
		        e.printStackTrace();
		      }
		    }
		    return result;
		  }

	  public void disconnect(){
		    try{
		      //⑤DBを切断
		      if(con != null) con.close();
		    } catch(Exception e){
		      e.printStackTrace();
		    }
	  }

}
