<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="ValidationMessages" var="lang"/>
<div class="jumbotron text-center" style="margin-bottom:0">
	<h1><fmt:message key="header.news" bundle="${lang}"/></h1>
	<p><fmt:message key="header.title" bundle="${lang}"/></p>
</div>
<script>
	function check() {
		var checkboxes = document.getElementsByTagName("input");
		var j = 0;
		var elements = document.getElementsByName("disabledButton");
		
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].getAttribute("type") == "checkbox" && checkboxes[i].checked) {
				j++;
			}
		}
		if (j == 0) {
			for (var i = 0; i < elements.length; i++) {
				elements[i].setAttribute("disabled", "");
			}
		} else {
			for (var i = 0; i < elements.length; i++) {
				elements[i].removeAttribute("disabled");
			}
		}
		
	}
	function ok() {
		var elements;
		if (${pageContext.request.isUserInRole("ADMIN")}) {
			elements = document.querySelectorAll("[name=adminElement], [name=userElement]");
		} else if (${pageContext.request.isUserInRole("USER")}) {
			elements = document.getElementsByName("userElement");
		} else {
			elements = document.getElementsByName("guestElement");
		}
		for (var i = 0; i < elements.length; i++) {
			elements[i].removeAttribute("hidden");
		}
	}
</script>
<form id="logout" action="/logout" method="post" hidden>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="/main"><fmt:message key="header.main" bundle="${lang}"/></a>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="?lang=en"><fmt:message key="header.eng" bundle="${lang}"/></a></li>
		<li class="nav-item"><a class="nav-link" href="?lang=ru"><fmt:message key="header.rus" bundle="${lang}"/></a></li>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li name="guestElement" class="nav-item" hidden>
			<a class="nav-link" href="/loginPage"><fmt:message key="header.login" bundle="${lang}"/></a>
		</li>
		<li name="guestElement" class="nav-item" hidden>
			<a class="nav-link" href="/openReg"><fmt:message key="header.register" bundle="${lang}"/></a>
		</li>
		<li name="userElement" class="nav-item" hidden>
			<a class="nav-link" href="javascript:document.getElementById('logout').submit()"><fmt:message key="header.logout" bundle="${lang}"/></a>
		</li>
	</ul>
</nav>