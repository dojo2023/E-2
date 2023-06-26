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
                <li><a href="/kumano_onigiri/MypageServlet">拙者</a></li>
        <li><a href="/kumano_onigiri/Work_listServlet">勤怠</a></li>
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
                     <div class="asgr-ticket">チケット数:<span id="asgr-ticket">${asi_tkt}</span>枚</div>
                        <input type="submit" name="asigaru" value="はい" class="asgr_result-btn">
                        </div>
                         <div class="nx-btn">侍ガチャ
                         <div class="smri-ticket">チケット数:<span id="smri-ticket">${samu_tkt}</span>枚</div>
                        <input type="submit" name="samurai" value="はい" class="smri_result-btn">
                        </div>
                         <div class="nx-btn">総大将ガチャ
                         <div class="sds-ticket">チケット数:<span id="sds-ticket">${tai_tkt}</span>枚</div>
                        <input type="submit" name="taisyou" value="はい" class="sds_result-btn">
                        </div>
                    </form>
                    </div>
                </div>
    </main>
</body>
<!-- このリンクを書くことでjqueryが使用できる -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/common.js"></script>
<script>
$(function() {
	  if($('#asgr-ticket').text() == "0"){
	  $('.asgr_result-btn').prop('disabled',true);
	  $('.asgr_result-btn').css('background-color','rgb(116, 166, 216)');
	  $('.asgr_result-btn').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
	  }
	  if($('#smri-ticket').text() == "0"){
	  $('.smri_result-btn').prop('disabled',true);
	  $('.smri_result-btn').css('background-color','rgb(116, 166, 216)');
	  $('.smri_result-btn').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
	  }
	  if($('#sds-ticket').text() == "0"){
	  $('.sds_result-btn').prop('disabled',true);
	  $('.sds_result-btn').css('background-color','rgb(116, 166, 216)');
	  $('.sds_result-btn').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
	  }
	});
</script>
</html>