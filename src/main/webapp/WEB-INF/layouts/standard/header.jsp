<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<h1><a title="Εστία" href="<c:url value="/" />"><img src="<c:url value="/resources/images/logo-header-estia.png" />" alt="Εστία" /></a></h1>
<div id="nav">
	<ul>
		<sec:authorize access="!isAuthenticated()">
		     <li><a href="<c:url value="/signin" />">Εισαγωγή(Sign In)</a></li>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		            <!-- Create a scoped variable for usage in this page -->
		            <sec:authentication var="principal" property="principal" /> 
		     		<%=request.getUserPrincipal()%>
		     		<li><a href="<c:url value="/invite" />">Invite</a></li>
					<li><a href="<c:url value="/events" />">Events</a></li>
					<li><a href="<c:url value="/develop/apps" />">Develop</a></li>
					<li><a href="<c:url value="/settings" />">Settings</a></li>
					<li><a href="<c:url value="/signout" />">Sign Out</a></li>
		</sec:authorize>
			
	</ul>
</div>
