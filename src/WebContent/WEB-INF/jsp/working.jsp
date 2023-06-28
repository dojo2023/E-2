<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/kumano_onigiri/css/working.css">
<link rel="stylesheet" href="/kumano_onigiri/css/common.css">
<head>
<meta charset="UTF-8">
<title>拙者の!Garden</title>
</head>
<body>
    <header class="header">
        <div class="login_select">
          <a href="/kumano_onigiri/TopServlet">
          <img src="./img/apricon01.png" width="180">    </a>
        </div>
        <div class="word_box">
        <div class="word">
            <div>今日の用語:SQLインジェクション</div>
          </div>
          <div class="word_button">
            <div>解説</div>
          </div>
        </div>
        <nav id="nav">
          <ul>
            <li><a href="/kumano_onigiri/MypageServlet">拙者</a></li>
            <li><a href="/kumano_onigiri/WorkingServlet">勤怠</a></li>
            <li><a href="/kumano_onigiri/WorkingServlet">勉強</a></li>
            <li><a href="CommunityServlet">コミュニティ</a></li><br><br><br>
            <li><a href="">ログアウト</a></li>
          </ul>
        </nav>

        <div id="hamburger">
          <span class="inner_line" id="line1"></span>
          <span class="inner_line" id="line2"></span>
          <span class="inner_line" id="line3"></span>
        </div>
      </header>
<form method="POST" action="/kumano_onigiri/WorkingServlet">
<br><br><br><br>

<div class="table">
<table class="work_list" align="right" border="1" width="65%">
<th>日付</th><th>出勤時間</th><th>退勤時間</th><th>勤務形態</th>
</tr>
<c:forEach var="e" items="${cardList}">
	<tr class="data_row"><td>${e.WORK_DATE}</td><td>${e.WORK_START}</td><td>${e.WORK_END}</td><td>${e.WORK_STYLE}</td></tr>
</c:forEach>
</table>
</div>
<h2>　　　　　　　　　　　 出勤時間</h2>
　　　　　　　　　　　　　　　<input type="text" name="WORK_START"style="width: 160px; height: 20px;">
<h2>　　　　　　　　　　　 退勤時間</h2>
　　　　　　　　　　　　　　　<input type="text" name="WORK_END"style="width: 160px; height: 20px;"><br>
<h2>　　　　　　　　　　　勤務形態</h2>
<style>
.box select{
width: 150px;
font-size: 20px;
}
</style>
<div class="box">
　　　　　　　　　　　　　　　 <select name="WORK_STYLE">
<option style="text-align:center;" value = "通勤">通勤</option>
<option style="text-align:center;" value = "在宅">在宅</option>
<option style="text-align:center;" value = "出張">出張</option>
<option style="text-align:center;" value = "早退">外出</option>
<option style="text-align:center;" value = "早退">早退</option>
<option style="text-align:center;" value = "休暇">休暇</option>
<option style="text-align:center;" value = "半休">半休</option>
<option style="text-align:center;" value = "病欠">病欠</option>
</select>
</div>
<br>
<div class="btm1">
　　　　　　　　　　　　　　　　　 <input type="submit" name="auto" value="一括入力" >
</div>
<div class="btm">
<br><br>
　　　　　　　　　　　　　　　　<input type="submit" name="regist" value="登録">
 <input type="reset" name="reset" value="リセット" >
</div>
</form>
<script src="./js/common.js"></script>
</body>
</html>