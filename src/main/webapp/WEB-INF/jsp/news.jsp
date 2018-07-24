<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
	<title>${news.title}</title>
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
			<h1>${news.title}</h1>
			<h5>${news.author}, <fmt:formatDate value="${news.date}" dateStyle="LONG"/>
			</h5>
			<div class="fakeimg">Fake Image</div>
			<p>${news.content}</p>
			<br>
			<form name="adminElement" action="/edit" method="post" hidden>
				<input type="hidden" name="id" value="${news.id}">
				<button class="btn btn-primary" type="submit">
					<fmt:message key="button.edit" bundle="${lang}"/>
				</button>
			</form>
			<br>
			<form name="adminElement" method="post" action="/delete" hidden>
				<input type="hidden" name="deleteNewsCheckbox" value="${news.id}"/>
				<button class="btn btn-primary" type="submit"><fmt:message key="button.delete" bundle="${lang}"/></button>
			</form>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
