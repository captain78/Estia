<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
    <div id="map" class="smallmap"></div>
	<div id="intro">
	    <sec:authentication var="principal" property="principal" /> 
		<h2>${principal.domainUser.firstName} Καλώς ήρθες στην Εστία!</h2>
			<p>
			
			</p>
	</div>
</sec:authorize>