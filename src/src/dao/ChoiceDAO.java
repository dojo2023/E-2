package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Choice;
public class ChoiceDAO {
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

	//解答群を取得
	  public ArrayList<Choice> select_2(int id) {
		  ArrayList<Choice> ChoiceList = new ArrayList<>();
		    Statement stmt = null;
		    ResultSet rs = null;
		    Choice result = null;
		    String sql = "SELECT CHOICES,IS_ANSWER FROM CHOICE where QUIZ_ID = " + id;
		    try{
		      //②ステートメントを生成
		      stmt = con.createStatement();
		      //③SQLを実行
		      rs = stmt.executeQuery(sql);
		      //④検索結果の処理
		      while (rs.next()) {
	              // Productオブジェクトの生成
		    	  result = new Choice(rs.getString("choices"),
	              rs.getBoolean("is_answer"));
	              // 生成したproオブジェクトをリストに追加
		    	  ChoiceList.add(result);
		      }

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
		    return ChoiceList;
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
