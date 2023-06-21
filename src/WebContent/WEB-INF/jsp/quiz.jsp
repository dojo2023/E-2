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
            <li><a href="">拙者</a></li>
            <li><a href="">勤怠</a></li>
            <li><a href="">勉強</a></li>
            <li><a href="">コミュニティ</a></li><br><br><br>
            <li><a href="">ログアウト</a></li>
          </ul>
        </nav>

        <div id="hamburger">
          <span class="inner_line" id="line1"></span>
          <span class="inner_line" id="line2"></span>
          <span class="inner_line" id="line3"></span>
        </div>
      </header>


	<!-- クイズコンテンツ -->
	<div class="content">
                <div class="pop">クイズ</div><br>
                <div class="pop"><%= request.getAttribute("quiz") %></div>

                <form id="quiz" action="">
                <c:forEach var="e" items="${ChoiceList}">
                <div><label><input type="radio" name="radio" value = "${e.is_answer}">${e.choices}</label>
                </div>

				</c:forEach>
                <input type="button"  class="show_pop" value="回答" onclick="func()">
            	</form>


		    <!-- ポップアップ用の画面 -->
		    <div class="modal_pop">
		        <div class="bg"></div>
		        <div class="modal_pop_main">
		            <div class="content">
		                <div class="pop" id = "edit_area"></div><br>
		                <div class="pop"><%= request.getAttribute("quiz_ex") %></div>

		                <img src="./img/mark_batsu.png" class="js-modal-close" width="50">
		                <a href="#" class="btn-flat-simple"><i class="fa fa-caret-right"></i> 用語解説</a><!-- 用語ページに飛ばす -->
		                <a href="#" id ="btn" class="btn-flat-simple" class="js-modal-close" onclick="window.location.reload();">
		                <i class="fa fa-caret-right" onclick="func_reload()"></i> 次の問題</a>
		            </div>
		    	</div>
    		</div>

	</div>



</body>
<!-- このリンクを書くことでjqueryが使用できる -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/quiz.js"></script>




</html>

