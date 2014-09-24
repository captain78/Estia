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
	// μεγιστησ 14, αθηνα 113 61  "POINT(2642692.98537744 4579805.967893)"
	// σταυραετού 17, ζωγραφου 157 72    "POINT(2646046.70767657 4575998.40783071)"
	// δικεάρχου 156, Βύρωνας 116 32 "POINT(2643315.37265047 4573787.70722493)"
	// καλαμών 32 , Γαλάτσι 11 47 "POINT(2644211.27191237 4580756.62841776)"	
	// σαμαρά 22, Ψυχικό   154 52  "POINT(2646365.86065667 4581635.59728266)"
	// καλλιγά 43, Φιλοθέη 152 37 "POINT(2647818.13473356 4582901.55092342)"
	// επιδάυρου 73, πολύδροσο 152 33  "POINT(2649920.18067821 4583479.6821374)"
	// κύπρου 26, βριλήσσια 152 35 "POINT(2653187.85301096 4584196.20829953)"
	// πίνδου 23, βριλήσσια 152 35  "POINT(2653101.91436406 4584611.87273375)"
	// Ηρακλειδών 56, Νέο Ηράκλειο 141 21  "POINT(2645930.49012818 4585427.56200019)"
	// Κολοκοτρώνη 93, Νεο ηράκλειο 141 21  "POINT(2646258.10338958 4586610.43270481)"
	// Διονύσου 15, Κηφισιά 145 62  "POINT(2650999.08918298 4590351.33142519)"
	// Αναξαγόρα 14, νέα ερυθραία 145 62   "POINT(2651539.21135231 4592224.55135272)"	
	// Πλαπούτα 16-26, Μεταμόρφωση   "POINT(2644449.49562266 4588387.11316268)"
	// Λυκούργου 3, Κορυδαλλός 181 20 "POINT(2632397.04567397 4576001.23222601)"
	// Κνωσού 25, Νίκαια 184 51  "POINT(2631616.02812656 4575077.97839304)"
	
	// Θράκης 76-84, Πετρούπολη "POINT(2636826.44821263 4585285.64921568)"
	// Πάρου 6, Περιστέρι 121 36 "POINT(2636583.32644474 4581291.40447833)"
	
	@Test
	public void testCreateProperty() {
		Property p = new Property();
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING),SRID);	
		Point topo = gf.createPoint(new Coordinate(2636583.32644474 , 4581291.40447833)); // in SRID:3857
		User u = userRepository.findByUsername("owner");
		PropertyType pt = propertyTypeRepository.findByType("Apartment");
		p.setDieythinsi("Πάρου 6, Περιστέρι 121 36");
		p.setUser(u); 
		p.setType(pt);
		p.setCentralHeating(true);
		p.setConstructionYear(1997);
		p.setEmvadon(92f);
		p.setKoinoxrista(95d);
		p.setOrofos(1);
		p.setRenovationYear(2013);
		p.setPrice(360000d);
		p.setTopothesia(topo);
		propertyRepository.saveAndFlush(p);
	}	
	
	@Test
	public void testUpdateProperty() {
		GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING),SRID);	
		Property p = propertyRepository.findById(5);
		if(p.getConstructionYear()==1986)
			p.setTopothesia(gf.createPoint(new Coordinate(2642692.98537744 , 4579805.967893)));
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
