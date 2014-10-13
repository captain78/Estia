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
		propertiesWFS = new OpenLayers.Layer.Vector("Ακίνητα", {
			strategies : [ new OpenLayers.Strategy.Fixed() ],
			renderers : renderer,
			protocol : new OpenLayers.Protocol.WFS({
				version : "1.1.0",
				url : "http://localhost:8090/geoserver/wfs",
				featurePrefix : "estia",
				featureType : "property",
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
		propertiesWMS = new OpenLayers.Layer.WMS("Ακίνητα-WMS",
				"http://localhost:8090/geoserver/estia/wms", {
					srs : 'EPSG:3857',
					LAYERS : 'estia:property',
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
		//map.addLayer(oria_dhmwn_kallikraths_WFS);
		//map.addLayer(oria_diamerismatwn);
		//map.addLayer(oria_nomwn);
		//map.addLayer(ethnika_parka);
		//map.addLayer(oikismoi);
		//map.addLayer(poleis);
		//map.addLayer(sxoleia);
		//map.addLayer(dhmosia_kthria);
		//map.addLayer(akinita); 
		map.addLayer(propertiesWMS);
		map.addLayer(propertiesWFS);
		//map.addLayer(wfs_GET);  // skip this. its not supposed to wotk with the vanilla port of the proxy.cgi to Pythno 3 (3.4.1)
		//map.addLayer(wfs_POST);
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