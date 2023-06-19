<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コミュニティ</title>
</head>
<body>
<c:forEach var="e" items="${commList}" >
  <div>${e.writingform}</div>
 </c:forEach>
</body>
</html>