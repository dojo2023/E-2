<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/common.css" rel="stylesheet">
 <link href="./css/community.css" rel="stylesheet">
<title>コミュニティ</title>
</head>
<body>
 <header class="header">
    <div id="hamburger">
      <span class="inner_line" id="line1"></span>
      <span class="inner_line" id="line2"></span>
      <span class="inner_line" id="line3"></span>
    </div>
    <div class="login_select">
      <a href="/kumano_onigiri/TopServlet"><img src="./img/apricon01.png" width="180"></a>
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
        <li><a href="/kumano_onigiri/Work_listServlet">勤怠</a></li>
        <li><a href="/kumano_onigiri/StudyServlet">勉強</a></li>
        <li><a href="/kumano_onigiri/CommunityServlet">コミュニティ</a></li><br><br><br>
        <li><a href="/kumano_onigiri/LogoutServlet">ログアウト</a></li>
      </ul>
    </nav>
  </header>
  <main style="background-image: url('img/${bgid}.png'); background-attachment: fixed;">
    <div class="search_box">
      <form method="GET" action="/kumano_onigiri/CommunitySearchServlet"class="search_form">
        <input type="text" placeholder="コミュニティ内を検索" class="search" name="TEXT">
        <input type="submit" value="検索" class="search_btn">
      </form>
    </div>
    <div class="text_cate">
      <c:forEach var="e" items="${commList}" >
      <c:choose>
  		<c:when test="${e.staffid == num}">
 <div class="text_box_main">
        <div class="text_inf">
          <img src="./img/${e.gatyaid}.png" width="60">
          <div class="user">
          <div class="userid">ID:${e.staffid}</div>
          <div class="name">${e.name}</div>
          <div class="point">${e.qpoint}pt</div>
          </div>
          <div class="time">${e.writingtime}</div>
        </div>
        <div class="text_word-main">
          <textarea class="text-main" readonly id="textid${e.writingid}">${e.writingform}</textarea>
        </div>
        <div class="text_und">
        <img src="./img/edit.svg" class="edit" id="${e.writingid}"onclick="editfun(this.id)">
        <div class="good_ct">${e.good}</div>
        </div>
        </div>
  		</c:when>
   		<c:otherwise>
    <div class="text_box">
        <div class="text_inf">
          <img src="./img/${e.gatyaid}.png" width="60">
          <div class="user">
          	<div class="userid">ID:${e.staffid}</div>
          	<div class="name"id="nameid${e.writingid}">${e.name}</div>
          	<div class="point">${e.qpoint}pt</div>
          </div>
          <div class="time">${e.writingtime}</div>
        </div>
        <div class="text_word">
          <textarea class="text" readonly id="${e.staffid}">${e.writingform}</textarea>
        </div>
        <div class="text_und">
          <img src="./img/reply.svg" class="reply" id="${e.writingid}" onclick="replyfun(this.id)">
          <form method="GET" action="/kumano_onigiri/CommunityGoodServlet" class="gd">
          	<textarea class="editid"name="GOOD" readonly>${e.good}</textarea>
          	<textarea class="editid"name="WRITING_ID" readonly>${e.writingid}</textarea>
          	<input type="image" src="./img/good.svg" class="good" width="30" >
      	  </form>
      	  <div class="good_ct">${e.good}</div>
        </div>
        </div>
  		</c:otherwise>
	</c:choose>
      </c:forEach>
      </div>
    <div class="writing_form">
      <form method="GET" action="/kumano_onigiri/CommuntiyInsert">
        <textarea class="textarea" placeholder="メッセージを書き込む" name="WRITING_FORM" required></textarea>
        <input type="image" src="./img/send.svg" class="submit" width="30" >
      </form>
    </div>

    <!-- ポップアップ用の画面 -->
    <div class="modal_pop">
      <div class="bg"></div>
      <div class="modal_pop_main">
          <div class="content">
            <div class="pop_box">
              <div class="pop">編集/削除</div>
              <img alt="削除" src="./img/batsu.png"class="js-modal-close"width="40">
            </div>
               <form method="GET" id="edit" action="/kumano_onigiri/CommuntiyeditServlet">
                   <textarea class="editid"name="WRITING_ID" readonly></textarea>
                <textarea class="editarea"name="WRITING_FORM">${writingform}</textarea>
              <input type="submit" value="確定" class="edit_btn" name="SUBMIT">
          </form>
          <form method="GET" id="edit" action="/kumano_onigiri/CommuntiydeleteServlet">
          <textarea class="editid"name="WRITING_ID" readonly></textarea>
          <input type="image" src="./img/delete.svg" class="delete" width="50" name="SUBMIT"value="削除">
          </form>
          </div>
      </div>
  </div>
  </main>
</body>
<!-- このリンクを書くことでjqueryが使用できる -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/community.js"></script>
<script type="text/javascript">
var bgid = '<%=request.getAttribute("bgid") %>';
console.log(bgid);
console.log('Bg12' === bgid);
if('Bg12' === bgid){
	const box= document.querySelector('.text_box');
	box.style.backgroundColor = 'red';
	console.log(bgid);
}
</script>


</html>