package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.UserType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class UserTypeRepositoryTest  {
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Test
	public void testSave() {
		UserType userType = new UserType();
		userType.setType("User Type X");
		Assert.assertNull(userType.getId());
		userType = userTypeRepository.saveAndFlush(userType);
		Assert.assertNotNull(userType.getId());
	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(3, userTypeRepository.findAll().size());
	}
	
	@Test
	public void testFindByType() {
		UserType active = userTypeRepository.findByType("Active");
		Assert.assertNotNull(active);
		Assert.assertEquals(new Integer(100), active.getId());
	}
}
