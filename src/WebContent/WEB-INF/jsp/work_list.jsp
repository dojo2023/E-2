<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>拙者の！Garden！|勤怠一覧</title>
<link rel="stylesheet" href="/kumano_onigiri/css/common.css">
<link rel="stylesheet" href="/kumano_onigiri/css/work_list.css">
</head>
<body>
<header>
	<div class="login_select">
		<img src="img/apricon01.png" width="180">
    </div>
    <div class="word_box">
    	<div class="word">
			<div>今日の用語:SQLインジェクション</div>
        </div>
      	<!-- <div class="word_button">
			<button onclick="location.href='/kumano_onigiri/WardServlet'">解説</button></div>
        </div> -->
        <button class="word_button" onclick="location.href='/kumano_onigiri/WardServlet'">解説</button>
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

<main>
<div>
  <table class="w_select">
    <tr>
      <th>社員を選択</th><th>年を選択</th><th>月を選択</th>
    </tr>
    <tr class="select">
      <th><select id="staff" name="staff">
            <option value="hokkaido">0001</option>
            <option value="aomori">0002</option>
            <option value="iwate">0003</option>
          </select>
      </th>
      <th><select id="year" name="year">
            <option value="hokkaido">2023年</option>
            <option value="aomori">2022年</option>
            <option value="iwate">2021年</option>
          </select>
      </th>
      <th><select id="month" name="month">
            <option value="hokkaido">1月</option>
            <option value="aomori">2月</option>
            <option value="iwate">3月</option>
          </select>
      </th>
    </tr>
  </table>
</div>
<div id="table">
    <table class="work_list">
        <tr>
            <th>日付</th><th>出勤時間</th><th>退勤時間</th><th>勤務形態</th><th>実働時間</th>
        </tr>
        <tr class="data_row"><td>6月1日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月2日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月3日</td><td>9:00</td><td>18:00</td><td>在宅</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月4日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月5日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月6日</td><td>9:00</td><td>18:00</td><td>在宅</td><td>9時間</td></tr>
        <tr class="data_row"><td>6月7日</td><td>9:00</td><td>18:00</td><td>出社</td><td>9時間</td></tr>
    </table>
</div>
<h2 class="work_sum">合計実働時間<br>63時間</h2>
</main>
</body>
<script src="js/common.js"></script>
</html>