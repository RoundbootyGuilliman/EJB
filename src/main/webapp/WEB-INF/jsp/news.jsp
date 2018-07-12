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
			<a href="/edit/${news.id}"><button type="button"><fmt:message key="button.edit" bundle="${lang}"/></button></a>
			<br><br>
			<form name="adminElement" method="post" action="/delete" hidden>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="deleteNewsCheckbox" value="${news.id}"/>
				<button type="submit"><fmt:message key="button.delete" bundle="${lang}"/></button>
			</form>
			
			<c:choose>
				<c:when test="${fn:length(news.comments) == 0}">
					<h3><fmt:message key="label.noComments" bundle="${lang}"/></h3>
				</c:when>
				<c:otherwise>
					<h3>${fn:length(news.comments)} <fmt:message key="label.comments" bundle="${lang}"/></h3>
				</c:otherwise>
			</c:choose>
			<hr>
			<c:forEach var="comment" items="${news.comments}">
				<b>${comment.username}, <fmt:formatDate value="${comment.date}" dateStyle="MEDIUM"/>:</b>
				<br>
				${comment.comment}
				<br><br>
				<div name="adminElement" class="row" hidden>
					<div class="col" style="padding-right: 0;">
						<div class="checkbox-primary">
							<input onclick="check()" name="deleteCommsCheckbox" form="deleteComments" type="checkbox" value="${comment.id}"/> <fmt:message key="checkbox.mark" bundle="${lang}"/>
						</div>
					</div>
				</div>
				<hr>
			</c:forEach>
			<form id="deleteComments" name="adminElement" method="post" action="/deleteComments" hidden>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="newsId" value="${news.id}"/>
				<button name="disabledButton" type="submit" disabled><fmt:message key="button.deleteComments" bundle="${lang}"/></button>
			</form>
			<div name="userElement" hidden>
				<h4><fmt:message key="label.comment" bundle="${lang}"/></h4>
				<form:form method="POST" action="/comment" modelAttribute="comment">
					<input type="hidden" name="newsId" value="${news.id}"/>
					<textarea rows="7" style="width: 100%;" name="comment" required></textarea>
					<button type="submit"><fmt:message key="button.comment" bundle="${lang}"/></button>
				</form:form>
			</div>
			<div name="guestElement" hidden>
				<h4><fmt:message key="label.login" bundle="${lang}"/></h4>
				<a href="/loginPage"><button type="button"><fmt:message key="header.login" bundle="${lang}"/></button></a>
			</div>
		</div>
	</div>
</div>

<tag:footer/>

</body>
</html>
