<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="./css/common.css" rel="stylesheet">
    <link href="./css/gacha.css" rel="stylesheet">
<title>ガチャ</title>
</head>
<body>
<header class="header">
        <div class="login_select">
            <a href="/kumano_onigiri/TopServlet"><img src="./img/apricon01.png" width="180"></a>
        </div>
        <div class="word_box">
            <div class="word">
                <div>今日の用語:<%= request.getAttribute("word") %></div>
            </div>
            <button class="word_button" onclick="location.href='/kumano_onigiri/WardServlet'">解説</button>
            </div>
        <nav id="nav">
            <ul>
                <li><a href="/kumano_onigiri/MypageServlet">拙者</a></li>
        <li><a href="/kumano_onigiri/WorkingServlet">勤怠</a></li>
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
    <main style="background-image: url('img/${bgid}.png'); background-attachment: fixed;">
        <div class="gacha-view" style="background-image: url('img/gacha_bg.jpg')">
            <div class="top-box">
                <div class="gacha-title">ガチャ</div>
                <div class="gacha-ticket-box">
                    <div class="asgr-ticket">足軽チケット　　:　<span id="asgr-ticket">${asi_tkt}</span>枚</div>
                    <div class="smri-ticket">侍チケット　　　:　<span id="smri-ticket">${samu_tkt}</span>枚</div>
                    <div class="sds-ticket">総大将チケット　:　<span id="sds-ticket">${tai_tkt}</span>枚</div>
                </div>
            </div>
            <div class="gacha-ex">チケットを一枚使ってガチャを引くことができます</div>
            <div class="gacha-ex">排出対象:マーク、背景</div>
            <div class="gacha-button">
                <button class="asigaru_pop">足軽ガチャ</button>
                <button class="samurai_pop">侍ガチャ</button>
                <button class="taisyou_pop">総大将ガチャ</button>
            </div>
        </div>
        <!-- 足軽ガチャ確認ポップアップ用の画面 -->
        <div class="modal_pop">
            <div class="bg"></div>
            <div class="modal_pop_main">
                <div class="content">
                    <div class="pop">ガチャを引いてもよろしいですか？</div><br>
                    <div class="pop-btn">
                    <form id="gacha" action="/kumano_onigiri/GachaServlet" method="post" class="asigacha">
                        <div><input type="submit" value="はい" class="gacha-modal2-open" name="asigaru"></div>
                        <div><input type="button" name="radio" value="いいえ" class="js-modal-close"></div>
                    </form>
                    <form id="gacha" action="/kumano_onigiri/GachaServlet" method="post" class="samugacha">
                        <div><input type="submit" value="はい" class="gacha-modal2-open" name="samurai"></div>
                        <div><input type="button" name="radio" value="いいえ" class="js-modal-close"></div>
                    </form>
                    <form id="gacha" action="/kumano_onigiri/GachaServlet" method="post" class="taigacha">
                        <div><input type="submit" value="はい" class="gacha-modal2-open" name="taisyou"></div>
                        <div><input type="button" name="radio" value="いいえ" class="js-modal-close"></div>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
<!-- このリンクを書くことでjqueryが使用できる -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/gacha.js"></script>
</html>