<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1><a title="Estia" href="<c:url value="/" />"><img src="<c:url value="/resources/images/logo-header-estia.png" />" alt="Estia" /></a></h1>
<div id="nav">
	<ul>
		<li><a href="<c:url value="/signin" />">Εισαγωγή(Sign In)</a></li>
		<li><a href="<c:url value="/signup" />">Εγγραφή(Join Now)</a></li>
	</ul>
</div>