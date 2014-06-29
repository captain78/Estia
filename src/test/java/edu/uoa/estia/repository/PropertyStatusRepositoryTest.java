package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.PropertyStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class PropertyStatusRepositoryTest  {
	
	@Autowired
	private PropertyStatusRepository propertyStatusRepository;
	
	@Test
	public void testSave() {
		PropertyStatus propertyStatus = new PropertyStatus();
		propertyStatus.setStatus("Property Status X");
		Assert.assertNull(propertyStatus.getId());
		propertyStatus = propertyStatusRepository.saveAndFlush(propertyStatus);
		Assert.assertNotNull(propertyStatus.getId());
	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(2, propertyStatusRepository.findAll().size());
	}
}
