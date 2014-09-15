package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Mytable;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
//@Transactional
public class MytableRepositoryTest {

	@Autowired
	private MytableRepository mytableRepository;

	final GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));
	
	@Test
	public void testSave() {
		Mytable p = new Mytable();
		p.setMyint(new Integer(1));
		p.setMytext("my ελληνικό text");
		Point point = gf.createPoint(new Coordinate(1000000,1000000));
		p.setMygeom(point);
		mytableRepository.saveAndFlush(p);
		Assert.assertEquals(1, mytableRepository.count());
		Mytable mt = mytableRepository.findByMytext("my ελληνικό text");
		Assert.assertNotNull(mt);
	}
	
}
