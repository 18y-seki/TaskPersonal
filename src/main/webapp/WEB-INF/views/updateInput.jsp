<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="${pageContext.request.contextPath}/css/commons.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${not empty msg}">
		<p class="message">${msg}</p>
	</c:if>
	<p>
		１箇所以上の項目を変更してください<br> ※IDは変更できません
	</p>
	<form:form action="updateInput" modelAttribute="updateForm">
		<fieldset>
			<div>
				<label>ID</label>
				<form:input path="reviewId"
					readonly="true" />
			</div>
			<div>
				<label>書名</label>
				<form:input path="bookName"  />
			</div>
			<div>
				<label>著者名</label>
				<form:input path="bookAuthor" />
			</div>
			<div>
				<label>本文</label>
				<form:textarea path="reviewText" />
			</div>
		</fieldset>
		<div>
			<form:button>確認</form:button>
			<form:button onclick="location.href='review'; return false;">戻る</form:button>
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
