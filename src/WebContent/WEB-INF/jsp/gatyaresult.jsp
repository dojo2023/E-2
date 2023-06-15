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
           <div class="modal_pop2">
            <div class="modal_pop_main">
                <div class="content">
                    <div><a href="/kumano_onigiri/GachaServlet">閉じる</a></div>
                    <img src="${asiimg}" width="150">
                    <div class="pop">「${asigaru}」が当たりました!</div><br>
                    <div class="pop">足軽チケット　　:　100枚</div><br>
                    <form id="gacha" action="/kumano_onigiri/GachaServlet" method="post">
                        <div><input type="submit" name="radio" value="もう一回ガチャする" class="gacha-modal2-open"></div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>
<script src="./js/common.js"></script>
<script src="./js/gacha.js"></script>
</html>