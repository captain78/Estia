package edu.uoa.estia.utils;

import java.io.IOException;

import org.geotools.geojson.geom.GeometryJSON;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vividsolutions.jts.geom.Geometry;

public class JTSGeomToGeoJSONDeserializer extends JsonDeserializer<Geometry>{

	private final GeometryJSON gjson = new GeometryJSON();
	
	public JTSGeomToGeoJSONDeserializer(){}
	
	@Override
	public Geometry deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		
		return gjson.read(parser.getText());
	
	}

}