<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- スタイルシートの挿入 -->
<link href="./css/quizpopup.css" rel="stylesheet">
<link rel="stylesheet" href="/kumano_onigiri/css/top.css">
<link rel="stylesheet" href="/kumano_onigiri/css/common.css">
<head>
<meta charset="UTF-8">
<title>拙者の!Garden</title>
</head>
<body>
<form method="POST" action="/kumano_onigiri/AdminServlet">
</form>
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
        <li><a href="/kumano_onigiri/Work_listServlet">勤怠</a></li>
        <li><a href="/kumano_onigiri/StudyServlet">勉強</a></li>
        <li><a href="/kumano_onigiri/CommunityServlet">コミュニティ</a></li><br><br><br>
        <li><a href="/kumano_onigiri/LogoutServlet">ログアウト</a></li>
</ul>
</nav>
<div id="hamburger">
<span class="inner_line" id="line1"></span>
<span class="inner_line" id="line2"></span>
<span class="inner_line" id="line3"></span>
</div>
</header>

<div class="bg_onetime_popup">
<div class="onetime_popup">
<div class="onetime_popup_title">
<span class="onetime_popup_title_close"></span>
<span>今日のクイズ</span>
</div>
<div class="onetime_popup_content">スマートフォンやタブレットなどの携帯端末に用いられている、OSS(Open Source Software)であるOSはどれか</div>
<form id="quiz" action="" >
<div><label><input type="radio" name="radio">Android</label></div>
<div><label><input type="radio" name="radio">iOS</label></div>
<div><label><input type="radio" name="radio">Safari</label></div>
<div><label><input type="radio" name="radio">Windows</label></div>
<br>
<div class="answerbtm" align="center">
<input type="button" value="回答">
</div>
</form>
</div>
</div>
<!-- このリンクを書くことでjqueryが使用できる-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/quizpopup.js"></script>
<br><br><br>
<div class="time" align="center">
<h1><span id="greeting">ここにあいさつを表示します</span></h1>
</div>
<script src="./js/timehello.js"></script>
<div class="task" align="center">
<div class="btm" align="right">
<a href=""><h1>勤怠一覧</h1></a>
</div>
<img src="./img/kuma.png" width="500">
<br><h1>タスク登録</h1><br>
<input type="text" name="TASK"style="width: 600px; height: 100px;"><br>
</div>
<br>
<div class="btm" align="center">
<input type="submit" name="regist" value="登録">
</div>
<script src="./js/common.js"></script>
</body>
</html>