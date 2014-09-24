package edu.uoa.estia.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Akinita;
import edu.uoa.estia.domain.Property;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:test-applicationContext-service.xml"})
@Transactional
public class SearchServiceTest {

	@Autowired
	private SearchService searchservice;
	
	@Test
	public void testFindAll() {
		List<Property> ak = searchservice.findAll();
		Assert.assertNotNull(ak);
	    Assert.assertEquals(4, ak.size());
	}
}
