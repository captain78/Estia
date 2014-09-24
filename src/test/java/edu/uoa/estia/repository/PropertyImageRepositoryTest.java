package edu.uoa.estia.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;

import edu.uoa.estia.domain.PropertyImage;
import edu.uoa.estia.domain.PropertyType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
//@Transactional
public class PropertyImageRepositoryTest {

	@Autowired
	private PropertyImageRepository propertyImgRepository;
	
	@Test
	public void testPropertyImageAll() {
		List<PropertyImage> images = propertyImgRepository.findAll();
		Assert.assertNotNull(images);
		Assert.assertEquals(0, images.size());
	}	
	
}
