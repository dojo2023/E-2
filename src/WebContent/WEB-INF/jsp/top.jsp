<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/kumano_onigiri/css/top.css">
<link rel="stylesheet" href="/kumano_onigiri/css/quizpopup.css">
<link rel="stylesheet" href="/kumano_onigiri/css/common.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<meta charset="UTF-8">
<title>拙者の!Garden</title>
<body>
    <header class="header">
        <div class="login_select">
          <img src="./img/apricon01.png" width="180">
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
</body>
<br><br><br>
	<!-- クイズコンテンツ -->
	<div class="bg_onetime_popup">
	<div class="onetime_popup">
                <div class="onetime_popup_title">クイズ<span class="onetime_popup_title_close"></span>
                </div>
                <div class="onetime_popup_content"><%= request.getAttribute("quiz") %></div>
                <form id="quiz" action="">
                <c:forEach var="e" items="${ChoiceList}">
                <div><label><input type="radio" name="radio" value = "${e.is_answer}">${e.choices}</label>
                </div>
				</c:forEach>
                <input type="button"  class="show_pop" value="回答" onclick="func()">
            	</form>
            	</div>
            	</div>
<!-- ポップアップ用の画面 -->
<div class="modal_pop">
<div class="bg_onetime_popup">
<div class="onetime_popup">
<div class="onetime_popup_title" id = "edit_area" >
</div>
<div class="onetime_popup_content">
<%= request.getAttribute("quiz_ex") %>
<a href="#" class="btn-flat-simple">
<i class="fa fa-caret-right"></i> 用語解説ページへ</a><!-- 用語ページに飛ばす -->
<img src="./img/mark_batsu.png" class="js-modal-close" width="50">
</div>
</div>
</div>
</div>
<!-- このリンクを書くことでjqueryが使用できる -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/quizpopup.js"></script>

<br><br><br>
<div class="time" align="center">
<h1><span id="greeting">ここにあいさつを表示します</span></h1>
</div>

<script src="./js/timehello.js"></script>

<form method="POST" action="/kumano_onigiri/TopServlet">
<div class="task" align="center">
<br><br><h1>タスク登録</h1><br>
<input type="text" name="TASK_THREAD"style="width: 600px; height: 100px;"><br>
</div>
<br>
<div class="btm" align="center">
<input type="submit" name="regist" value="登録">
</div>
</form>
</body>
</html>