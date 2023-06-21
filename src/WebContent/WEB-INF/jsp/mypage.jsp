<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <div class="wrap">
        <div class="content">
          <br> <br><br><br>
          <h1 class="heading-lv1 text-center">拙者のページ</h1>
            <figure class="profile-image">
                <img src="C:\kumaoni\mypage\afc4ff684a3f838967d76611b9274164_t.jpeg" alt="東條 はるのプロフィール画像" width="300" height="300">
            </figure>

            <h3 class="heading-lv3 heading-margin text-center">社員情報</h3>
            <article>
              <ul class="user-data">
              <li>  社員ID</li>
              <li>氏名</li>
              <li>社員区分</li>
              <li>クイズポイント</li>
              </ul>
              <br>
            </article>

            <div class="gacha-btn">
             <div><a href="https://www.google.com/maps"  class="gachabutton">ガチャページへ</a></div>
            </div><br><br>


           <div class="box">
            <div class="task-box">
              <h3 style="text-align:center">今日のタスク</h3>
              content2

            </div>
            &nbsp;&nbsp;
            <div class="option-box">
              <h3 style="text-align:center">オプション</h3><br>




              <div class="radioArea" id="makeImg">
                クイズ機能&nbsp;　<input type="radio" name="n1" id="r1" checked><label for="r1">ON</label>
                <input type="radio" name="n1" id="r2"><label for="r2">OFF</label>
                <!--背景設定ボタン-->
                 <button id="modalOpen" class="button">背景設定</button>
                  <div id="easyModal" class="modal">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h2>&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;背景設定 </h2>

                        <span class="modalClose">×</span>
                      </div>
                      <div class="modal-body">
                        <br><br><br><br><br><br><br><br>
                        <!--背景モーダルウィンドウ内のプルダウンメニュー-->
                        <div class="mark-select cp_sl01">
                          <select required >
                            <option value="" hidden>背景を選択してください</option>
                            <option value="1">cat</option>
                            <option value="2">dog</option>
                            <option value="3">rabbit</option>
                            <option value="4">squirrel</option>
                          </select>
                        </div>
                        <!--背景モーダルウィンドウ内のOKボタン-->
                        <input type="submit" value="OK" class="bg-mark-changebutton">
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
                       <!--マーク設定モーダルウィンドウ内のプルダウンメニュー-->
                        <div class="mark-select cp_sl01">
                          <select required>
                            <option value="" hidden>マークを選択してください</option>
                            <option value="1">cat</option>
                            <option value="2">dog</option>
                            <option value="3">rabbit</option>
                            <option value="4">squirrel</option>
                          </select>
                        </div>
                        <div class="button-parent">
                          <input type="submit" value="OK" class="bg-mark-changebutton">
                        </div>

                      </div>
                    </div>
                  </div>


              </div><br>




           </div>
             <br><br><br><br>


        </div>
      </div>
    </body>



      <script  src="./js/mypage.js"></script>
      <!-- このリンクを書くことでjqueryが使用できる -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

      </html>