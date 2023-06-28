<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href ="/kumano_onigiri/css/common.css">
<link rel="stylesheet" href="/kumano_onigiri/css/quiz.css" >
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

</head>
<body>

 <header class="header">
        <div class="login_select">
          <a href="/kumano_onigiri/TopServlet">
          <img src="./img/apricon01.png" width="180"> </a>
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

    <!-- jspで背景を適応する -->
	<main style="background-image: url('img/${bgid}.png'); background-attachment: fixed;">

	<!-- クイズコンテンツ -->
	<div class="box">
                <div class="pop">クイズ</div><br>
                <div class="pop"><%= request.getAttribute("quiz") %></div><br>

				<!-- 現在の点数 -->
				現在のポイント:<div class="pop"><%= request.getAttribute("quiz_point") %></div>
				<div id="hoge" title="<%= request.getAttribute("quiz_point") %>"></div>

				<div class="choice_box">
                <form id="quiz" action="/kumano_onigiri/QuizServlet">
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
		        <div class="bg"></div>
		        <div class="modal_pop_main">
		            <div class="content">
		                <div class="pop" id = "edit_area"></div><br>
		                <div class="pop"><%= request.getAttribute("quiz_ex") %></div><br>

						現在のポイント:<div class="pop" id = "quiz_point"></div>
						<form action="/kumano_onigiri/QuizServlet" method="post">
			  				<input type="image" src="./img/mark_batsu.png" class="js-modal-close" width="50">

							<input type="text" value="${quiz_point}" id = "get_point" name="quiz_point"><!-- サーブレットへ渡す -->
						</form>

		                <a href="/servlet/WardServlet/" class="btn-flat-simple"><i class="fa fa-caret-right"></i> 用語解説</a><!-- 用語ページに飛ばす -->
		                <a href="#" id ="btn" class="btn-flat-simple" class="js-modal-close" onclick="window.location.reload();">
		                <i class="fa fa-caret-right" onclick="func_reload()"></i> 次の問題</a>


		            </div>
		    	</div>
    		</div>

 	</main>




</body>
<!-- このリンクを書くことでjqueryが使用できる -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/quiz.js"></script>




</html>

