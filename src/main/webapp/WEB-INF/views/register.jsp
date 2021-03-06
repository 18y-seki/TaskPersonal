<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>${msg}</p>
<p>ユーザ登録を行います</p>
<p>名前とパスワードを入力してください</p>

	<form:form action="register" modelAttribute="loginForm">
		<fieldset>
			<div>
				<label>名前</label>
				<form:input path="userName" />
			</div>
			<div>
				<label>PASS</label>
				<form:password path="password" />
			</div>
		</fieldset>
		<form:button>登録</form:button>
	</form:form>

<div>
  <a href="index">TOP画面へ</a>
</div>
</body>
</html>
