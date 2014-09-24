<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="profile" class="listing">
	<!-- <img src="${profile.pictureUrl}" alt="Profile Picture" />  -->
	<h2><c:out value="${profile.firstName} ${profile.lastName}" /></h2>
	
	<!-- 
	<ul id="connectedProfiles">
		<c:forEach var="connectedProfile" items="${connectedProfiles}">
		<li><a href="${connectedProfile.url}">${connectedProfile.name}</a></li>
		</c:forEach>
	</ul>
	 -->
</div> 
<div id="fb-root"></div>
