<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<title>
		<%--<fmt:message key="title.add" bundle="${lang}"/>--%>
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
			<h1><fmt:message key="title.add" bundle="${lang}"/></h1>
			<form method="POST" action="/submit">
				<input type="hidden" name="id" value="${requestScope.id}">
				<div class="row">
					<div class="col-3">
						<fmt:message key="label.title" bundle="${lang}"/>
					</div>
					<div class="col-9">
						<input type="text" style="width: 100%;" name="title" required="required" value="${requestScope.title}"/>
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<fmt:message key="label.brief" bundle="${lang}"/>
					</div>
					<div class="col-9">
						<textarea rows="7" style="width: 100%;" name="brief" required="required">${requestScope.brief}</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<fmt:message key="label.content" bundle="${lang}"/>
					</div>
					<div class="col-9">
						<textarea rows="15" style="width: 100%;" name="content" required="required">${requestScope.content}</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-3"></div>
					<div class="col-9">
						<button class="btn btn-primary" type="submit">
							<fmt:message key="button.add" bundle="${lang}"/>
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
