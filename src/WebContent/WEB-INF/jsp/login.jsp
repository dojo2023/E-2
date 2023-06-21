<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>拙者の！Garden！</title>
<link rel="stylesheet" href="/kumano_onigiri/css/login.css">
</head>
<body>

<!--ヘッダー (ここから)-->
<header class="header">
<div class="login_select">
<img src="img/apricon01.png" width="180">
</div>
<div class="wrapper">
<p><span id="greeting"></span></p>
</div>
</header>
<!--ヘッダー (ここまで)-->
<div class="banana">
<h2>ログイン</h2>
<form id="login_form" method="POST" action="/kumano_onigiri/LoginServlet">
社員ID<br><input type="text" name="STAFF_ID"><br>
password<br><input type="password" name="PASSWORD">
<a><input type="submit" name="ログイン" class="login_form_btm" value="login"></a>
</form>
</div>
<!--フッター（ここから）-->
<!--フッター(ここまで）-->
<script src="js/login.js"></script>
</body>
</html>