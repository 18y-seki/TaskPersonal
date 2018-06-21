<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>記事を表示します</p>

<table>
  <caption>レビュー記事</caption>
<thead>
    <tr>
      <th>書名：${fn:escapeXml(review.bookName)}</th>
      <th>著者名：${fn:escapeXml(review.bookAuthor)}</th>
    </tr>
     <tr>
      <th>投稿者名：${fn:escapeXml(review.reviewUser)}</th>
      <th>投稿日時：${fn:escapeXml(review.reviewDate)}</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td colspan="2">
      ${fn:escapeXml(review.reviewText)}
      </td>
    </tr>
    </table>

  <a href="update">編集</a>

  <a href="delete">削除</a>


<div>
  <a href="menu">メニューへ戻る</a>
</div>

</body>
</html>
