package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Back_groundDAO{
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

	//社員IDと背景IDを取得
	  public String select(int id) {
	    Statement stmt = null;
	    ResultSet rs = null;
	    String result = null;
	    String sql = "SELECT BACKGROUND_ID FROM USER where STAFF_ID = " + id;
	    try{
	      //②ステートメントを生成
	      stmt = con.createStatement();
	      //③SQLを実行
	      rs = stmt.executeQuery(sql);
	      //④検索結果の処理
	      rs.next();
	      result = rs.getString("mark_id");
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
