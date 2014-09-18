package edu.uoa.estia.repository;

import java.util.HashSet;
import java.util.Set;

import org.geotools.geojson.geom.GeometryJSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Akinita;
import edu.uoa.estia.utils.GeometryUtils;
import edu.uoa.estia.utils.JTSGeomToGeoJSONSerializer;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
@Transactional
public class AkinitaRepositoryTest {
	
	@Autowired
	private AkinitaRepository akinitaRepository;
	
	final int SRID = 3857; // This should come from the DB at init time
    final GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING),SRID);
	
    
	@Test
	public void testFindByIdioktitis() {
		Akinita a = new Akinita();
		Akinita ak = akinitaRepository.findByIdioktitis("Alkionis ke Monterno Theatro");
		Assert.assertNotNull(ak);
		Point topo = ak.getTopothesia();
	    Assert.assertNotNull(topo);
	}
	
	@Test
	public void testGeoJSON() {
		Akinita ak = akinitaRepository.findByIdioktitis("Alkionis ke Monterno Theatro");
		Assert.assertNotNull(ak);
		Point topo = ak.getTopothesia();
	    Assert.assertNotNull(topo);
		GeometryJSON gjson = new GeometryJSON();
		String geojson = gjson.toString(topo);
		Assert.assertNotNull(geojson);
		JTSGeomToGeoJSONSerializer k = new JTSGeomToGeoJSONSerializer();
	}
    
    
	@Test
	public void testCreateAkinito() {
		Akinita a = new Akinita();
		Point topo = gf.createPoint(new Coordinate(2643617.27110949,4578327.24184474)); // in SRID:3857
		a.setDieythinsi("JUnit Test Διέυθυνση");
		a.setIdioktitis("Παπαλέκας");
		a.setTopothesia(topo);
		akinitaRepository.saveAndFlush(a);
	}	


}
