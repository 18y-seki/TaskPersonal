<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
   <c:if test="${not empty msg}">
    <p class="message"><span class="required"></span>${msg}</p>
  </c:if>
<p>本当に削除しますか？<br>

<form:form action="delete" modelAttribute="selectForm">
  <fieldset>
    <div>
      書名：<input type="text" value="${fn:escapeXml(review.bookName)}" readonly>
    </div>
     <div>
      投稿者名：<input type="text" value="${fn:escapeXml(review.reviewUser)}" readonly>
    </div>
  </fieldset>
  <form:button>確認</form:button>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
