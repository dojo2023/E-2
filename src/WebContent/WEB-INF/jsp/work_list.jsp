<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 追加部分 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Working" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>

<%
List<Working> w_cardList = (List<Working>)session.getAttribute("w_cardList");
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
		<a href="/kumano_onigiri/TopServlet">
          <img src="./img/apricon01.png" width="180">    </a>
    </div>
    <div class="word_box">
    	<div class="word">
			<div>今日の用語:${word}</div>
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
      <th>社員を入力</th>
    </tr>
    <form method="POST" action="/kumano_onigiri/work_listSearchServlet">
    <tr class="select">
      <th>
      	<input type="text" name="STAFF_ID" placeholder = 社員IDを入力>
      </th>
      <th>
       <input type="submit" name="REGIST" value="検索">
	  </th>
    </tr>
    </form>
  </table>
</div>
<form method="POST" action="/kumano_onigiri/Work_listServlet">
<div id="table">
  <c:choose>
  		<c:when test="${empty w_cardList}">
			<p class = "error">勤怠情報が登録されていません。</p>
		</c:when>
	<c:otherwise>
		<table class="work_list">
			<tr class="work_header">
      			<th>日付</th><th>社員ID<th>出勤時間</th><th>退勤時間</th><th>勤務形態</th>
  			</tr>
			<c:forEach var="e" items="${w_cardList}">
   				<tr class="data_row">
   					<td>${e.work_date}</td>
   					<td>${e.staff_id}</td>
   					<td>${e.work_start}</td>
   					<td>${e.work_end}</td>
   					<td>${e.work_style}</td>
   					</tr>
   				</tr>
  			</c:forEach>
  		</table>
	</c:otherwise>
  </c:choose>
</div>
</form>
<<!-- h2 id="work_msg">合計実働時間</h2> -->

<h2 id="work_time"></h2>
</main>
</body>
<script src="js/common.js"></script>
<script src="js/work_list.js"></script>
</html>