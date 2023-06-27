<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    		<li><a href="/kumano_onigiri/UpSortServlet"><input type="button" name="a_sort" value="昇順"></a></li>
	    		<li><a href="/kumano_onigiri/DownSortServlet"><input type="button" name="d_sort" value="降順"></a></li>
	    		<li><a href="/kumano_onigiri/LatestServlet"><input type="button" name="n_sort" value="新着順"></a></li>
	    	</ul>
	    </nav>
	<form method="POST" action="/kumano_onigiri/WardServlet">
    <div id="result_table">
    	<c:choose>
	    	<c:when test="${empty cardList}">
	    		<p class = "error">一致する用語がありません。</p>
	    	</c:when>
	    	<c:otherwise>
		        <table class="w_list">
			    	<c:forEach var="e" items="${cardList}">
		 				<tr class="word_row">
						<th>${e.word_item}</th><td>${e.word_ex}</td>
			    		</tr>
					</c:forEach>
		        </table>
		   	</c:otherwise>
	   	</c:choose>
	</div>    
	</form>
</main>
</body>
<script src="js/common.js"></script>
</html>