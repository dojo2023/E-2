<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 追加部分 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Study"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>

<%
List<Study> cardList = (List<Study>)session.getAttribute("cardlist");
%>
<!-- ここまで -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>拙者の！Garden！|勤怠一覧</title>
<link rel="stylesheet" href="/kumano_onigiri/css/common.css">
<link rel="stylesheet" href="/kumano_onigiri/css/work_list.css">
</head>
<body>
<header>
	<div class="login_select">
		<img src="img/apricon01.png" width="180">
    </div>
    <div class="word_box">
    	<div class="word">
			<div>今日の用語:SQLインジェクション</div>
        </div>
        <button class="word_button" onclick="location.href='/kumano_onigiri/WardServlet'">解説</button>
    </div>
    <nav id="nav">
		<ul>
			<li><a href="/kumano_onigiri/MypageServlet">拙者</a></li>
            <li><a href="/kumano_onigiri/WorkingServlet">勤怠</a></li>
            <li><a href="/kumano_onigiri/StudyServlet">勉強</a></li>
            <li><a href="/kumano_onigiri/CommunityServlet">コミュニティ</a></li><br><br><br>
            <li><a href="/kumano_onigiri/LoginServlet">ログアウト</a></li>

        </ul>
   	</nav>
          
    <div id="hamburger">
      <span class="inner_line" id="line1"></span>
      <span class="inner_line" id="line2"></span>
      <span class="inner_line" id="line3"></span>
    </div>
</header>

<main>
<div>
  <table class="w_select">
    <tr>
      <th>社員を選択</th><th>年月を選択</th>
    </tr>
    <tr class="select">
	    <form method="POST" action="/kumano_onigiri/WorkServlet">
	      <th><select id="STAFF_ID" name="STAFF_ID">
		      		<c:forEach var="e" items="${cardList}">
		      			<option>${e.staff_id}</option>
		      		</c:forEach>
	          </select>
	      </th>
	      <th><select id="WORK_DATE" name="WORK_DATE">
		      		<c:forEach var="e" items="${cardList}">
		      			<option>${e.work_date}</option>
		      		</c:forEach>
	          </select>
	      </th>
	    </form>   
      <!-- <th><select id="month" name="month">
            <option value="hokkaido">1月</option>
            <option value="aomori">2月</option>
            <option value="iwate">3月</option>
          </select>
      </th> -->
	    <form method="POST" action="/kumano_onigiri/Work_listServlet">
	      <th>
	       <input type="submit" name="REGIST" value="検索">
	      </th>
	    </form>
    </tr>
  </table>
  
</div>
<div id="table">
    
        <!-- <tr class="data_row"><td>6月1日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月2日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月3日</td><td>9:00</td><td>18:00</td><td>在宅</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月4日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月5日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月6日</td><td>9:00</td><td>18:00</td><td>在宅</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月7日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr> -->
	<c:choose>
  		<c:when test="${empty cardList}">
			<p class = "error">一致する用語がありません。</p>
		</c:when>
	<c:otherwise>
		<table class="work_list">
			<tr class="work_header">
      			<th>日付</th><th>出勤時間</th><th>退勤時間</th><th>勤務形態</th><th>実働時間</th>
  			</tr>
			<c:forEach var="e" items="${cardList}">
   				<tr class="data_row">
   					<td>${e.work_date}</td><td>${e.work_start}</td><td>${e.work_end}</td><td>${e.work_style}</td><td>9時間</td></tr>
   				</tr>
  			</c:forEach>
  		</table>
	</c:otherwise>
  	</c:choose>
</div>
<h2 id="work_msg">合計実働時間</h2>

<h2 id="work_time"></h2>
</main>
</body>
<script src="js/common.js"></script>
<script src="js/work_list.js"></script>
</html>