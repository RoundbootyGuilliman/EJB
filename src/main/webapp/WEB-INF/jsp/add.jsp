<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<title><fmt:message key="title.add" bundle="${lang}"/></title>
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
<fmt:setBundle basename="ValidationMessages" var="lang"/>

<tag:header/>
<div class="container" id="test" style="margin-top:30px">
	<div class="row">
		<tag:sidebar/>
		<div class="col-sm-8">
			<h1><fmt:message key="title.add" bundle="${lang}"/></h1>
			<form:form method="POST" action="/saveNews" modelAttribute="news">
				<form:hidden path="id"/>
				<div class="row">
					<div class="col-3">
						<form:label path="title"><fmt:message key="label.title" bundle="${lang}"/></form:label>
					</div>
					<div class="col-9">
						<form:input cssStyle="width: 100%;" path="title" required="required"/>
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<form:label path="brief"><fmt:message key="label.brief" bundle="${lang}"/></form:label>
					</div>
					<div class="col-9">
						<form:textarea rows="7" cssStyle="width: 100%;" path="brief" required="required"/>
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<form:label path="content"><fmt:message key="label.content" bundle="${lang}"/></form:label>
					</div>
					<div class="col-9">
						<form:textarea rows="15" cssStyle="width: 100%;" path="content" required="required"/>
					</div>
				</div>
				<div class="row">
					<div class="col-3"></div>
					<div class="col-9">
						<input class="btn btn-primary float-right" type="submit"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
