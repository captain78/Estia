package edu.uoa.estia.utils;

import java.io.IOException;

import org.geotools.geojson.geom.GeometryJSON;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Geometry;

public class JTSGeomToGeoJSONSerializer extends JsonSerializer<Geometry>{

	private final GeometryJSON gjson = new GeometryJSON();
	
	public JTSGeomToGeoJSONSerializer(){}
	
	@Override
	public void serialize(Geometry geom, JsonGenerator gen,
			SerializerProvider prov) throws IOException,
			JsonProcessingException {
		
		gen.writeString(gjson.toString(geom));
        //gen.writeUTF8String(arg0, arg1, arg2);
	}
}