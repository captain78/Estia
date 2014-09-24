<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<sec:authorize access="isAuthenticated()">
	<div id="map" class="smallmap"></div>
	<div id="intro">
	   <h2>Αναζήτηση:</h2>
			<p>
			   
			 </p>
	</div>
</sec:authorize>