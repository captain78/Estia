package edu.uoa.estia.repository;

import org.geotools.geojson.geom.GeometryJSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import edu.uoa.estia.domain.Akinita;
import edu.uoa.estia.domain.Property;
import edu.uoa.estia.domain.PropertyType;
import edu.uoa.estia.domain.User;
import edu.uoa.estia.utils.JTSGeomToGeoJSONSerializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
//@Transactional
public class PropertyRepositoryTest {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyTypeRepository propertyTypeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${srid.projected}")
    int SRID; // This should come from the DB at init time

	/*
	@Test
	public void testFindByIdioktitis() {
		Akinita a = new Akinita();
		Akinita ak = propertyRepository.findByIdioktitis("Alkionis ke Monterno Theatro");
		Assert.assertNotNull(ak);
		Point topo = ak.getTopothesia();
	    Assert.assertNotNull(topo);
	}
	
	@Test
	public void testGeoJSON() {
		Akinita ak = propertyRepository.fin("Alkionis ke Monterno Theatro");
		Assert.assertNotNull(ak);
		Point topo = ak.getTopothesia();
	    Assert.assertNotNull(topo);
		GeometryJSON gjson = new GeometryJSON();
		String geojson = gjson.toString(topo);
		Assert.assertNotNull(geojson);
		JTSGeomToGeoJSONSerializer k = new JTSGeomToGeoJSONSerializer();
	}
    */
    
	//"Ioulianou 44, Athina 104 34, Greece";"{"type":"Point","coordinates":[2641419.82436124,4578259.15885338]}"
	//"Titanon 3, Athina, Greece";"{"type":"Point","coordinates":[2642762.00346173,4579075.19544573]}"
	//"Zakinthou, Athina, Greece";"{"type":"Point","coordinates":[2642719.03413828,4579300.36901176]}"
	//"3ης Σεπτεμβρίου 174, Αθήνα 112 51, Ελλάδα";"{"type":"Point","coordinates":[2641821.91036198,4579393.60416694]}"
	
	@Test
	public void testCreateProperty() {
		Property p = new Property();
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING),SRID);	
		//Point topo = gf.createPoint(new Coordinate(2643617.27110949,4578327.24184474)); // in SRID:3857
		Point topo = gf.createPoint(new Coordinate(2642762.00346173,4579075.19544573)); // in SRID:3857
		User u = userRepository.findByUsername("owner");
		PropertyType pt = propertyTypeRepository.findByType("Apartment");
		p.setDieythinsi("Τιτάνων 3, Αθήνα, Ελλάδα");
		p.setUser(u); 
		p.setType(pt);
		p.setCentralHeating(true);
		p.setConstructionYear(1990);
		p.setEmvadon(95f);
		p.setKoinoxrista(100d);
		p.setOrofos(3);
		p.setRenovationYear(2000);
		p.setPrice(150000d);
		p.setTopothesia(topo);
		propertyRepository.saveAndFlush(p);
	}	
	
	@Test
	public void testCreatePropertyType() {
		PropertyType p = new PropertyType();
		p.setType("Penthouse");
		p.setOnoma("Ρετιρέ");
		propertyTypeRepository.saveAndFlush(p);
	}	
}
