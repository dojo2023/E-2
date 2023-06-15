<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガチャ</title>
</head>
<body>
<header class="header">
        <div class="login_select">
            <img src="apricon01.png" width="180">
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
        <div class="gacha-view">
            <div class="top-box">
                <div class="gacha-title">ガチャ</div>
                <div class="gacha-ticket-box">
                    <div class="gacha-ticket">足軽チケット　　:　100枚</div>
                    <div class="gacha-ticket">侍チケット　　　:　10枚</div>
                    <div class="gacha-ticket">総大将チケット　:　1枚</div>
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
                    <form id="gacha" action="">
                        <div><input type="button" name="radio" value="はい" class="gacha-modal2-open"></div>
                        <div><input type="button" name="radio" value="いいえ" class="js-modal-close"></div>
                    </form>
                </div>
            </div>
        </div>
           <!-- 排出ポップアップ用の画面-->
           <div class="modal_pop2">
            <div class="modal_pop_main">
                <div class="content">
                    <div class="js-modal2-close">閉じる</div>
                    <img src="自販機.png" width="150">
                    <div class="pop">マーク「自販機」が当たりました!</div><br>
                    <div class="pop">足軽チケット　　:　100枚</div><br>
                    <form id="quiz" action="">
                        <div><input type="button" name="radio" value="もう一回ガチャする" class="gacha-modal2-open"></div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>
</html>