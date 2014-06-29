package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.PropertyType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class PropertyTypeRepositoryTest  {
	
	@Autowired
	private PropertyTypeRepository propertyTypeRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSave() {
		PropertyType propertyType = new PropertyType();
		propertyType.setType("Property Type X");
		Assert.assertNull(propertyType.getId());
		propertyType = propertyTypeRepository.saveAndFlush(propertyType);
		Assert.assertNotNull(propertyType.getId());
	}
	
	@Test
	public void testFindByType() {
		Assert.assertNotNull(propertyTypeRepository.findByType("Apartment"));
	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(2, propertyTypeRepository.findAll().size());
	}

}
