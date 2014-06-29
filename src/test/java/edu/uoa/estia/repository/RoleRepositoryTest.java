package edu.uoa.estia.repository;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Role;
import edu.uoa.estia.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class RoleRepositoryTest  {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void testSave() {
		Role role = new Role();
		role.setType("Guest");
		Assert.assertNull(role.getId());
		role = roleRepository.saveAndFlush(role);
		Assert.assertNotNull(role.getId());
	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(6, roleRepository.findAll().size());
	}
	
	@Test
	public void testFindByType() {
		Assert.assertNotNull(roleRepository.findByType("Visitor"));
	}
	
	@Test
	public void testUserJoin() {
		Role adminRole = roleRepository.findByType("Admin");
		Set<User> users = adminRole.getUsers();
		for (User user : users) {
			Assert.assertEquals("estiauser", user.getFirstName());
		}
	}
}
