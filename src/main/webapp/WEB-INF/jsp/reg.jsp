<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
	<title>
		<%--<fmt:message key="title.reg"/>--%>
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
	<div class="row">
		<tag:sidebar/>
		<div class="col-sm-8">
			<h1><fmt:message key="label.register" bundle="${lang}"/></h1>
			<form action="/register" method="POST">
				
				<div class="row">
					<div class="col-3">
						<fmt:message key="label.username" bundle="${lang}"/>
					</div>
					<div class="col-9">
						<input type="text" style="width: 100%;" name="username"/>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-3">
						<fmt:message key="label.email" bundle="${lang}"/>
					</div>
					<div class="col-9">
						<input type="text" style="width: 100%;" name="email"/>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-3">
						<fmt:message key="label.password" bundle="${lang}"/>
					</div>
					<div class="col-9">
						<input type="password" style="width: 100%;" name="password"/>
					</div>
				</div>
				<br>
				<%--<div class="row">--%>
					<%--<div class="col-3">--%>
						<%--<fmt:message key="label.match"/>--%>
					<%--</div>--%>
					<%--<div class="col-9">--%>
						<%--<input type="password" cssStyle="width: 100%;" name="matchingPassword"/>--%>
					<%--</div>--%>
				<%--</div>--%>
				<%--<br>--%>
				<div class="row">
					<div class="col-3"></div>
					<div class="col-9">
						<button class="btn btn-primary" type="submit">
							<fmt:message key="button.register" bundle="${lang}"/>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>