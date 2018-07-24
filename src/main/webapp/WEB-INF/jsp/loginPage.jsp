<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<title>
		<%--<fmt:message key="title.login" bundle="${lang}"/>--%>
	</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<style>
		.fakeimg {
			height: 200px;
			background: #aaa;
		}
	</style>
</head>
<body onload="ok()">
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="ValidationMessages" var="lang"/>
<tag:header/>
<div class="container" id="test" style="margin-top:30px">
	${requestScope.error}<br>
	<form name="login" action="/login" method="POST">
		<table>
			<tr>
				<td><fmt:message key="label.email" bundle="${lang}"/>:</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td><fmt:message key="label.password" bundle="${lang}"/>:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><button class="btn btn-primary" type="submit"><fmt:message key="header.login" bundle="${lang}"/></button></td>
			</tr>
		</table>
	</form>
</div>

<tag:footer/>

</body>
</html>
