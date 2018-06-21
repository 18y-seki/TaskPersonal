<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form:form action="review" modelAttribute="selectForm">
		<div class="container">
			<table class="table">
				<caption>検索結果</caption>
				<thead>
					<tr>
						<th>記事ID</th>
						<th>書名</th>
						<th>著者名</th>
						<th>記事投稿者</th>
						<th>記事投稿日</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="review" items="${reviewList}">
						<tr>
							<td><input type="submit" name="id"
								value="${fn:escapeXml(review.reviewId)}"></td>
							<td>${fn:escapeXml(review.bookName)}</td>
							<td>${fn:escapeXml(review.bookAuthor)}</td>
							<td>${fn:escapeXml(review.reviewUser)}</td>
							<td>${fn:escapeXml(review.reviewDate)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>
	<a href="menu">メニューへ戻る</a>
</body>
</html>
