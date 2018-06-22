<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

    <p class="message">${msg}</p>

<p>これでよろしいですか？</p>

<form:form action="insertConfirm" modelAttribute="insertForm" method="post">
  <fieldset class="label-110">
    <div>
      <label>書名</label><form:input path="bookName" value="${fn:escapeXml(form.bookName)}" readonly="true"/>

    </div>
    <div>
      <label>著者名</label><form:input path="bookAuthor" value="${fn:escapeXml(form.bookAuthor)}" readonly="true"/>

    </div>
    <div>
      <label>本文</label><form:textarea path="reviewText" value="${fn:escapeXml(form.reviewText)}" readonly="true"/>

    </div>
  </fieldset>
  <div>
    <form:button>投稿</form:button>
    <form:button onclick="location.href='insert'; return false;">戻る</form:button>
  </div>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
