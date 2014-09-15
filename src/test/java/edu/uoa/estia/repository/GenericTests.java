package edu.uoa.estia.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import edu.uoa.estia.domain.Mytable;

@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
public class GenericTests {

	@Autowired
	private MytableRepository mytableRepository;

	final GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));
	
	public void testSave() {
		Mytable p = new Mytable();
		p.setMyint(new Integer(1));
		p.setMytext("my ελληνικό text");
		Point point = gf.createPoint(new Coordinate(1000000,1000000));
		p.setMygeom(point);
		mytableRepository.saveAndFlush(p);
		Mytable mt = mytableRepository.findByMytext("my ελληνικό text");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTests gt = new GenericTests();
		gt.testSave();
	}

}
