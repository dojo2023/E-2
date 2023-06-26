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
<form onsubmit="return mit()" method="POST" action="/kumano_onigiri/LoginServlet">
<input type="text" name="STAFF_ID" id="login_id" value="" placeholder="社員ID">
<input type="password" name="PASSWORD" id="login_pw" value="" placeholder="Password">
<a><input type="submit" name="btm" class="login_form_btm" value="login"></a>
<div class="error"></div>
</form>
</div>
<!--フッター（ここから）-->
<!--フッター(ここまで）-->
<script src="./js/login.js"></script>
</body>
</html>