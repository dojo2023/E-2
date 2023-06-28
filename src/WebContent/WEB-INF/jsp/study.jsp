<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <link href="./css/study.css" rel="stylesheet">
    <title>勉強ページ</title>
</head>

<body>
    <header class="header">

        <div class="login_select">
           <a href="/kumano_onigiri/TopServlet">
          <img src="./img/apricon01.png" width="180">   </a>
        </div>
        <div class="word_box">
	        <div class="word">
	        <div>今日の用語:${word}</div>
	            <a href="/kumano_onigiri/WardServlet" class="word_button">解説</a>

	        </div>
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
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br><br><br><br><br>
        <div class="linkbutton3">
          <div><a href="/kumano_onigiri/WardServlet" class="button">用語</a></div>
          <div><a href="/kumano_onigiri/QuizServlet" class="button">クイズ</a></div>
          <div><a href="/kumano_onigiri/LinkServlet" class="button">リンク</a></div>
        </div>
<br><br><br><br><br><br><br><br><br><br><br>
      </main>
</body>
<script  src="./js/study.js"></script>

</html>