<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF=8">
    <link href="./css/link.css" rel="stylesheet">
    <title>リンク集</title>
</head>

<body>
    <header class="header">
        <div class="login_select">
           <a href="/kumano_onigiri/TopServlet">
          <img src="./img/apricon01.png" width="180">    </a>
        </div>
         <div class="word_box">
	        <div class="word">
	        今日の用語:${word}
	            <a href="/kumano_onigiri/WardServlet" class="word_button">解説</a>

	        </div>
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
        <h1>リンク集</h1>
        <table border="5" cellpadding="7">
          <tr  bgcolor="#ffffff">
          <th bgcolor="#00bfff">サイト名</th>
          <th bgcolor="#00bfff">リンク</th>
          </tr>
          <tr bgcolor="#ffffff">
          <td>基本情報技術者試験</td>
          <td><a href="https://www.fe-siken.com/fekakomon.php">https://www.fe-siken.com/fekakomon.php</a></td>
          </tr>
          <tr bgcolor="#ffffff">
          <td>応用情報技術者試験</td>
          <td><a href="https://www.ap-siken.com/apkakomon.php">https://www.ap-siken.com/apkakomon.php</a></td>
          </tr>
          <tr bgcolor="#ffffff">
          <td>Progate（プロゲート）</td>
          <td><a href="https://prog-8.com/">https://prog-8.com/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>Schoo（スクー）</td>
          <td><a href="https://schoo.jp/">https://schoo.jp/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>Udemy（ユーデミー）</td>
          <td><a href="https://www.udemy.com/">https://www.udemy.com/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>e-typing</td>
          <td><a href="https://www.e-typing.ne.jp/">https://www.e-typing.ne.jp/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>ThinkIT</td>
          <td><a href="https://thinkit.co.jp/">https://thinkit.co.jp/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>マイナビtech+</td>
          <td><a href="https://news.mynavi.jp/techplus/">https://news.mynavi.jp/techplus/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>WIRED</td>
          <td><a href="https://wired.jp/">https://wired.jp/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>バズ部</td>
          <td><a href="https://lucy.ne.jp/bazubu/">https://lucy.ne.jp/bazubu/</a></td>
          </tr>
          <tr  bgcolor="#ffffff">
          <td>CodeZine</td>
          <td><a href="https://codezine.jp/">https://codezine.jp/</a></td>
          </tr>
          </table>
<br>
<br>
<br>
<br>
<br>

      </main>
</body>

<script  src="./js/link.js"></script>

</html>