<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 追加部分 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Study"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>

<%
List<Study> cardList = (List<Study>)session.getAttribute("cardList");
%>
<!-- ここまで -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>拙者の！Garden！|用語一覧</title>
<link rel="stylesheet" href="/kumano_onigiri/css/ward.css">
<link rel="stylesheet" href="/kumano_onigiri/css/common.css">
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
      	<!-- <div class="word_button">
			<button onclick="location.href='/kumano_onigiri/Work_listServlet'">解説</button></div>
        </div> -->
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

<main style="background-image: url('img/${bgid}.png'); background-attachment: fixed;">
	<h3>検索</h3>
		<form method="POST" action="/kumano_onigiri/SearchServlet">
			<div class="search">
	          <input type="text" name="WORD_ITEM" placeholder = 用語を入力>
	          <input type="submit" name="REGIST" value="検索">
			</div>
		</form>
		<nav class="button">
	    	<ul id="ul">
	    		<li><input type="button" name="a_sort" onclick="location.href='/kumano_onigiri/UpSortServlet'" value="昇順"></li>
	    		<li><input type="button" name="d_sort" onclick="location.href='/kumano_onigiri/DownSortServlet'" value="降順"></li>
	    		<li><input type="button" name="n_sort" onclick="location.href='/kumano_onigiri/LatestServlet'" value="新着順"></li>
	    	</ul>
	    </nav>
	<form method="POST" action="/kumano_onigiri/WardServlet">
    <div id="table">
        <table class="w_list">
	    	<c:forEach var="e" items="${cardList}">
 				<tr class="word_row">
				<th>${e.word_item}</th><td>${e.word_ex}</td>
	    		</tr>
			</c:forEach>
        </table>
	</div>    
	</form>
</main>
</body>
<script src="js/common.js"></script>
</html>