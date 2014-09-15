<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

<title>Estia Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<title>Estia home page</title>

<link rel="stylesheet" href="<c:url value='/resources/css/estia.css'/>"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/OpenLayers/theme/default/style.css'/>" />
<!-- OpenLayers examples styles-->
<link rel="stylesheet"
	href="<c:url value='http://dev.openlayers.org/releases/OpenLayers-2.13.1/examples/style.css'/>"
	type="text/css">
<!-- Google V3 API-->
<script src="http://maps.google.com/maps/api/js?v=3&amp;sensor=false"></script>
<!-- OpenLayers core js -->
<script src="<c:url value='/resources/OpenLayers/OpenLayers.js'/>"></script>
<script>
	OpenLayers.ProxyHost = "../cgi-bin/proxy.cgi?url=";
	var map, infocontrols, wfs_POST, wfs_GET, highlightlayer;
	format = 'image/png';

	function init() {

		var renderer = OpenLayers.Util.getParameters(window.location.href).renderer;
		renderer = (renderer) ? [ renderer ]
				: OpenLayers.Layer.Vector.prototype.renderers;

		wfs_options = {
			url : 'http://localhost:8090/geoserver/wfs?',
			params : {
				request : "GetFeature",
				service : "wfs",
				version : "1.1.0",
				typeName : "akinita"
			},
			format : new OpenLayers.Format.GML({
				featurePrefix : "estia",
				featureType : "akinita",
				featureNS : "http://localhost/estia",
				geometryName : "topothesia", //type "Geometry"
				srsName : "EPSG:3857"
			})
		}

		// Proxy does not support this for the moment
		wfs_GET = new OpenLayers.Layer.Vector('WFS', {
			strategies : [ new OpenLayers.Strategy.Fixed() ],
			visibility : true,
			protocol : new OpenLayers.Protocol.HTTP(wfs_options),
		});
		// setup the layer containing the akinita points (through WFS protocol)
		wfs_POST = new OpenLayers.Layer.Vector("Akinita", {
			strategies : [ new OpenLayers.Strategy.Fixed() ],
			renderers : renderer,
			protocol : new OpenLayers.Protocol.WFS({
				version : "1.1.0",
				url : "http://localhost:8090/geoserver/wfs",
				featurePrefix : "estia",
				featureType : "akinita",
				featureNS : "http://localhost/estia",
				geometryName : "topothesia", //type "Geometry"
				srsName : "EPSG:3857"
			})
		});
		oria_dhmwn_kallikraths_WFS = new OpenLayers.Layer.Vector(
				"Kallikraths WFS", {
					strategies : [ new OpenLayers.Strategy.Fixed() ],
					renderers : renderer,
					protocol : new OpenLayers.Protocol.WFS({
						version : "1.1.0",
						url : "http://localhost:8090/geoserver/wfs",
						featurePrefix : "estia",
						featureType : "oria_dhmwn_kallikraths",
						featureNS : "http://localhost/estia",
						geometryName : "geom", //type "Geometry"
						srsName : "EPSG:3857"
					})
				});
		// setup the layer containing the akinita points (through WMS protocol)
		akinita = new OpenLayers.Layer.WMS("estia:akinita",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:akinita',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false
				});
		poleis = new OpenLayers.Layer.WMS("estia:poleis",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:poleis',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false
				});
		oikismoi = new OpenLayers.Layer.WMS("estia:oikismoi",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:oikismoi',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false
				});
		sxoleia = new OpenLayers.Layer.WMS("estia:sxoleia",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:sxoleia',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false
				});
		ethnika_parka = new OpenLayers.Layer.WMS("estia:ethnika_parka",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:ethnika_parka',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					opacity : 0.4,
					isBaseLayer : false
				});
		dhmosia_kthria = new OpenLayers.Layer.WMS("estia:dhmosia_kthria",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:dhmosia_kthria',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false
				});
		oria_nomwn = new OpenLayers.Layer.WMS("estia:oria_nomwn",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:oria_nomwn',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false,
					opacity : 1
				});
		oria_diamerismatwn = new OpenLayers.Layer.WMS(
				"estia:oria_diamerismatwn",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:oria_diamerismatwn',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false,
					opacity : 0.5
				});
		oria_dhmwn_kallikraths = new OpenLayers.Layer.WMS(
				"estia:oria_dhmwn_kallikraths",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:oria_dhmwn_kallikraths',
					STYLES : '',
					transparent : true,
					format : format,
				//bounds:"37.991777, 23.728375, 37.999664, 23.740434"
				}, {
					singleTile : true,
					ratio : 1,
					isBaseLayer : false,
					opacity : 0.5
				});

		highlightLayer = new OpenLayers.Layer.Vector("Highlighted Features", {
			displayInLayerSwitcher : false,
			isBaseLayer : false
		});

		ktimatologio = wms = new OpenLayers.Layer.WMS(
				'gv.layer.title.ktimatologio_gr',
				'http://gis.ktimanet.gr/wms/wmsopen/wmsserver.aspx', {
					layers : 'BASEMAP',
					transparent : true,
					format : 'image/jpeg'
				}, {
					projection : "EPSG:900913",
					//units:this.config.units,
					isBaseLayer : true,
					visibility : true,
					displayInLayerSwitcher : true,
					//tag:id,
					type : 'wms-ktimatologio',
					buffer : 0
				});

		// Create the map controls
		infoControls = {
			click : new OpenLayers.Control.WMSGetFeatureInfo({
				url : 'http://localhost:8090/geoserver/estia/wms',
				title : 'Identify features by clicking',
				layers : [ akinita ],
				queryVisible : true
			}),
			hover : new OpenLayers.Control.WMSGetFeatureInfo({
				url : 'http://demo.opengeo.org/geoserver/wms',
				title : 'Identify features by clicking',
				layers : [ akinita ],
				hover : true,
				// defining a custom format options here
				formatOptions : {
					typeName : 'akinita',
					featureNS : 'http://localhost/estia'
				},
				queryVisible : true
			})
		};
		// Create the map Object	
		map = new OpenLayers.Map('map', {
			projection : new OpenLayers.Projection("EPSG:3857"),
			layers : [ new OpenLayers.Layer.Google("Google Physical", {
				type : google.maps.MapTypeId.TERRAIN
			}), new OpenLayers.Layer.Google("Google Streets", // the default
			{
				numZoomLevels : 24
			}), new OpenLayers.Layer.Google("Google Hybrid", {
				type : google.maps.MapTypeId.HYBRID,
				numZoomLevels : 20
			}), new OpenLayers.Layer.Google("Google Satellite", {
				type : google.maps.MapTypeId.SATELLITE,
				numZoomLevels : 22
			}), ktimatologio ],
			maxResolution : 156543.0339,
			maxExtent : new OpenLayers.Bounds(-20037508.34, -20037508.34,
					20037508.34, 20037508.34),
			// Google.v3 uses web mercator as projection, so we have to
			// transform our coordinates
			center : new OpenLayers.LonLat(23.740184, 37.998923).transform(
					'EPSG:4326', 'EPSG:3857'),
			zoom : 14
		});
		// add the layers to the map Object
		//map.addLayer(oria_dhmwn_kallikraths);
		map.addLayer(oria_dhmwn_kallikraths_WFS);
		//map.addLayer(oria_diamerismatwn);
		//map.addLayer(oria_nomwn);
		//map.addLayer(ethnika_parka);
		//map.addLayer(oikismoi);
		map.addLayer(poleis);
		//map.addLayer(sxoleia);
		//map.addLayer(dhmosia_kthria);
		map.addLayer(akinita); 
		//map.addLayer(wfs_GET);  // skip this. its not supposed to wotk with the vanilla port of the proxy.cgi to Pythno 3 (3.4.1)
		map.addLayer(wfs_POST);
		map.addControl(new OpenLayers.Control.LayerSwitcher());

		// add the controls to the map Object
		for ( var i in infoControls) {
			infoControls[i].events.register("getfeatureinfo", this, showInfo);
			map.addControl(infoControls[i]);
		}
		infoControls.click.activate();

		// add behavior to html
		var animate = document.getElementById("animate");
		animate.onclick = function() {
			for (var i = map.layers.length - 1; i >= 0; --i) {
				map.layers[i].animationEnabled = this.checked;
			}
		};
	}
</script>
<!-- map_google (this page's code) js -->
<script src="<c:url value='/resources/map_google.js'/>"></script>
<!-- map_google (this page's styles) css-->
<link rel="stylesheet" href="<c:url value='/resources/map_google.css'/>" type="text/css">
</head>

<body onload="init()">
	<h1 id="title">Estia v0.1</h1>
	<div id="tags">Google, api key, apikey, light</div>
	<p id="shortdesc">Demonstrate the use of Google Maps v3 API,
		GeoServer, PostgreSQL(+PostGIS), Apache HTTPD, Apache Tomcat,
		OpenLayers API</p>
	<div id="map" class="smallmap"></div>
	<div id="docs">
		<p>
			<input id="animate" type="checkbox" checked="checked">Animated
			zoom (if supported by GMaps on your device)</input>
		</p>
		<p>
			If you use the Google Maps v3 API with a Google layer, you don't need
			to include an API key. This layer only works in the spherical
			mercator projection. See the <a href="google-v3.js" target="_blank">google-v3.js
				source</a> to see how this is done.
		</p>
	</div>
	<div id="info">
		<h1>Greece</h1>
		<p>Click on the map to get feature info.</p>
		<div id="responseText"></div>
	</div>
	<div id="settings">
		<h1>Settings</h1>
		<p>Click on the map to get feature info.</p>
		<div id="responseText">GeoServer base url:</div>
	</div>
	<div id="content">
		<h1>Home Page</h1>
		<p>Anyone can view this page.</p>
		<p>
			While anyone can also view the <a href="listAccounts.html">list
				accounts</a> page, you must be authorized to post to an Account from the
			list accounts page.
		</p>
		<p>
			Your principal object is....:
			<%=request.getUserPrincipal()%>
		</p>
		<sec:authorize url='/owner/index.jsp'>
			<p>You can currently access "/owner" URLs.</p>
		</sec:authorize>
		<sec:authorize url='/admin/index.jsp'>
			<p>You can currently access "/admin" URLs.</p>
		</sec:authorize>

		<p>
			<a href="owner/index.jsp">Secure page (owner/index.jsp)</a>
		</p>
		<p>
			<a href="admin/index.jsp">Extremely secure page (admin/index.jsp)</a>
		</p>
	</div>
	<ul id="control">
		<li><input type="radio" name="controlType" value="click"
			id="click" onclick="toggleControl(this);" checked="checked" /> <label
			for="click">Click</label></li>
		<li><input type="radio" name="controlType" value="hover"
			id="hover" onclick="toggleControl(this);" /> <label for="hover">Hover</label>
		</li>
	</ul>
	<ul id="format">
		<li><input type="radio" name="formatType" value="text/html"
			id="html" onclick="toggleFormat(this);" checked="checked" /> <label
			for="html">Show HTML Description</label></li>
		<li><input type="radio" name="formatType"
			value="application/vnd.ogc.gml" id="highlight"
			onclick="toggleFormat(this);" /> <label for="highlight">Highlight
				Feature on Map</label></li>
	</ul>
	<ul id="layers">
		<li><input type="radio" name="layerSelection" value="Specified"
			id="Specified" onclick="toggleLayers(this);" checked="checked" /> <label
			for="Specified">Get water body info</label></li>
		<li><input type="radio" name="layerSelection" value="Auto"
			id="Auto" onclick="toggleLayers(this);" /> <label for="Auto">Get
				info for visible layers</label></li>
	</ul>
</body>
</html>
