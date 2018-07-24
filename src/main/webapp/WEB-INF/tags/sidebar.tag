<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="ValidationMessages" var="lang"/>

<div class="col-sm-4">
	<h2 name="guestElement" hidden><fmt:message key="sidebar.notLoggedIn" bundle="${lang}"/></h2>
	
	<c:if test="${not empty sessionScope.auth}">
	<h2>${sessionScope.auth.username}</h2>
	</c:if>
	
	<div class="fakeimg">Fake Image</div>
	<br>
	<h4 style="display:inline-block" name="userElement" hidden><fmt:message key="sidebar.rights" bundle="${lang}"/> User</h4><h4 style="display:inline-block" name="adminElement" hidden>, Admin</h4>
	<ul class="nav nav-pills flex-column">
		<li class="nav-item"><a class="btn btn-outline-success btn-block" href="/add">
			<fmt:message key="sidebar.add" bundle="${lang}"/></a>
		</li>
	</ul>
	<hr class="d-sm-none">
</div>