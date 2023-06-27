<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <link href="./css/mypage.css" rel="stylesheet">
    <title>拙者のページ</title>
</head>

<body>
    <header class="header">
        <div class="login_select">
          <img src="./img/apricon01.png" width="180">
        </div>
        <div class="word_box">
	        <div class="word">
	        今日の用語:SQLインジェクション
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
      <div class="wrap" style="background-image: url('img/${bgid}.png');">
        <div class="content">
          <br> <br><br><br>
          <h1 class="heading-lv1 text-center">拙者のページ</h1>
            <figure class="profile-image">
                <img src="./img/${mark_id}.png"  width="300" height="300">
            </figure>

            <h3 class="heading-lv3 heading-margin text-center">社員情報</h3>
            <article>
              <ul class="user-data">
              <li>社員ID:${staff_id}</li>
              <li>氏名:${name}</li>
              <li>社員区分:${role}</li>
              <li>クイズポイント:${q_point}</li>
               <li>ログイン時クイズ機能:${quiz}</li>
              </ul>
              <br>
            </article>
            <div class="gacha-btn">
             <div><a href="/kumano_onigiri/GachaServlet"  class="gachabutton">ガチャページへ</a></div>
            </div><br><br>


           <div class="box">
            <div class="task-box">
              <h3 style="text-align:center">今日のタスク</h3>
              ${task}

            </div>
            &nbsp;&nbsp;
            <div class="option-box">
              <h3 style="text-align:center">設定</h3><br>


              <div class="radioArea" id="makeImg">
               	<form action="/kumano_onigiri/MypageServlet" method="post">
	                &nbsp;&nbsp;&nbsp;&nbsp;クイズ機能&nbsp; <input type="submit"  id="r1" value="   " name="ON"  class="qonbutton" checked>
	                <label for="r1">ON</label>&nbsp;
	                <input type="submit" id="r2"  value="   "  name="OFF" class="qoffbutton">
                    <label for="r2">OFF</label>
                </form>
                <!--背景設定ボタン-->
                 <button id="modalOpen" class="button">背景設定</button>
                  <div id="easyModal" class="modal">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h2>&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;背景設定</h2>

                        <span class="modalClose">×</span>
                      </div>
                      <div class="modal-body">
                        <br><br><br><br><br><br><br><br>
                        <!--背景モーダルウィンドウのプルダウンメニュー-->
                        <form action="/kumano_onigiri/BackgroundServlet" method="post">
                        <div class="mark-select cp_sl01">
                          <select required name="chenge_bg">
                            <option value="" hidden>背景を選択してください</option>
                            <c:forEach var="e" items="${bgList}" >
 								 <option value = "${e.stuffid}">${e.gachaid}</option>
  							</c:forEach>
                          </select>
                        </div>
                        <!--背景モーダルウィンドウのOKボタン-->
                        <input type="submit" value="OK" class="bg-mark-changebutton">
                        </form>
                      </div>
                    </div>
                  </div><br>

                  <!--マーク設定ボタン-->
                  <br>
                  <button id="modalOpen2" class="button2">マーク設定</button>
                  <div id="easyModal2" class="modal2">
                    <div class="modal-content2">
                      <div class="modal-header2">
                        <h2>&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;マーク設定</h2>

                        <span class="modalClose2">×</span>
                      </div>
                      <div class="modal-body2">
                       <br><br><br><br><br><br><br><br>
                       <!--マーク設定モーダルウィンドウ�?のプルダウンメニュー-->
                        <form action="/kumano_onigiri/MarkServlet" method="post" >
                        <div class="mark-select cp_sl01">
                          <select required name="chenge_mark">
                            <option value="" hidden>マークを選択してください</option>
                            <c:forEach var="e" items="${markList}" >
 								 <option value = "${e.stuffid}" >${e.gachaid}</option>
  							</c:forEach>
	                      </select>
	                        </div>
	                    <div class="button-parent">
	                          <input type="submit" value="OK" class="bg-mark-changebutton">
                        </div>
                         </form>

                      </div>
                    </div>
                  </div>


              </div><br>




           </div>
             <br><br><br><br>


        </div>
      </div>
      </div>
    </body>



      <script  src="./js/mypage.js"></script>
      <!-- こ�?�リンクを書くことでjqueryが使用できる -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
      </html>