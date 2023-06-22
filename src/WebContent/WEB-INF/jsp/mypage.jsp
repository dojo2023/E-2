<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <link href="./css/mypage.css" rel="stylesheet">
    <title>æè?ã®ãã?¼ã¸</title>
</head>

<body>
    <header class="header">
        <div class="login_select">
          <img src="./img/apricon01.png" width="180">
        </div>
        <div class="word_box">
        <div class="word">
            ä»æ¥ã®ç¨èª?:SQLã¤ã³ã¸ã§ã¯ã·ã§ã³<a href="" class="word_button">è§£èª¬</a>

          </div>
          <div class="word_button">
            <div>è§£èª¬</div>
          </div>
        </div>
        <nav id="nav">
          <ul>
            <li><a href="">æè?</a></li>
            <li><a href="">å¤æ?</a></li>
            <li><a href="">åå¼·</a></li>
            <li><a href="">ã³ãã¥ããã£</a></li><br><br><br>
            <li><a href="">ã­ã°ã¢ã¦ã?</a></li>
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
          <h1 class="heading-lv1 text-center">æè?ã®ãã?¼ã¸</h1>
            <figure class="profile-image">
                <img src="C:\kumaoni\mypage\afc4ff684a3f838967d76611b9274164_t.jpeg" alt="æ±æ¢? ã¯ãã?®ãã­ãã£ã¼ã«ç»å?" width="300" height="300">
            </figure>

            <h3 class="heading-lv3 heading-margin text-center">ç¤¾å¡æ?å ±</h3>
            <article>
              <ul class="user-data">
              <li>  ç¤¾å¡ID ${staff_id}</li>
              <li>æ°å ${name}</li>
              <li>ç¤¾å¡åºå?</li>
              <li>ã¯ã¤ãºãã¤ã³ã? ${q_point}</li>
              </ul>
              <br>
            </article>

            <div class="gacha-btn">
             <div><a href="https://www.google.com/maps"  class="gachabutton">ã¬ãã£ãã?¼ã¸ã¸</a></div>
            </div><br><br>


           <div class="box">
            <div class="task-box">
              <h3 style="text-align:center">ä»æ¥ã®ã¿ã¹ã¯</h3>
              content2

            </div>
            &nbsp;&nbsp;
            <div class="option-box">
              <h3 style="text-align:center">ãªãã·ã§ã³</h3><br>




              <div class="radioArea" id="makeImg">
                ã¯ã¤ãºæ©è?½&nbsp;ã<input type="radio" name="n1" id="r1" checked><label for="r1">ON</label>
                <input type="radio" name="n1" id="r2"><label for="r2">OFF</label>
                <!--èæ¯è¨­å®ã?ã¿ã³-->
                 <button id="modalOpen" class="button">èæ¯è¨­å®?</button>
                  <div id="easyModal" class="modal">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h2>&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;èæ¯è¨­å®? </h2>

                        <span class="modalClose">Ã?</span>
                      </div>
                      <div class="modal-body">
                        <br><br><br><br><br><br><br><br>
                        <!--èæ¯ã¢ã¼ãã«ã¦ã£ã³ãã¦å?ã®ãã«ãã¦ã³ã¡ãã¥ã¼-->
                        <div class="mark-select cp_sl01">
                          <select required >
                            <option value="" hidden>èæ¯ãé¸æãã¦ãã ãã</option>
                            <option value="1">cat</option>
                            <option value="2">dog</option>
                            <option value="3">rabbit</option>
                            <option value="4">squirrel</option>
                          </select>
                        </div>
                        <!--èæ¯ã¢ã¼ãã«ã¦ã£ã³ãã¦å?ã®OKãã¿ã³-->
                        <input type="submit" value="OK" class="bg-mark-changebutton">
                      </div>
                    </div>
                  </div><br>

                  <!--ãã?¼ã¯è¨­å®ã?ã¿ã³-->
                  <br>
                  <button id="modalOpen2" class="button2">ãã?¼ã¯è¨­å®?</button>
                  <div id="easyModal2" class="modal2">
                    <div class="modal-content2">
                      <div class="modal-header2">
                        <h2>&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                          &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;ãã?¼ã¯è¨­å®?</h2>

                        <span class="modalClose2">Ã?</span>
                      </div>
                      <div class="modal-body2">
                       <br><br><br><br><br><br><br><br>
                       <!--ãã?¼ã¯è¨­å®ã¢ã¼ãã«ã¦ã£ã³ãã¦å?ã®ãã«ãã¦ã³ã¡ãã¥ã¼-->
                        <div class="mark-select cp_sl01">
                          <select required>
                            <option value="" hidden>ãã?¼ã¯ãé¸æãã¦ãã ãã</option>
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
      <!-- ãã?®ãªã³ã¯ãæ¸ããã¨ã§jqueryãä½¿ç¨ã§ãã -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

      </html>