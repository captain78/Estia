<%@ page session="false"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title"
		defaultValue="Estia" /></title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="description"
	content="A real estate web application" />
<meta name="keywords"
	content="Estia, Spring, Google Maps v3 API, GeoServer, PostgreSQL(+PostGIS), Apache HTTPD, Apache Tomcat, OpenLayers API, develop, web, mobile" />

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/OpenLayers/theme/default/style.css'/>" />
<!-- OpenLayers examples styles-->
<link rel="stylesheet"
	href="<c:url value='http://dev.openlayers.org/releases/OpenLayers-2.13.1/examples/style.css'/>"
	type="text/css">
	
<link rel="stylesheet" href="<c:url value='/resources/css/map_google.css'/>" type="text/css">

<link rel="stylesheet" href="<c:url value="/resources/css/page.css" />"
	type="text/css" media="screen" />

<tiles:useAttribute id="styles" name="styles" classname="java.util.List"
	ignore="true" />

<c:forEach var="style" items="${styles}">
	<link rel="stylesheet" href="<c:url value="/resources/css/${style}" />"
		type="text/css" media="all" />
</c:forEach>

<link rel="stylesheet" href="<c:url value='/resources/css/estia.css'/>"
	type="text/css" />

<c:forEach var="meta" items="${metadata}">
	<meta name="${meta.key}" content="${meta.value}" />
</c:forEach>

<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jquery-cookie/1.0/jquery-cookie.js" />"></script>
<!-- Google V3 API-->
<script src="http://maps.google.com/maps/api/js?v=3&amp;sensor=false"></script>
<!-- OpenLayers core js -->
<script src="<c:url value='/resources/OpenLayers/OpenLayers.js'/>"></script>
<!-- Estia core js -->
<script src="<c:url value='/resources/estia/estia.js'/>"></script>
<!-- Estia map_google js -->
<script src="<c:url value='/resources/estia/map_google.js'/>"></script>

</head>
<body onload="init()">
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="content-container">
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<tiles:useAttribute id="scripts" name="scripts"
		classname="java.util.List" ignore="true" />
	<c:forEach var="script" items="${scripts}">
		<script type="text/javascript"
			src="<c:url value="/resources/${script}" />"></script>
	</c:forEach>
	<script type="text/javascript">
		$.cookie('Estia.timeZoneOffset',
				new Date().getTimezoneOffset() * 60000);
	</script>
</body>
</html>