<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="./css/common.css" rel="stylesheet">
    <link href="./css/gacha.css" rel="stylesheet">
<title>ガチャ結果</title>
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
    <main>
          <div class="gacha-result-view">
                    <div class="top-result-box">
                <div class="gacha-result-title">ガチャ結果</div>
                 <a href="/kumano_onigiri/GachaServlet"><img src="./img/mark_batsu.png" width="50" class="batsu"></a>
                 </div>
                 <div class="gacha-result">
                 <img src="${gachapath}" width="150" class="gacha-img">
                    <div class="gachaname">「${gachaname}」が当たりました!</div><br>
                    </div>
                    <div class="nx-text">もう一度ガチャしますか？</div><br>
                    <div class="nx-box">
                    <form id="gacha" action="/kumano_onigiri/GachaServlet" method="post">
                     <div class="nx-btn">足軽ガチャ
                     <div class="gacha-ticket">チケット数:${asi_tkt}枚</div>
                        <input type="submit" name="asigaru" value="はい" class="result-btn">
                        </div>
                         <div class="nx-btn">侍ガチャ
                         <div class="gacha-ticket">チケット数:${samu_tkt}枚</div>
                        <input type="submit" name="samurai" value="はい" class="result-btn">
                        </div>
                         <div class="nx-btn">総大将ガチャ
                         <div class="gacha-ticket">チケット数:${tai_tkt}枚</div>
                        <input type="submit" name="taisyou" value="はい" class="result-btn">
                        </div>
                    </form>
                    </div>
                </div>
    </main>
</body>
<script src="./js/common.js"></script>
<script src="./js/gacha.js"></script>
</html>