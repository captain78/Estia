package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class PropertyRepositoryTest  {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyTypeRepository propertyTypeRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Test
	public void testSave() {
		Property property = createProperty();
		Assert.assertNull(property.getId());
		property = propertyRepository.saveAndFlush(property);		
		Assert.assertNotNull(property.getId());
	}
	
	private Property createProperty() {
		Property property = new Property();
		property.setType(propertyTypeRepository.findByType("House"));
		property.setUser(userRepository.findByUsername("estiauser"));
		return property;
	}

	@Test
	public void testFindAll() {
		int before = propertyRepository.findAll().size();
		Property property = createProperty();
		propertyRepository.saveAndFlush(property);
		Assert.assertEquals(before + 1, propertyRepository.findAll().size());
	}
}
